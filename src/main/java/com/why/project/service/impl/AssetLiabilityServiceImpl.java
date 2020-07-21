package com.why.project.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.why.project.common.DateUtils;
import com.why.project.common.JDBCUtils;
import com.why.project.common.MathUtils;
import com.why.project.entity.AssetLiability;
import com.why.project.entity.Zwkmye2020;
import com.why.project.mapper.AssetLiabilityMapper;
import com.why.project.service.IAssetLiabilityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 资产负债Service业务层处理
 *
 * @author maomh
 * @date 2020-06-24
 */
@Service
public class AssetLiabilityServiceImpl implements IAssetLiabilityService {
    @Autowired
    private AssetLiabilityMapper assetLiabilityMapper;

    /**
     * 生成报表数据插入到数据库
     *
     * @return 报表数据
     */
    @Override
    public String createReport(List<Zwkmye2020> datas) {
        Map map = new HashMap<String, BigDecimal>();
        // 短期借款
        BigDecimal shortLoan = MathUtils.selectGather(datas,"1001");
        // 应缴国库款
        BigDecimal payTreasury = new BigDecimal(shortLoan.toString());
        // 短期投资
        BigDecimal payTax = new BigDecimal(shortLoan.toString());
        // 应付职工薪酬
        BigDecimal paySalary = MathUtils.selectGather(datas,"1201");
        shortLoan = shortLoan.add(payTax);
        // 应付票据
        BigDecimal payPaper = MathUtils.selectGather(datas,"1211");
        // 应付账款
        BigDecimal payAccount = MathUtils.selectGather(datas,"1212");
        // 预收账款
        BigDecimal advanceAccount = MathUtils.selectGather(datas,"1213");
        // 拨入科研费
        BigDecimal researchFund = MathUtils.selectGather(datas,"1215");
        // 其他流动负债
        BigDecimal otherCurrentLiability = MathUtils.selectGather(datas,"1301");
        // 其中：一年内到期的非流动负债
        BigDecimal aYearLiability = MathUtils.selectGather(datas,"5011");
        // 其他应付款 =  其他流动负债 + 一年内到期的非流动负债 + (流动负债合计 + 非流动负债  暂时取不到)
        BigDecimal otherPayAccount = otherCurrentLiability.add(aYearLiability);
        // 拨入专款 = 短期借款 + 应缴国库款 + 其他应付款 + 长期借款
        BigDecimal specialFound = otherCurrentLiability.add(aYearLiability);
        // 非流动资产基金
        BigDecimal equityFunds = MathUtils.selectGather(datas,"1401");
        // 净资产 = 事业基金（暂时取不到） + 非流动资产基金
        BigDecimal netAssets = equityFunds;
        // 固定资产
        BigDecimal fixedAssets = MathUtils.selectGather(datas,"1501");
        // 在建工程
        BigDecimal buildWork = MathUtils.selectGather(datas,"1502");
        // 长期投资 = 固定资产 + 在建工程
        BigDecimal longInvestment = fixedAssets.add(buildWork);
        // 无形资产
        BigDecimal intangibleAssets = MathUtils.selectGather(datas,"1511");
        // 财政补助结转
        BigDecimal grantForward = MathUtils.selectGather(datas,"1601");
        // 财政补助结余
        BigDecimal grantBalance = MathUtils.selectGather(datas,"1602");
        // 专用基金 = 财政补助结转 + 政府补助结余
        BigDecimal specialFunds = grantForward.add(grantBalance);
        // 事业结余
        BigDecimal enterpriseBalance = MathUtils.selectGather(datas,"1701");
        // 经营结余 = 净资产 + 长期投资 + 无形资产 + 专用基金 + 事业结余
        BigDecimal managementBalance = MathUtils.getBigDecimalSum(netAssets, longInvestment, intangibleAssets, specialFunds, enterpriseBalance);
        // 负债和净资产总计
        BigDecimal liabilityNetAssetsSum = MathUtils.getBigDecimalSum(specialFound, netAssets, equityFunds,
                longInvestment, fixedAssets, buildWork, intangibleAssets, specialFunds, grantForward,
                grantBalance, enterpriseBalance, managementBalance);
        AssetLiability assetLiability = new AssetLiability(payTreasury, payTax, paySalary, shortLoan, payPaper,
                payAccount, advanceAccount, researchFund, otherCurrentLiability, aYearLiability, otherPayAccount,
                specialFound, equityFunds, netAssets, fixedAssets, buildWork, longInvestment, intangibleAssets,
                grantForward, grantBalance, specialFunds, enterpriseBalance, managementBalance, liabilityNetAssetsSum);
        insertAssetLiability(assetLiability);
        setResult(map, shortLoan, payTreasury, payTax, paySalary, payPaper, payAccount, advanceAccount, researchFund, otherCurrentLiability, aYearLiability, otherPayAccount, specialFound, equityFunds, netAssets, fixedAssets, buildWork, longInvestment, intangibleAssets, grantForward, grantBalance, specialFunds, enterpriseBalance, managementBalance, liabilityNetAssetsSum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("资产负债表", map);
        return jsonObject.toJSONString();
    }

    private void setResult(Map map, BigDecimal shortLoan, BigDecimal payTreasury, BigDecimal payTax, BigDecimal paySalary, BigDecimal payPaper, BigDecimal payAccount, BigDecimal advanceAccount, BigDecimal researchFund, BigDecimal otherCurrentLiability, BigDecimal aYearLiability, BigDecimal otherPayAccount, BigDecimal specialFound, BigDecimal equityFunds, BigDecimal netAssets, BigDecimal fixedAssets, BigDecimal buildWork, BigDecimal longInvestment, BigDecimal intangibleAssets, BigDecimal grantForward, BigDecimal grantBalance, BigDecimal specialFunds, BigDecimal enterpriseBalance, BigDecimal managementBalance, BigDecimal liabilityNetAssetsSum) {
        map.put("应缴国库款", payTreasury);
        map.put("应缴税费", payTax);
        map.put("应付职工薪酬", paySalary);
        map.put("短期借款", shortLoan);
        map.put("应付票据", payPaper);
        map.put("应付账款", payAccount);
        map.put("预收账款", advanceAccount);
        map.put("拨入科研费", researchFund);
        map.put("其他流动负债", otherCurrentLiability);
        map.put("一年内到期的非流动负债", aYearLiability);
        map.put("其他应付款", otherPayAccount);
        map.put("拨入专款", specialFound);
        map.put("非流动资产基金", equityFunds);
        map.put("净资产", netAssets);
        map.put("固定资产", fixedAssets);
        map.put("在建工程", buildWork);
        map.put("长期投资", longInvestment);
        map.put("无形资产", intangibleAssets);
        map.put("财政补助结转", grantForward);
        map.put("财政补助结余", grantBalance);
        map.put("专用基金", specialFunds);
        map.put("事业结余", enterpriseBalance);
        map.put("经营结余", managementBalance);
        map.put("负债和净资产总计", liabilityNetAssetsSum);
    }

    /**
     * 查询资产负债
     *
     * @param id 资产负债ID
     * @return 资产负债
     */
    @Override
    public AssetLiability selectAssetLiabilityById(Long id) {
        return assetLiabilityMapper.selectAssetLiabilityById(id);
    }

    /**
     * 查询资产负债列表
     *
     * @param assetLiability 资产负债
     * @return 资产负债
     */
    @Override
    public List<AssetLiability> selectAssetLiabilityList(AssetLiability assetLiability) {
        return assetLiabilityMapper.selectAssetLiabilityList(assetLiability);
    }

    /**
     * 新增资产负债
     *
     * @param assetLiability 资产负债
     * @return 结果
     */
    @Override
    public int insertAssetLiability(AssetLiability assetLiability) {
        if (StringUtils.isEmpty(assetLiability.getAlKjq())) {
            assetLiability.setAlKjq(DateUtils.getMonth());
        }
        if (StringUtils.isEmpty(assetLiability.getAlKjnd())) {
            assetLiability.setAlKjnd(DateUtils.getYear());
        }
        assetLiabilityMapper.deleteAssetLiabilityById(assetLiability);
        return assetLiabilityMapper.insertAssetLiability(assetLiability);
    }

    /**
     * 修改资产负债
     *
     * @param assetLiability 资产负债
     * @return 结果
     */
    @Override
    public int updateAssetLiability(AssetLiability assetLiability) {
        return assetLiabilityMapper.updateAssetLiability(assetLiability);
    }

    /**
     * 删除资产负债对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAssetLiabilityByIds(String ids) {
        return assetLiabilityMapper.deleteAssetLiabilityByIds(null);
    }

    /**
     * 删除资产负债信息
     *
     * @return 结果
     */
    @Override
    public int deleteAssetLiabilityById(AssetLiability assetLiability) {
        return assetLiabilityMapper.deleteAssetLiabilityById(assetLiability);
    }
}
