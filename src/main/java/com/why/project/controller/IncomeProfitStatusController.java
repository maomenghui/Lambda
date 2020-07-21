package com.why.project.controller;

import com.why.project.common.JDBCUtils;
import com.why.project.service.IIncomeProfitStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Mao
 */
@Controller
@RequestMapping("/system/income/profit")
public class IncomeProfitStatusController {

    @Autowired
    IIncomeProfitStatusService incomeProfitStatusService;

    @GetMapping("/list")
    @ResponseBody
    public String list() {
        return incomeProfitStatusService.createReport(JDBCUtils.selectZwkmye());
    }

}
