package com.why.project.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.why.project.common.DateUtils;
import com.why.project.common.JDBCUtils;
import com.why.project.common.MathUtils;
import com.why.project.entity.IncomeProfitStatus;
import com.why.project.entity.Zwkmye2020;
import com.why.project.mapper.IncomeProfitStatusMapper;
import com.why.project.service.IIncomeProfitStatusService;
import com.why.project.service.IZwkmyeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 收入利润情况月报采集卡Service业务层处理
 *
 * @author maomh
 * @date 2020-07-07
 */
@Service
public class IncomeProfitStatusServiceImpl implements IIncomeProfitStatusService {
    @Autowired
    private IncomeProfitStatusMapper incomeProfitStatusMapper;

    @Autowired
    private IZwkmyeService zwkmye2020Service;
    /**
     * 查询收入利润情况月报采集卡
     *
     * @param id 收入利润情况月报采集卡ID
     * @return 收入利润情况月报采集卡
     */
    @Override
    public IncomeProfitStatus selectIncomeProfitStatusById(Long id) {
        return incomeProfitStatusMapper.selectIncomeProfitStatusById(id);
    }

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
        BigDecimal num4102 = MathUtils.filterDataBorrow(datas, "4102");
        BigDecimal num500101 = MathUtils.filterDataLoan(datas, "500101");
        BigDecimal num450105 = MathUtils.filterDataBorrow(datas, "450105");
        BigDecimal num450107 = MathUtils.filterDataBorrow(datas, "450107");
        BigDecimal num450199 = MathUtils.filterDataBorrow(datas, "450199");
        // 营业收入  4102借方发生数+500101贷方发生数+（450105+450107+450199）借方发生数
        BigDecimal operateIncome = MathUtils.getBigDecimalSum(num4102, num500101, num450105, num450107, num450199);

        // 其中：宇航产品收入  4102借方发生数+500101贷方发生数+（450105+450107+450199）借方发生数
        BigDecimal productIncome = operateIncome;

        BigDecimal num5011 = MathUtils.filterDataLoan(datas, "5011");
        BigDecimal num501104 = MathUtils.filterDataLoan(datas, "501104");
        BigDecimal num54019902 = MathUtils.filterDataLoan(datas, "54019902");
        // 营业成本 （5011-501104+500101+54019902）贷方发生数
        BigDecimal operateCosts = MathUtils.getBigDecimalSum(num5011.subtract(num501104), num500101, num54019902);

        // 其中：宇航产品成本     （5011-501104+500101+54019902）贷方发生数
        BigDecimal productCost = operateCosts;

        // 税金及附加 5509贷方发生数
        BigDecimal num5509 = MathUtils.filterDataLoan(datas, "5509");

        // 管理费用   501104贷方发生数-I128行
        BigDecimal managerCost = num501104;

        // 业务招待费 550508借方发生数
        BigDecimal num550508 = MathUtils.filterDataBorrow(datas, "5509");

        // 差旅费     550512借方发生数
        BigDecimal num550512 = MathUtils.filterDataBorrow(datas, "550512");

        // 办公费     550507借方发生数
        BigDecimal num550507 = MathUtils.filterDataBorrow(datas, "550507");

        // 财务费用   I087-I129
        BigDecimal financeCost = new BigDecimal(0);

        // 其中：利息支出 5506贷方发生数
        BigDecimal num5506 = MathUtils.filterDataLoan(datas, "5506");

        // 利息收入   45010201借方发生数
        BigDecimal num45010201 = MathUtils.filterDataBorrow(datas, "45010201");
        financeCost = MathUtils.getBigDecimalSum(num5506, num45010201);
        // 投资收益 （450101+45010202）借方发生数
        BigDecimal num450101 = MathUtils.filterDataBorrow(datas, "450101");
        BigDecimal num45010202 = MathUtils.filterDataBorrow(datas, "45010202");
        BigDecimal investmentIncome = MathUtils.getBigDecimalSum(num450101, num45010202);

        // 其他收益   450106借方发生数
        BigDecimal num450106 = MathUtils.filterDataBorrow(datas, "450106");

        // 营业利润  I056-I070-I080-I128-I084-I086+I088+I186
        BigDecimal operateProfit = MathUtils.getBigDecimalSum(operateIncome.subtract(operateCosts).subtract(num5509).subtract(num450106).subtract(managerCost).subtract(financeCost),investmentIncome, num450106);

        // 营业外收入  (450103+450104)借方发生数
        BigDecimal num450103 = MathUtils.filterDataBorrow(datas, "450103");
        BigDecimal num450104 = MathUtils.filterDataBorrow(datas, "450104");
        BigDecimal nonOperateIncome = MathUtils.getBigDecimalSum(num450103, num450104);

        BigDecimal num5401 = MathUtils.filterDataBorrow(datas, "5401");
        // 营业外支出 （5401-54019902）贷方发生数
        BigDecimal nonOperateExpenditure = num5401.subtract(num54019902);

        // 利润总额  I091+I092-I096
        BigDecimal totalProfit = nonOperateIncome.subtract(nonOperateExpenditure);


        // 归属于母公司所有者的净利润 I099
        BigDecimal netReturn = totalProfit;
        setResult(map, operateIncome, productIncome, operateCosts, productCost, num5509, managerCost, num550508, num550512, num550507, financeCost, num5506, num45010201, investmentIncome, num450106, operateProfit, nonOperateIncome, nonOperateExpenditure, totalProfit, netReturn);

        IncomeProfitStatus incomeProfitStatus = new IncomeProfitStatus(operateIncome, productIncome, operateCosts, productCost,
                num5509, managerCost, num550508, num550512, num550507, financeCost, num5506, num45010201, investmentIncome,
                num450106, operateProfit, nonOperateIncome, nonOperateExpenditure, totalProfit, netReturn);
        insertIncomeProfitStatus(incomeProfitStatus);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("收入利润情况月报采集卡", map);
        return jsonObject.toJSONString();
    }

    private void setResult(Map map, BigDecimal operateIncome, BigDecimal productIncome, BigDecimal operateCosts, BigDecimal productCost, BigDecimal num5509, BigDecimal managerCost, BigDecimal num550508, BigDecimal num550512, BigDecimal num550507, BigDecimal financeCost, BigDecimal num5506, BigDecimal num45010201, BigDecimal investmentIncome, BigDecimal num450106, BigDecimal operateProfit, BigDecimal nonOperateIncome, BigDecimal nonOperateExpenditure, BigDecimal totalProfit, BigDecimal netReturn) {
        map.put("营业收入", operateIncome);
        map.put("宇航产品收入", productIncome);
        map.put("营业成本", operateCosts);
        map.put("宇航产品成本", productCost);
        map.put("税金及附加", num5509);
        map.put("管理费用", managerCost);
        map.put("业务招待费", num550508);
        map.put("差旅费", num550512);
        map.put("办公费", num550507);
        map.put("财务费用", financeCost);
        map.put("利息支出", num5506);
        map.put("利息收入", num45010201);
        map.put("投资收益", investmentIncome);
        map.put("其他收益", num450106);
        map.put("营业利润", operateProfit);
        map.put("营业外收入", nonOperateIncome);
        map.put("营业外支出", nonOperateExpenditure);
        map.put("利润总额", totalProfit);
        map.put("归属于母公司所有者的净利润", netReturn);
    }

    /**
     * 查询收入利润情况月报采集卡列表
     *
     * @param incomeProfitStatus 收入利润情况月报采集卡
     * @return 收入利润情况月报采集卡
     */
    @Override
    public List<IncomeProfitStatus> selectIncomeProfitStatusList(IncomeProfitStatus incomeProfitStatus) {
        return incomeProfitStatusMapper.selectIncomeProfitStatusList(incomeProfitStatus);
    }

    /**
     * 新增收入利润情况月报采集卡
     *
     * @param incomeProfitStatus 收入利润情况月报采集卡
     * @return 结果
     */
    @Override
    public int insertIncomeProfitStatus(IncomeProfitStatus incomeProfitStatus) {
        if (StringUtils.isEmpty(incomeProfitStatus.getCfKjq())) {
            incomeProfitStatus.setCfKjq(DateUtils.getMonth());
        }
        if (StringUtils.isEmpty(incomeProfitStatus.getCfKjnd())) {
            incomeProfitStatus.setCfKjnd(DateUtils.getYear());
        }
        incomeProfitStatusMapper.deleteIncomeProfitStatusById(incomeProfitStatus);
        return incomeProfitStatusMapper.insertIncomeProfitStatus(incomeProfitStatus);
    }

    /**
     * 修改收入利润情况月报采集卡
     *
     * @param incomeProfitStatus 收入利润情况月报采集卡
     * @return 结果
     */
    @Override
    public int updateIncomeProfitStatus(IncomeProfitStatus incomeProfitStatus) {
        return incomeProfitStatusMapper.updateIncomeProfitStatus(incomeProfitStatus);
    }

    /**
     * 删除收入利润情况月报采集卡对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteIncomeProfitStatusByIds(String ids) {
        return incomeProfitStatusMapper.deleteIncomeProfitStatusByIds(null);
    }

    /**
     * 删除收入利润情况月报采集卡信息
     *
     * @return 结果
     */
    @Override
    public int deleteIncomeProfitStatusById(IncomeProfitStatus incomeProfitStatus) {
        return incomeProfitStatusMapper.deleteIncomeProfitStatusById(incomeProfitStatus);
    }
}
