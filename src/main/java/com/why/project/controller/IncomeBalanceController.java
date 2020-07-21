package com.why.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.why.project.common.JDBCUtils;
import com.why.project.entity.IncomeBalance;
import com.why.project.entity.Zwkmye2020;
import com.why.project.service.IIncomeBalanceService;
import com.why.project.service.IZwkmyeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 事业单位收入结余情况月报采集卡
 * @author Mao
 */
@Controller
@RequestMapping("/system/income/balance")
public class IncomeBalanceController {

    @Autowired
    private IIncomeBalanceService incomeBalanceService;

    @GetMapping("/list")
    @ResponseBody
    public String list() {
        return incomeBalanceService.createReport(JDBCUtils.selectZwkmye());
    }


}
