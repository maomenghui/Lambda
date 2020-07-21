package com.why.project.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.why.project.common.DateUtils;
import com.why.project.common.JDBCUtils;
import com.why.project.common.MathUtils;
import com.why.project.entity.GrossOutput;
import com.why.project.entity.Zwkmye2020;
import com.why.project.mapper.GrossOutputMapper;
import com.why.project.service.IGrossOutputService;
import com.why.project.service.IZwkmyeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 总产出月报采集卡Service业务层处理
 *
 * @author maomh
 * @date 2020-07-07
 */
@Service
public class GrossOutputServiceImpl implements IGrossOutputService {
    @Autowired
    private GrossOutputMapper grossOutputMapper;

    @Autowired
    private IZwkmyeService zwkmye2020Service;

    /**
     * 生成报表数据插入到数据库
     *
     * @return 报表数据
     */
    @Override
    public String createReport(List<Zwkmye2020> datas) {
        return getAndSetData(datas);
    }

    private String getAndSetData(List<Zwkmye2020> datas) {
        Map map = new HashMap<String, BigDecimal>();
        // 总产出 (CT01=CT02-CT03+CT04+CT05+CT06+CT07+CT08+CT09+CT16)
        BigDecimal grossOutput = new BigDecimal(0);

        BigDecimal num5011 = MathUtils.filterDataBorrow(datas, "5011");
        BigDecimal num2201 = MathUtils.filterDataBorrow(datas, "2201");
        BigDecimal num5501 = MathUtils.filterDataBorrow(datas, "5501");
        BigDecimal num5506 = MathUtils.filterDataBorrow(datas, "5506");
        // 科研成本借方累计发生额                      5011借方发生数+2201借方余额+5501借方余额+5506借方余额
        BigDecimal researchCost = MathUtils.getBigDecimalSum(num5011, num2201, num5501, num5506);

        // 固定资产折旧(本年折旧）                     1502贷方发生数
        BigDecimal num1502 = MathUtils.filterDataLoan(datas, "1502");

        // 营业盈余(CT16=CT17-CT18-C19-C20）           CT17-CT18-CT20
        BigDecimal earnedSurplus = new BigDecimal(0);

        grossOutput = MathUtils.getBigDecimalSum(researchCost, earnedSurplus);

        // 营业利润                                    表2第45行 营业利润（亏损以“－”号填列）（1-6+33+36）行
        BigDecimal operateProfit = grossOutput;

        BigDecimal num450101 = MathUtils.filterDataBorrow(datas, "450101");
        BigDecimal num45010202 = MathUtils.filterDataBorrow(datas, "45010202");
        // 投资收益 表2第36行（450101+45010202）借方发生数
        BigDecimal investmentIncome = MathUtils.getBigDecimalSum(num450101, num45010202);

        // 资产处置收益
        BigDecimal assetDisposalIncome = new BigDecimal(0);

        // 其他收益 表2第33行 450106借方发生数
        BigDecimal num450106 = MathUtils.filterDataBorrow(datas, "450106");

        earnedSurplus = operateProfit.subtract(investmentIncome).subtract(num450106);
        setResult(map, grossOutput, researchCost, num1502, earnedSurplus, operateProfit, investmentIncome, assetDisposalIncome, num450106);

        GrossOutput grossOutput1 = new GrossOutput(grossOutput, researchCost, num1502, earnedSurplus, operateProfit,
                investmentIncome,assetDisposalIncome, num450106);
        insertGrossOutput(grossOutput1);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("总产出月报采集卡", map);
        return jsonObject.toJSONString();
    }

    private void setResult(Map map, BigDecimal grossOutput, BigDecimal researchCost, BigDecimal num1502, BigDecimal earnedSurplus, BigDecimal operateProfit, BigDecimal investmentIncome, BigDecimal assetDisposalIncome, BigDecimal num450106) {
        map.put("总产出", grossOutput);
        map.put("科研成本借方累计发生额", researchCost);
        map.put("固定资产折旧", num1502);
        map.put("营业盈余", earnedSurplus);
        map.put("营业利润", operateProfit);
        map.put("投资收益", investmentIncome);
        map.put("资产处置收益", assetDisposalIncome);
        map.put("其他收益", num450106);

    }

    /**
     * 查询总产出月报采集卡
     *
     * @param id 总产出月报采集卡ID
     * @return 总产出月报采集卡
     */
    @Override
    public GrossOutput selectGrossOutputById(Long id) {
        return grossOutputMapper.selectGrossOutputById(id);
    }

    /**
     * 查询总产出月报采集卡列表
     *
     * @param grossOutput 总产出月报采集卡
     * @return 总产出月报采集卡
     */
    @Override
    public List<GrossOutput> selectGrossOutputList(GrossOutput grossOutput) {
        return grossOutputMapper.selectGrossOutputList(grossOutput);
    }

    /**
     * 新增总产出月报采集卡
     *
     * @param grossOutput 总产出月报采集卡
     * @return 结果
     */
    @Override
    public int insertGrossOutput(GrossOutput grossOutput) {
        if (StringUtils.isEmpty(grossOutput.getCfKjq())) {
            grossOutput.setCfKjq(DateUtils.getMonth());
        }
        if (StringUtils.isEmpty(grossOutput.getCfKjnd())) {
            grossOutput.setCfKjnd(DateUtils.getYear());
        }
        deleteGrossOutputById(grossOutput);
        return grossOutputMapper.insertGrossOutput(grossOutput);
    }

    /**
     * 修改总产出月报采集卡
     *
     * @param grossOutput 总产出月报采集卡
     * @return 结果
     */
    @Override
    public int updateGrossOutput(GrossOutput grossOutput) {
        return grossOutputMapper.updateGrossOutput(grossOutput);
    }

    /**
     * 删除总产出月报采集卡对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGrossOutputByIds(String ids) {
        return grossOutputMapper.deleteGrossOutputByIds(null);
    }

    /**
     * 删除总产出月报采集卡信息
     *
     * @return 结果
     */
    @Override
    public int deleteGrossOutputById(GrossOutput grossOutput) {
        return grossOutputMapper.deleteGrossOutputById(grossOutput);
    }
}
