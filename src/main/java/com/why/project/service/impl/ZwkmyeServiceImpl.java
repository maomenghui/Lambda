package com.why.project.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import com.why.project.common.DateUtils;
import com.why.project.entity.Zwkmye2020;
import com.why.project.mapper.ZwkmyeMapper;
import com.why.project.service.IZwkmyeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 利润Service业务层处理
 *
 * @author maomh
 * @date 2020-06-23
 */
@Service
public class ZwkmyeServiceImpl implements IZwkmyeService {
    @Autowired
    private ZwkmyeMapper zwkmyeMapper;

    /**
     * 查询利润
     *
     * @param zwkmyeDwbh 利润ID
     * @return 利润
     */
    @Override
    public Zwkmye2020 selectZwkmye2020ById(String zwkmyeDwbh) {
        return zwkmyeMapper.selectZwkmye2020ById(zwkmyeDwbh);
    }

    @Override
    public BigDecimal selectGather(String zwkmyeDwbh) {
        BigDecimal bigDecimal = zwkmyeMapper.selectGather(zwkmyeDwbh, DateUtils.getMonth());
        return bigDecimal == null ? new BigDecimal(0) : bigDecimal;
    }

    @Override
    public BigDecimal selectBorrowGather(String zwkmyeDwbh) {
        BigDecimal bigDecimal = zwkmyeMapper.selectBorrowGather(zwkmyeDwbh, DateUtils.getMonth());
        return bigDecimal == null ? new BigDecimal(0) : bigDecimal;
    }

    @Override
    public BigDecimal selectLoanGather(String zwkmyeDwbh) {
        BigDecimal bigDecimal = zwkmyeMapper.selectLoanGather(zwkmyeDwbh, DateUtils.getMonth());
        return bigDecimal == null ? new BigDecimal(0) : bigDecimal;
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(DateUtils.getYear());
    }

    /**
     * 查询利润列表
     *
     * @param zwkmye2020 利润
     * @return 利润
     */
    @Override
    public List<Zwkmye2020> selectZwkmye2020List(Zwkmye2020 zwkmye2020) {
        return zwkmyeMapper.selectZwkmye2020List(zwkmye2020);
    }

    /**
     * 新增利润
     *
     * @param zwkmye2020 利润
     * @return 结果
     */
    @Override
    public int insertZwkmye2020(Zwkmye2020 zwkmye2020) {
        return zwkmyeMapper.insertZwkmye2020(zwkmye2020);
    }

    /**
     * 修改利润
     *
     * @param zwkmye2020 利润
     * @return 结果
     */
    @Override
    public int updateZwkmye2020(Zwkmye2020 zwkmye2020) {
        return zwkmyeMapper.updateZwkmye2020(zwkmye2020);
    }

    /**
     * 删除利润信息
     *
     * @param zwkmyeDwbh 利润ID
     * @return 结果
     */
    @Override
    public int deleteZwkmye2020ById(String zwkmyeDwbh) {
        return zwkmyeMapper.deleteZwkmye2020ById(zwkmyeDwbh);
    }
}
