package com.why.project.mapper;


import com.why.project.entity.Zwkmye2020;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

/**
 * 利润Mapper接口
 *
 * @author maomh
 * @date 2020-06-23
 */
@Mapper
public interface ZwkmyeMapper {
    /**
     * 查询利润
     *
     * @param zwkmyeKmbh 利润ID
     * @return 利润
     */
    public Zwkmye2020 selectZwkmye2020ById(String zwkmyeKmbh);


    public BigDecimal selectGather(String zwkmyeKmbh, String zwkmyeKjq);

    /**
     * 借方发生汇总
     *
     * @param zwkmyeKmbh
     * @param zwkmyeKjq
     * @return
     */
    public BigDecimal selectBorrowGather(String zwkmyeKmbh, String zwkmyeKjq);

    /**
     * 贷方发生汇总
     *
     * @param zwkmyeKmbh
     * @param zwkmyeKjq
     * @return
     */
    public BigDecimal selectLoanGather(String zwkmyeKmbh, String zwkmyeKjq);

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
     * 删除利润
     *
     * @param zwkmyeDwbh 利润ID
     * @return 结果
     */
    public int deleteZwkmye2020ById(String zwkmyeDwbh);

    /**
     * 批量删除利润
     *
     * @param zwkmyeDwbhs 需要删除的数据ID
     * @return 结果
     */
    public int deleteZwkmye2020ByIds(String[] zwkmyeDwbhs);
}
