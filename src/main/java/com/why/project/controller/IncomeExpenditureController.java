package com.why.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.why.project.common.JDBCUtils;
import com.why.project.common.MathUtils;
import com.why.project.entity.IncomeExpenditure;
import com.why.project.service.IIncomeExpenditureService;
import com.why.project.service.IZwkmyeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mao
 */
@Controller
@RequestMapping("/system/income/expenditure")
public class IncomeExpenditureController {

    @Autowired
    private IIncomeExpenditureService incomeExpenditureService;

    @GetMapping("/list")
    @ResponseBody
    public String list() {
        return incomeExpenditureService.createReport(JDBCUtils.selectZwkmye());
    }

}