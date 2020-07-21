package com.why.project.controller;

import com.why.project.common.JDBCUtils;
import com.why.project.service.IIncomeProfitStatusService;
import com.why.project.service.IPersonnelLabourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Mao
 */
@Controller
@RequestMapping("/system/personnel/labour")
public class PersonnelLabourController {

    @Autowired
    IPersonnelLabourService personnelLabourService;

    @GetMapping("/list")
    @ResponseBody
    public String list() {
        return personnelLabourService.createReport(JDBCUtils.selectZwkmye());
    }

}
