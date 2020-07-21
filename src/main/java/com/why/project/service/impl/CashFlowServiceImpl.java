package com.why.project.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.why.project.common.DateUtils;
import com.why.project.common.JDBCUtils;
import com.why.project.common.MathUtils;
import com.why.project.entity.CashFlow;
import com.why.project.entity.Zwkmye2020;
import com.why.project.mapper.CashFlowMapper;
import com.why.project.service.ICashFlowService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 现金流量Service业务层处理
 *
 * @author maomh
 * @date 2020-06-30
 */
@Service
public class CashFlowServiceImpl implements ICashFlowService {
    @Autowired
    private CashFlowMapper cashFlowMapper;

    /**
     * 创建报表
     *
     * @return
     */
    @Override
    public String createReport(List<Zwkmye2020> datas) {
        Map map = new HashMap<String, BigDecimal>();
        //  销售商品、提供劳务收到的现金 100010001（借方发生数-贷方发生数）
        BigDecimal num100010001 = MathUtils.filterDataBorrow(datas,"100010001");
        BigDecimal number100010001 = MathUtils.filterDataLoan(datas,"100010001");
        num100010001 = num100010001.subtract(number100010001);

        // 收到的税费返还  100010002（借方发生数-贷方发生数）
        BigDecimal num100010002 = MathUtils.filterDataBorrow(datas,"100010002");
        BigDecimal number100010002 = MathUtils.filterDataLoan(datas,"100010002");
        num100010002 = num100010002.subtract(number100010002);

        // 收到其他与经营活动有关的现金  100010003（借方发生数-贷方发生数）
        BigDecimal num100010003 = MathUtils.filterDataBorrow(datas,"100010003");
        BigDecimal number100010003 = MathUtils.filterDataLoan(datas,"100010003");
        num100010003 = num100010003.subtract(number100010003);

        // 经营活动现金流入小计  1001（借方发生数-贷方发生数）
        BigDecimal num1001 = MathUtils.filterDataBorrow(datas,"1001");
        BigDecimal number1001 = MathUtils.filterDataLoan(datas,"1001");
        num1001 = num1001.subtract(number1001);

        // 收到其他与经营活动有关的现金  100020001（贷方发生数-借方发生数）
        BigDecimal num100020001 = MathUtils.filterDataLoan(datas,"100020001");
        BigDecimal number100020001 = MathUtils.filterDataBorrow(datas,"100020001");
        num100020001 = num100020001.subtract(number100020001);


        // 支付给职工以及为职工支付的现金  100020002（贷方发生数-借方发生数）
        BigDecimal num100020002 = MathUtils.filterDataLoan(datas,"100020002");
        BigDecimal number100020002 = MathUtils.filterDataBorrow(datas,"100020002");
        num100020002 = num100020002.subtract(number100020002);

        // 支付的各项税费  100020003（贷方发生数-借方发生数）
        BigDecimal num100020003 = MathUtils.filterDataLoan(datas,"100020003");
        BigDecimal number100020003 = MathUtils.filterDataBorrow(datas,"100020003");
        num100010003 = num100010003.subtract(number100010003);

        // 支付其他与经营活动有关的现金  100020004（贷方发生数-借方发生数）
        BigDecimal num100020004 = MathUtils.filterDataLoan(datas,"100020004");
        BigDecimal number100020004 = MathUtils.filterDataBorrow(datas,"100020004");
        num100020004 = num100020004.subtract(number100020004);

        // 经营活动现金流出小计  10002（贷方发生数-借方发生数）
        BigDecimal num10002 = MathUtils.filterDataLoan(datas,"10002");
        BigDecimal number10002 = MathUtils.filterDataBorrow(datas,"10002");
        num10002 = num10002.subtract(number10002);

        // 经营活动产生的现金流量净额 15行-25行
        BigDecimal netAmount = num1001.subtract(num10002);

        // 收回投资收到的现金  200010001（借方发生数-贷方发生数）
        BigDecimal num200010001 = MathUtils.filterDataBorrow(datas,"200010001");
        BigDecimal number200010001 = MathUtils.filterDataLoan(datas,"200010001");
        num200010001 = num200010001.subtract(number200010001);


        // 取得投资收益收到的现金  200010002（借方发生数-贷方发生数）
        BigDecimal num200010002 = MathUtils.filterDataBorrow(datas,"200010002");
        BigDecimal number200010002 = MathUtils.filterDataLoan(datas,"200010002");
        num200010002 = num200010002.subtract(number200010002);

        // 处置固定资产、无形资产和其他长期资产所收回的现金净额  200010003（借方发生数-贷方发生数）
        BigDecimal num200010003 = MathUtils.filterDataBorrow(datas,"200010003");
        BigDecimal number200010003 = MathUtils.filterDataLoan(datas,"200010003");
        num200010003 = num200010003.subtract(number200010003);

        // 处置子公司及其他营业单位收回的现金净额  200010004（借方发生数-贷方发生数）
        BigDecimal num200010004 = MathUtils.filterDataBorrow(datas,"200010004");
        BigDecimal number200010004 = MathUtils.filterDataLoan(datas,"200010004");
        num100010003 = num100010003.subtract(number100010003);

        // 收到其他与投资活动有关的现金  200010005（借方发生数-贷方发生数）
        BigDecimal num200010005 = MathUtils.filterDataBorrow(datas,"200010005");
        BigDecimal number200010005 = MathUtils.filterDataLoan(datas,"200010005");
        num200010005 = num200010005.subtract(number200010005);

        // 投资活动现金流入小计  20001（借方发生数-贷方发生数）
        BigDecimal num20001 = MathUtils.filterDataBorrow(datas,"20001");
        BigDecimal number20001 = MathUtils.filterDataLoan(datas,"20001");
        num20001 = num20001.subtract(number20001);


        // 购建固定资产、无形资产和其他长期资产所支付的现金  200020001（贷方发生数-借方发生数）
        BigDecimal num200020001 = MathUtils.filterDataLoan(datas,"200020001");
        BigDecimal number200020001 = MathUtils.filterDataBorrow(datas,"200020001");
        num200020001 = num200020001.subtract(number200020001);

        // 取得投资收益收到的现金  200010002（借方发生数-贷方发生数）
        BigDecimal num200020002 = MathUtils.filterDataBorrow(datas,"200020002");
        BigDecimal number200020002 = MathUtils.filterDataLoan(datas,"200020002");
        num200020002 = num200020002.subtract(number200020002);

        // 取得子公司及其他营业单位支付的现金净额  200020003（贷方发生数-借方发生数）
        BigDecimal num200020003 = MathUtils.filterDataBorrow(datas,"200020003");
        BigDecimal number200020003 = MathUtils.filterDataLoan(datas,"200020003");
        num200020003 = num200020003.subtract(number200020003);

        // 支付其他与投资活动有关的现金  200020004（贷方发生数-借方发生数）
        BigDecimal num200020004 = MathUtils.filterDataLoan(datas,"200020004");
        BigDecimal number200020004 = MathUtils.filterDataBorrow(datas,"200020004");
        num200020004 = num200020004.subtract(number200020004);

        // 投资活动现金流出小计  20002（贷方发生数-借方发生数）
        BigDecimal num20002 = MathUtils.filterDataBorrow(datas,"20002");
        BigDecimal number20002 = MathUtils.filterDataLoan(datas,"20002");
        num20002 = num20002.subtract(number20002);


        // 投资活动产生的现金流量净额 33行-39行
        BigDecimal cashFlowNetAmount = num20001.subtract(num20002);

        // 吸收投资收到的现金  300010001(借方发生数-贷方发生数）
        BigDecimal num300010001 = MathUtils.filterDataBorrow(datas,"300010001");
        BigDecimal number300010001 = MathUtils.filterDataLoan(datas,"300010001");
        num300010001 = num300010001.subtract(number300010001);

        // 取得借款收到的现金  300010002（借方发生数-贷方发生数）
        BigDecimal num300010002 = MathUtils.filterDataBorrow(datas,"300010002");
        BigDecimal number300010002 = MathUtils.filterDataLoan(datas,"300010002");
        num300010002 = num300010002.subtract(number300010002);

        // 收到其他与筹资活动有关的现金  300010003（借方发生数-贷方发生数）
        BigDecimal num300010003 = MathUtils.filterDataBorrow(datas,"300010003");
        BigDecimal number300010003 = MathUtils.filterDataLoan(datas,"300010003");
        num300010003 = num300010003.subtract(number300010003);

        // 筹资活动现金流入小计  30001（借方发生数-贷方发生数）
        BigDecimal num30001 = MathUtils.filterDataBorrow(datas,"30001");
        BigDecimal number30001 = MathUtils.filterDataLoan(datas,"30001");
        num30001 = num30001.subtract(number30001);


        // 吸收投资收到的现金  300020001（贷方发生数-借方发生数）
        BigDecimal num300020001 = MathUtils.filterDataLoan(datas,"300020001");
        BigDecimal number300020001 = MathUtils.filterDataBorrow(datas,"300020001");
        num300020001 = num300020001.subtract(number300020001);

        // 分配股利、利润或偿付利息支付的现金  300020002（贷方发生数-借方发生数）
        BigDecimal num300020002 = MathUtils.filterDataLoan(datas,"300020002");
        BigDecimal number300020002 = MathUtils.filterDataBorrow(datas,"300020002");
        num300020002 = num300020002.subtract(number300020002);

        // 支付其他与筹资活动有关的现金  300020003（贷方发生数-借方发生数）
        BigDecimal num300020003 = MathUtils.filterDataLoan(datas,"300020003");
        BigDecimal number300020003 = MathUtils.filterDataBorrow(datas,"300020003");
        num300020003 = num300020003.subtract(number300020003);

        // 支付其他与筹资活动有关的现金  30002（贷方发生数-借方发生数）
        BigDecimal num30002 = MathUtils.filterDataLoan(datas,"30002");
        BigDecimal number30002 = MathUtils.filterDataBorrow(datas,"30002");
        num30002 = num30002.subtract(number30002);

        // 筹资活动产生的现金流量净额 47-53行
        BigDecimal makeNetAmount = num30001.subtract(num30002);

        // 现金及现金等价物净增加额 （26+40+54）行
        BigDecimal topUp = MathUtils.getBigDecimalSum(netAmount, cashFlowNetAmount, makeNetAmount);

        // 期末现金及现金等价物余额 56行+57行
        BigDecimal balance = topUp;

        // 设置返回参数
        setResult(map, num100010001, num100010002, num100010003, num1001, num100020001, num100020002, num100020003, num100020004, num10002, netAmount, num200010001, num200010002, num200010003, num200010004, num200010005, num20001, num200020001, num200020002, num200020003, num200020004, num20002, cashFlowNetAmount, num300010001, num300010002, num300010003, num30001, num300020001, num300020002, num300020003, num30002, makeNetAmount, topUp, balance);

        CashFlow cashFlow = new CashFlow(num100010001, num100010002, num100010003, num1001, num100020001,
                num100020002, num100020003, num100020004, num10002, netAmount, num200010001, num200010002, num200010003, num200010004,
                num200010005, num20001, num200020001, num200020002, num200020003, num200020004, num20002, cashFlowNetAmount, num300010001,
                num300010002, num300010003, num30001, num300020001, num300020002, num300020003, num30002, makeNetAmount, topUp, balance);
        insertCashFlow(cashFlow);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("利润表", map);
        return jsonObject.toJSONString();
    }

    private void setResult(Map map, BigDecimal num100010001, BigDecimal num100010002, BigDecimal num100010003, BigDecimal num1001, BigDecimal num100020001, BigDecimal num100020002, BigDecimal num100020003, BigDecimal num100020004, BigDecimal num10002, BigDecimal netAmount, BigDecimal num200010001, BigDecimal num200010002, BigDecimal num200010003, BigDecimal num200010004, BigDecimal num200010005, BigDecimal num20001, BigDecimal num200020001, BigDecimal num200020002, BigDecimal num200020003, BigDecimal num200020004, BigDecimal num20002, BigDecimal cashFlowNetAmount, BigDecimal num300010001, BigDecimal num300010002, BigDecimal num300010003, BigDecimal num30001, BigDecimal num300020001, BigDecimal num300020002, BigDecimal num300020003, BigDecimal num30002, BigDecimal makeNetAmount, BigDecimal topUp, BigDecimal balance) {
        map.put("销售商品、提供劳务收到的现金", num100010001);
        map.put("收到的税费返还", num100010002);
        map.put("收到其他与经营活动有关的现金", num100010003);
        map.put("经营活动现金流入小计", num1001);
        map.put("收到其他与经营活动有关的现金", num100020001);
        map.put("支付给职工以及为职工支付的现金", num100020002);
        map.put("支付的各项税费", num100020003);
        map.put("支付其他与经营活动有关的现金", num100020004);
        map.put("经营活动现金流出小计", num10002);
        map.put("经营活动产生的现金流量净额", netAmount);
        map.put("收回投资收到的现金", num200010001);
        map.put("取得投资收益收到的现金", num200010002);
        map.put("处置固定资产、无形资产和其他长期资产所收回的现金净额", num200010003);
        map.put("处置子公司及其他营业单位收回的现金净额", num200010004);
        map.put("收到其他与投资活动有关的现金", num200010005);
        map.put("投资活动现金流入小计", num20001);
        map.put("购建固定资产、无形资产和其他长期资产所支付的现金", num200020001);
        map.put("取得投资收益收到的现金", num200020002);
        map.put("取得子公司及其他营业单位支付的现金净额", num200020003);
        map.put("支付其他与投资活动有关的现金", num200020004);
        map.put("投资活动现金流出小计", num20002);
        map.put("投资活动产生的现金流量净额", cashFlowNetAmount);
        map.put("吸收投资收到的现金", num300010001);
        map.put("取得借款收到的现金", num300010002);
        map.put("收到其他与筹资活动有关的现金", num300010003);
        map.put("筹资活动现金流入小计", num30001);
        map.put("吸收投资收到的现金", num300020001);
        map.put("分配股利、利润或偿付利息支付的现金", num300020002);
        map.put("支付其他与筹资活动有关的现金", num300020003);
        map.put("支付其他与筹资活动有关的现金", num30002);
        map.put("筹资活动产生的现金流量净额", makeNetAmount);
        map.put("现金及现金等价物净增加额", topUp);
        map.put("期末现金及现金等价物余额", balance);
    }

    /**
     * 查询现金流量
     *
     * @param id 现金流量ID
     * @return 现金流量
     */
    @Override
    public CashFlow selectCashFlowById(Long id) {
        return cashFlowMapper.selectCashFlowById(id);
    }

    /**
     * 查询现金流量列表
     *
     * @param cashFlow 现金流量
     * @return 现金流量
     */
    @Override
    public List<CashFlow> selectCashFlowList(CashFlow cashFlow) {
        return cashFlowMapper.selectCashFlowList(cashFlow);
    }

    /**
     * 新增现金流量
     *
     * @param cashFlow 现金流量
     * @return 结果
     */
    @Override
    public int insertCashFlow(CashFlow cashFlow) {
        if (StringUtils.isEmpty(cashFlow.getCfKjq())) {
            cashFlow.setCfKjq(DateUtils.getMonth());
        }
        if (StringUtils.isEmpty(cashFlow.getCfKjnd())) {
            cashFlow.setCfKjnd(DateUtils.getYear());
        }
        cashFlowMapper.deleteCashFlowById(cashFlow);
        return cashFlowMapper.insertCashFlow(cashFlow);
    }

    /**
     * 修改现金流量
     *
     * @param cashFlow 现金流量
     * @return 结果
     */
    @Override
    public int updateCashFlow(CashFlow cashFlow) {
        return cashFlowMapper.updateCashFlow(cashFlow);
    }

    /**
     * 删除现金流量对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCashFlowByIds(String ids) {
        return cashFlowMapper.deleteCashFlowByIds(null);
    }

    /**
     * 删除现金流量信息
     *
     * @param id 现金流量ID
     * @return 结果
     */
    @Override
    public int deleteCashFlowById(Long id) {
        return cashFlowMapper.deleteCashFlowById(null);
    }
}
