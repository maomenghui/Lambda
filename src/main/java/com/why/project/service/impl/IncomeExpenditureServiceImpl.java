package com.why.project.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.why.project.common.DateUtils;
import com.why.project.common.JDBCUtils;
import com.why.project.common.MathUtils;
import com.why.project.entity.IncomeExpenditure;
import com.why.project.entity.Zwkmye2020;
import com.why.project.mapper.IncomeExpenditureMapper;
import com.why.project.service.IIncomeExpenditureService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 收入支出Service业务层处理
 *
 * @author maomh
 * @date 2020-07-02
 */
@Service
public class IncomeExpenditureServiceImpl implements IIncomeExpenditureService {
    @Autowired
    private IncomeExpenditureMapper incomeExpenditureMapper;

    @Override
    public String createReport(List<Zwkmye2020> datas) {
        Map map = new HashMap<String, BigDecimal>();

        // 财政补助收入	4001借方发生数	JFFS
        BigDecimal num4001 = MathUtils.filterDataBorrow(datas,"4001");

        // 减：财政补助支出	5001贷方发生数	DFFS
        BigDecimal num5001 = MathUtils.filterDataLoan(datas,"5001");

        // 本期财政补助结转结余	5行-6行	JFFS-DFFS
        BigDecimal currSubsidyBalance = num4001.subtract(num5001).setScale(2, RoundingMode.HALF_UP);

        // 其中:财政补助结转	4行	JFFS-DFFS
        BigDecimal financeSubsidyBalance = currSubsidyBalance;

        // 财政补助结转结余	2行+3行
        BigDecimal financeBalance = currSubsidyBalance;

        // 科研收入	4102借方发生数	JFFS
        BigDecimal num4102 = MathUtils.filterDataBorrow(datas,"4102");

        // 减：科研成本	5011贷方发生数	DFFS
        BigDecimal num5011 = MathUtils.filterDataLoan(datas,"5011");

        // 科研结余	11行-12行	DFFD+JFFS
        BigDecimal researchBalance = num4102.add(num5011);

        // 其他业务收入	4104借方发生数	JFFS
        BigDecimal num4104 = MathUtils.filterDataBorrow(datas,"4104");

        // 减：其他业务成本	5013贷方发生数	DFFS
        BigDecimal num5013 = MathUtils.filterDataLoan(datas,"5013");

        // 其他业务税金及附加	5509贷方发生数	DFFS
        BigDecimal num5509 = MathUtils.filterDataLoan(datas,"5509");

        // 其他业务结余	（18-19-20）行	JFFS-DFFS
        BigDecimal otherBusinessBalance = num4104.subtract(num5013.subtract(num5509)).setScale(2, RoundingMode.HALF_UP);

        // 加：其他收入	4501借方发生数	JFFS
        BigDecimal num4501 = MathUtils.filterDataBorrow(datas,"4501");

        // 5401贷方发生数 其他支出  DFFS
        BigDecimal num5401 = MathUtils.filterDataBorrow(datas,"5401");

        // 其他结余	（22+23+24-25-26-27）行
        BigDecimal otherBalance = MathUtils.getBigDecimalSum(num4501, num5401);

        // 事业结余	（10+13+17+21）行
        BigDecimal causeBalance = MathUtils.getBigDecimalSum(researchBalance, otherBusinessBalance, otherBalance).setScale(2, RoundingMode.HALF_UP);

        // 非财政补助结余			9行
        BigDecimal nonTreasuryBalance = causeBalance;

        // 可分配非财政补助结余		43行
        BigDecimal assignableNnTreasuryBalance = nonTreasuryBalance;
        // 应缴结余	  340403借发生数	JFFS
        BigDecimal num340403 = MathUtils.filterDataBorrow(datas,"340403");

        // 提取专用基金	（44-45-46）行*40%
        BigDecimal extractFund = assignableNnTreasuryBalance.subtract(num340403);
        extractFund = extractFund.multiply(new BigDecimal(0.4)).setScale(2, RoundingMode.HALF_UP);
        // 转入事业基金	（44-47）行
        BigDecimal enterpriseFunds = assignableNnTreasuryBalance.subtract(extractFund);
        setResult(map, num4001, num5001, currSubsidyBalance, financeSubsidyBalance, financeBalance, num4102, num5011, researchBalance, num4104, num5013, num5509, otherBusinessBalance, num4501, num5401, causeBalance, nonTreasuryBalance, assignableNnTreasuryBalance, num340403, extractFund, enterpriseFunds);
        IncomeExpenditure ie = new IncomeExpenditure(num4001, num5001, currSubsidyBalance, financeSubsidyBalance, financeBalance,
                num4102, num5011, researchBalance, num4104, num5013, num5509, otherBusinessBalance, num4501,
                num5401, financeBalance, causeBalance, nonTreasuryBalance, assignableNnTreasuryBalance, num340403,
                extractFund, enterpriseFunds);

        insertIncomeExpenditure(ie);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("收入支出表", map);
        return jsonObject.toJSONString();

    }

    private void setResult(Map map, BigDecimal num4001, BigDecimal num5001, BigDecimal currSubsidyBalance, BigDecimal financeSubsidyBalance, BigDecimal financeBalance, BigDecimal num4102, BigDecimal num5011, BigDecimal researchBalance, BigDecimal num4104, BigDecimal num5013, BigDecimal num5509, BigDecimal otherBusinessBalance, BigDecimal num4501, BigDecimal num5401, BigDecimal causeBalance, BigDecimal nonTreasuryBalance, BigDecimal assignableNnTreasuryBalance, BigDecimal num340403, BigDecimal extractFund, BigDecimal enterpriseFunds) {
        map.put("财政补助支出", num4001);
        map.put("财政补助收入", num5001);
        map.put("本期财政补助结转结余", currSubsidyBalance);
        map.put("财政补助结转", financeSubsidyBalance);
        map.put("财政补助结转结余", financeBalance);
        map.put("科研收入", num4102);
        map.put("科研成本", num5011);
        map.put("科研结余", researchBalance);
        map.put("其他业务收入", num4104);
        map.put("其他业务成本", num5013);
        map.put("其他业务税金及附加", num5509);
        map.put("其他业务结余", otherBusinessBalance);
        map.put("其他收入", num4501);
        map.put("其他支出", num5401);
        map.put("财政补助结转结余", financeBalance);
        map.put("事业结余", causeBalance);
        map.put("非财政补助结余", nonTreasuryBalance);
        map.put("可分配非财政补助结余", assignableNnTreasuryBalance);
        map.put("应缴结余", num340403);
        map.put("提取专用基金", extractFund);
        map.put("转入事业基金", enterpriseFunds);
    }


    /**
     * 查询收入支出
     *
     * @param id 收入支出ID
     * @return 收入支出
     */
    @Override
    public IncomeExpenditure selectIncomeExpenditureById(Long id) {
        return incomeExpenditureMapper.selectIncomeExpenditureById(id);
    }

    /**
     * 查询收入支出列表
     *
     * @param incomeExpenditure 收入支出
     * @return 收入支出
     */
    @Override
    public List<IncomeExpenditure> selectIncomeExpenditureList(IncomeExpenditure incomeExpenditure) {
        return incomeExpenditureMapper.selectIncomeExpenditureList(incomeExpenditure);
    }

    /**
     * 新增收入支出
     *
     * @param incomeExpenditure 收入支出
     * @return 结果
     */
    @Override
    public int insertIncomeExpenditure(IncomeExpenditure incomeExpenditure) {
        if (StringUtils.isEmpty(incomeExpenditure.getCfKjq())) {
            incomeExpenditure.setCfKjq(DateUtils.getMonth());
        }
        if (StringUtils.isEmpty(incomeExpenditure.getCfKjnd())) {
            incomeExpenditure.setCfKjnd(DateUtils.getYear());
        }
        incomeExpenditureMapper.deleteIncomeExpenditureById(incomeExpenditure);
        return incomeExpenditureMapper.insertIncomeExpenditure(incomeExpenditure);
    }

    /**
     * 修改收入支出
     *
     * @param incomeExpenditure 收入支出
     * @return 结果
     */
    @Override
    public int updateIncomeExpenditure(IncomeExpenditure incomeExpenditure) {
        return incomeExpenditureMapper.updateIncomeExpenditure(incomeExpenditure);
    }

    /**
     * 删除收入支出对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteIncomeExpenditureByIds(String ids) {
        return incomeExpenditureMapper.deleteIncomeExpenditureByIds(null);
    }

    /**
     * 删除收入支出信息
     *
     * @return 结果
     */
    @Override
    public int deleteIncomeExpenditureById(IncomeExpenditure incomeExpenditure) {
        return incomeExpenditureMapper.deleteIncomeExpenditureById(incomeExpenditure);
    }
}
