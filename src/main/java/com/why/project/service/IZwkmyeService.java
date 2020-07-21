package com.why.project.service;

import java.math.BigDecimal;
import java.util.List;

import com.why.project.entity.Zwkmye2020;

/**
 * 利润Service接口
 *
 * @author maomh
 * @date 2020-06-23
 */
public interface IZwkmyeService {
    /**
     * 查询利润
     *
     * @param zwkmyeDwbh 利润ID
     * @return 利润
     */
    public Zwkmye2020 selectZwkmye2020ById(String zwkmyeDwbh);

    public BigDecimal selectGather(String zwkmyeDwbh);

    public BigDecimal selectBorrowGather(String zwkmyeDwbh);

    public BigDecimal selectLoanGather(String zwkmyeDwbh);

    /**
     * 查询利润列表
     *
     * @param zwkmye2020 利润
     * @return 利润集合
     */
    public List<Zwkmye2020> selectZwkmye2020List(Zwkmye2020 zwkmye2020);

    /**
     * 新增利润
     *
     * @param zwkmye2020 利润
     * @return 结果
     */
    public int insertZwkmye2020(Zwkmye2020 zwkmye2020);

    /**
     * 修改利润
     *
     * @param zwkmye2020 利润
     * @return 结果
     */
    public int updateZwkmye2020(Zwkmye2020 zwkmye2020);

    /**
     * 删除利润信息
     *
     * @param zwkmyeDwbh 利润ID
     * @return 结果
     */
    public int deleteZwkmye2020ById(String zwkmyeDwbh);
}
