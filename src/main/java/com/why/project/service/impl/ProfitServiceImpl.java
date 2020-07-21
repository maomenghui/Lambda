package com.why.project.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.why.project.common.DateUtils;
import com.why.project.common.JDBCUtils;
import com.why.project.common.MathUtils;
import com.why.project.entity.Profit;
import com.why.project.entity.Zwkmye2020;
import com.why.project.mapper.ProfitMapper;
import com.why.project.service.IProfitService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 利润Service业务层处理
 *
 * @author maomh
 * @date 2020-06-29
 */
@Service
public class ProfitServiceImpl implements IProfitService {
    @Autowired
    private ProfitMapper profitMapper;

    /**
     * 生成报表数据插入到数据库
     *
     * @return 报表数据
     */
    @Override
    public String createReport(List<Zwkmye2020> datas) {
        Map map = new HashMap<String, BigDecimal>();

        //  借方发生
        BigDecimal num4102 = MathUtils.filterDataLoan(datas,"4102");
        // 贷方发生
        BigDecimal num500101 = MathUtils.filterDataBorrow(datas,"500101");
        // 4102借方发生数+500101贷方发生数+（450105+450107+450199）借方发生数
        BigDecimal num450105 = MathUtils.filterDataLoan(datas,"450105");
        BigDecimal num450107 = MathUtils.filterDataLoan(datas,"450107");
        BigDecimal num450199 = MathUtils.filterDataLoan(datas,"450199");
        // 营业总收入 4102借方发生数+500101贷方发生数+（450105+450107+450199）借方发生数
        BigDecimal grossRevenue = MathUtils.getBigDecimalSum(num4102, num500101, num450105, num450107, num450199);

        // 营业收入
        BigDecimal operateIncome = grossRevenue;

        BigDecimal num5011 = MathUtils.filterDataLoan(datas,"5011");
        BigDecimal num501104 = MathUtils.filterDataLoan(datas,"501104");
        BigDecimal num54019902 = MathUtils.filterDataLoan(datas,"54019902");
        // 营业成本 （5011-501104+500101+54019902）贷方发生
        BigDecimal operateCosts = MathUtils.getBigDecimalSum(num5011.subtract(num501104), num501104,num54019902);

        // 营业总成本 （7+17+18+19+25+26）行
        BigDecimal totalOperateExpenses = MathUtils.getBigDecimalSum(num5011, num500101, num54019902);

        // 材料费 50110101贷方发生数
        BigDecimal num50110101 = MathUtils.filterDataLoan(datas,"50110302");

        // 外协费
        BigDecimal num50110302 = MathUtils.filterDataLoan(datas,"50110302");

        // 税金及附加
        BigDecimal num5509 = MathUtils.filterDataLoan(datas,"5509");
        // 管理费用  501104贷方发生数-25行

        // 办公费
        BigDecimal num550507 = MathUtils.filterDataBorrow(datas,"550507");
        // 会议费
        BigDecimal num550514 = MathUtils.filterDataBorrow(datas,"550514");
        // 业务招待费
        BigDecimal num550508 = MathUtils.filterDataBorrow(datas,"550508");
        // 差旅费
        BigDecimal num550512 = MathUtils.filterDataBorrow(datas,"550512");

        // 利息费用
        BigDecimal num5506 = MathUtils.filterDataLoan(datas,"5506");
        // 利息收入
        BigDecimal num45010201 = MathUtils.filterDataBorrow(datas,"45010201");
        // 财务费用 27-28行
        BigDecimal financialExpense = MathUtils.getBigDecimalSum(num5506, num45010201);

        // 其他收益
        BigDecimal num450106 = MathUtils.filterDataBorrow(datas,"450106");

        BigDecimal num450101 = MathUtils.filterDataBorrow(datas,"450101");
        BigDecimal num45010202 = MathUtils.filterDataBorrow(datas,"45010202");
        // 投资收益 （450101+45010202）借方发生数
        BigDecimal investmentIncome = MathUtils.getBigDecimalSum(num450101, num45010202);

        // 营业利润（亏损以“－”号填列） （1-6+33+36）行
        BigDecimal operateProfit = MathUtils.getBigDecimalSum(grossRevenue.subtract(totalOperateExpenses), num450106, investmentIncome);

        BigDecimal num450103 = MathUtils.filterDataBorrow(datas,"450103");
        BigDecimal num450104 = MathUtils.filterDataBorrow(datas,"450104");
        // 营业外收入 （450103+450104）借方发生数
        BigDecimal nonOperatingIncome = MathUtils.getBigDecimalSum(num450103, num450104);

        BigDecimal num5401 = MathUtils.filterDataLoan(datas,"5401");
        // 营业外支出 （5401-54019902）贷方发生数
        BigDecimal nonOperateExpense  = num5401.subtract(num54019902);

        // 利润总额（亏损总额以“－”号填列）（45+46-48）行
        BigDecimal totalProfit = operateProfit.subtract(nonOperateExpense);

        // 净利润（净亏损以“－”号填列） 49行-50行
        BigDecimal netProfit = totalProfit;
        // 设置返回参数
        setResult(map, grossRevenue, num501104, operateCosts, totalOperateExpenses, num50110101, num50110302, num5509, num550507, num550514, num550508, num550512, num5506, num45010201, financialExpense, num450106, investmentIncome, operateProfit, nonOperatingIncome, nonOperateExpense, totalProfit, netProfit);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("利润表", map);
        Profit profit = new Profit(grossRevenue, grossRevenue, totalOperateExpenses, operateCosts,
                num50110101, num50110302, num5509, num501104, num550507, num550514, num550508,
                num550512, num5506, num45010201, financialExpense, num450106, investmentIncome,
                operateProfit, nonOperatingIncome, nonOperateExpense, totalProfit, netProfit);
        insertProfit(profit);
        return jsonObject.toJSONString();
    }

    private void setResult(Map map, BigDecimal grossRevenue, BigDecimal num501104, BigDecimal operateCosts, BigDecimal totalOperateExpenses, BigDecimal num50110101, BigDecimal num50110302, BigDecimal num5509, BigDecimal num550507, BigDecimal num550514, BigDecimal num550508, BigDecimal num550512, BigDecimal num5506, BigDecimal num45010201, BigDecimal financialExpense, BigDecimal num450106, BigDecimal investmentIncome, BigDecimal operateProfit, BigDecimal nonOperatingIncome, BigDecimal nonOperateExpense, BigDecimal totalProfit, BigDecimal netProfit) {
        map.put("营业总收入", grossRevenue);
        map.put("营业收入", grossRevenue);
        map.put("营业总成本", totalOperateExpenses);
        map.put("营业成本", operateCosts);
        map.put("材料费", num50110101);
        map.put("外协费", num50110302);
        map.put("税金及附加", num5509);
        map.put("管理费用", num501104);
        map.put("办公费", num550507);
        map.put("会议费", num550514);
        map.put("业务招待费", num550508);
        map.put("差旅费", num550512);
        map.put("利息费用", num5506);
        map.put("利息收入", num45010201);
        map.put("财务费用", financialExpense);
        map.put("其他收益", num450106);
        map.put("投资收益", investmentIncome);
        map.put("营业利润", operateProfit);
        map.put("营业外收入", nonOperatingIncome);
        map.put("营业外支出", nonOperateExpense);
        map.put("利润总额", totalProfit);
        map.put("净利润", netProfit);
    }


    /**
     * 查询利润
     *
     * @param id 利润ID
     * @return 利润
     */
    @Override
    public Profit selectProfitById(Long id) {
        return profitMapper.selectProfitById(id);
    }

    /**
     * 查询利润列表
     *
     * @param profit 利润
     * @return 利润
     */
    @Override
    public List<Profit> selectProfitList(Profit profit) {
        return profitMapper.selectProfitList(profit);
    }

    /**
     * 新增利润
     *
     * @param profit 利润
     * @return 结果
     */
    @Override
    public int insertProfit(Profit profit) {
        if (StringUtils.isEmpty(profit.getpKjq())) {
            profit.setpKjq(DateUtils.getMonth());
        }
        if (StringUtils.isEmpty(profit.getpKjnd())) {
            profit.setpKjnd(DateUtils.getYear());
        }
        profitMapper.deleteProfitById(profit);

        return profitMapper.insertProfit(profit);
    }

    /**
     * 修改利润
     *
     * @param profit 利润
     * @return 结果
     */
    @Override
    public int updateProfit(Profit profit) {
        return profitMapper.updateProfit(profit);
    }

    /**
     * 删除利润对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProfitByIds(String ids) {
        return profitMapper.deleteProfitByIds(null);
    }

    /**
     * 删除利润信息
     *
     * @return 结果
     */
    @Override
    public int deleteProfitById(Profit profit) {
        return profitMapper.deleteProfitById(profit);
    }
}
