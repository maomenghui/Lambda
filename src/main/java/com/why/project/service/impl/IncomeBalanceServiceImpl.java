package com.why.project.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.why.project.common.DateUtils;
import com.why.project.common.JDBCUtils;
import com.why.project.common.MathUtils;
import com.why.project.entity.IncomeBalance;
import com.why.project.entity.Zwkmye2020;
import com.why.project.mapper.IncomeBalanceMapper;
import com.why.project.service.IIncomeBalanceService;
import com.why.project.service.IZwkmyeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 事业单位收入结余情况月报采集卡Service业务层处理
 *
 * @author maomh
 * @date 2020-07-06
 */
@Service
public class IncomeBalanceServiceImpl implements IIncomeBalanceService {
    @Autowired
    private IncomeBalanceMapper incomeBalanceMapper;

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

    /**
     * 查询事业单位收入结余情况月报采集卡
     *
     * @param id 事业单位收入结余情况月报采集卡ID
     * @return 事业单位收入结余情况月报采集卡
     */
    @Override
    public IncomeBalance selectIncomeBalanceById(Long id) {
        return incomeBalanceMapper.selectIncomeBalanceById(id);
    }

    /**
     * 查询事业单位收入结余情况月报采集卡列表
     *
     * @param incomeBalance 事业单位收入结余情况月报采集卡
     * @return 事业单位收入结余情况月报采集卡
     */
    @Override
    public List<IncomeBalance> selectIncomeBalanceList(IncomeBalance incomeBalance) {
        return incomeBalanceMapper.selectIncomeBalanceList(incomeBalance);
    }

    /**
     * 新增事业单位收入结余情况月报采集卡
     *
     * @param incomeBalance 事业单位收入结余情况月报采集卡
     * @return 结果
     */
    @Override
    public int insertIncomeBalance(IncomeBalance incomeBalance) {
        if (StringUtils.isEmpty(incomeBalance.getCfKjq())) {
            incomeBalance.setCfKjq(DateUtils.getMonth());
        }
        if (StringUtils.isEmpty(incomeBalance.getCfKjnd())) {
            incomeBalance.setCfKjnd(DateUtils.getYear());
        }
        incomeBalanceMapper.deleteIncomeBalanceById(incomeBalance);
        return incomeBalanceMapper.insertIncomeBalance(incomeBalance);
    }

    private String getAndSetData(List<Zwkmye2020> datas) {
        Map map = new HashMap<String, BigDecimal>();
        // 财政补助收入 4001借方发生数
        BigDecimal num4001 = MathUtils.filterDataBorrow(datas, "4001");
        // 其中：离退休人员费用  40010101借方发生数
        BigDecimal num40010101 = MathUtils.filterDataBorrow(datas, "40010101");
        // 其中：科研收入 4010借方发生数
        BigDecimal num4010 = MathUtils.filterDataBorrow(datas, "4010");
        // 其他业务收入 4104借方发生数
        BigDecimal num4104 = MathUtils.filterDataBorrow(datas, "4104");
        // 6.其他收入 （J089≥J143） 4501借方发生数
        BigDecimal num4501 = MathUtils.filterDataBorrow(datas, "4501");
        // 其中：利息收入 450102借方发生数
        BigDecimal num450102 = MathUtils.filterDataBorrow(datas, "450102");
        // 1.财政补助支出 5001贷方发生数
        BigDecimal num5001 = MathUtils.filterDataLoan(datas, "5001");
        // 其中：科研成本支出 5011贷方发生数
        BigDecimal num5011 = MathUtils.filterDataLoan(datas, "5011");
        // 技术成本支出、税金及附加 5509贷方发生数
        BigDecimal num5509 = MathUtils.filterDataLoan(datas, "5509");
        // 其他业务成本支出 5013贷方发生数
        BigDecimal num5013 = MathUtils.filterDataLoan(datas, "5013");
        // 其他支出 5401贷方发生数
        BigDecimal num5401 = MathUtils.filterDataLoan(datas, "5401");
        setResult(map, num4001, num40010101, num4010, num4104, num4501, num450102, num5001, num5011, num5509, num5013, num5401);
        IncomeBalance incomeBalance = new IncomeBalance(num4001, num40010101, num4010, num4104, num4501, num450102, num5001, num5011, num5509, num5013, num5401);
        insertIncomeBalance(incomeBalance);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("利润表", map);
        return jsonObject.toJSONString();
    }

    /**
     * 设置返回值
     */
    private void setResult(Map map, BigDecimal num4001, BigDecimal num40010101, BigDecimal num4010, BigDecimal num4104, BigDecimal num4501, BigDecimal num450102, BigDecimal num5001, BigDecimal num5011, BigDecimal num5509, BigDecimal num5013, BigDecimal num5401) {
        map.put("财政补助收入", num4001);
        map.put("离退休人员费用", num40010101);
        map.put("科研收入", num4010);
        map.put("其他业务收入", num4104);
        map.put("其他收入", num4501);
        map.put("利息收入", num450102);
        map.put("财政补助支出", num5001);
        map.put("科研成本支出", num5011);
        map.put("技术成本支出、税金及附加", num5509);
        map.put("其他业务成本支出", num5013);
        map.put("其他支出 5401贷方发生数", num5401);
    }



    /**
     * 修改事业单位收入结余情况月报采集卡
     *
     * @param incomeBalance 事业单位收入结余情况月报采集卡
     * @return 结果
     */
    @Override
    public int updateIncomeBalance(IncomeBalance incomeBalance) {
        return incomeBalanceMapper.updateIncomeBalance(incomeBalance);
    }

    /**
     * 删除事业单位收入结余情况月报采集卡对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteIncomeBalanceByIds(String ids) {
        return incomeBalanceMapper.deleteIncomeBalanceByIds(null);
    }

    /**
     * 删除事业单位收入结余情况月报采集卡信息
     *
     * @return 结果
     */
    @Override
    public int deleteIncomeBalanceById(IncomeBalance incomeBalance) {
        return incomeBalanceMapper.deleteIncomeBalanceById(incomeBalance);
    }
}
