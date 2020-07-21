package com.why.project.controller;

import java.util.List;

import com.why.project.common.JDBCUtils;
import com.why.project.entity.AssetLiability;
import com.why.project.service.IAssetLiabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 资产负债Controller
 *
 * @author maomh
 * @date 2020-06-24
 */
@Controller
@RequestMapping("/system/")
public class AssetLiabilityController {
    private String prefix = "system/";

    @Autowired
    private IAssetLiabilityService assetLiabilityService;

    /**
     * 查询资产负债列表
     */
    @PostMapping("/list")
    @ResponseBody
    public String list(AssetLiability assetLiability) {
        return assetLiabilityService.createReport(JDBCUtils.selectZwkmye());
    }

}
