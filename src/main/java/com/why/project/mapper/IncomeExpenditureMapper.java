package com.why.project.mapper;

import com.why.project.entity.IncomeExpenditure;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 收入支出Mapper接口
 *
 * @author maomh
 * @date 2020-07-02
 */
@Mapper
public interface IncomeExpenditureMapper {
    /**
     * 查询收入支出
     *
     * @param id 收入支出ID
     * @return 收入支出
     */
    public IncomeExpenditure selectIncomeExpenditureById(Long id);

    /**
     * 查询收入支出列表
     *
     * @param incomeExpenditure 收入支出
     * @return 收入支出集合
     */
    public List<IncomeExpenditure> selectIncomeExpenditureList(IncomeExpenditure incomeExpenditure);

    /**
     * 新增收入支出
     *
     * @param incomeExpenditure 收入支出
     * @return 结果
     */
    public int insertIncomeExpenditure(IncomeExpenditure incomeExpenditure);

    /**
     * 修改收入支出
     *
     * @param incomeExpenditure 收入支出
     * @return 结果
     */
    public int updateIncomeExpenditure(IncomeExpenditure incomeExpenditure);

    /**
     * 删除收入支出
     *
     * @param incomeExpenditure
     * @return 结果
     */
    public int deleteIncomeExpenditureById(IncomeExpenditure incomeExpenditure);

    /**
     * 批量删除收入支出
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteIncomeExpenditureByIds(String[] ids);
}
