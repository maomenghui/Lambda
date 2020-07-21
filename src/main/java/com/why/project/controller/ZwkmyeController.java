package com.why.project.controller;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.why.project.common.JDBCUtils;
import com.why.project.common.MathUtils;
import com.why.project.entity.AssetLiability;
import com.why.project.entity.Zwkmye2020;
import com.why.project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 利润Controller
 *
 * @author maomh
 * @date 2020-06-23
 */
@Controller
@RequestMapping("/system/finance")
public class ZwkmyeController {

    @Autowired
    IAssetLiabilityService assetLiabilityService;

    @Autowired
    private ICashFlowService cashFlowService;

    @Autowired
    IGrossOutputService grossOutputService;

    @Autowired
    private IIncomeBalanceService incomeBalanceService;

    @Autowired
    private IIncomeExpenditureService incomeExpenditureService;

    @Autowired
    IIncomeProfitStatusService incomeProfitStatusService;

    @Autowired
    IPersonnelLabourService personnelLabourService;

    @Autowired
    private IProfitService profitService;

    /**
     * 查询利润列表
     */
    @GetMapping("/list")
    @ResponseBody
    public String list() {
        List<Zwkmye2020> datas = JDBCUtils.selectZwkmye();

        cashFlowService.createReport(datas);

        grossOutputService.createReport(datas);

        incomeBalanceService.createReport(datas);

        incomeExpenditureService.createReport(datas);

        incomeProfitStatusService.createReport(datas);

        personnelLabourService.createReport(datas);

        profitService.createReport(datas);

        return assetLiabilityService.createReport(datas);
    }

}
