package com.why.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.why.project.common.JDBCUtils;
import com.why.project.common.MathUtils;
import com.why.project.entity.Profit;
import com.why.project.service.IProfitService;
import com.why.project.service.IZwkmyeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 利润表
 * @author Mao
 */
@Controller
@RequestMapping("/system/profit")
public class ProfitController {

    @Autowired
    private IProfitService profitService;

    @GetMapping("/list")
    @ResponseBody
    public String list() {
        return profitService.createReport(JDBCUtils.selectZwkmye());
    }



}
