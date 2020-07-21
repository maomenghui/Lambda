package com.why.project.service;

import com.why.project.entity.IncomeExpenditure;
import com.why.project.entity.Zwkmye2020;

import java.util.List;

/**
 * 收入支出Service接口
 *
 * @author maomh
 * @date 2020-07-02
 */
public interface IIncomeExpenditureService {

    /**
     *  创建报表
     * @return
     */
    public String createReport(List<Zwkmye2020> datas);
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
     * 批量删除收入支出
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteIncomeExpenditureByIds(String ids);

    /**
     * 删除收入支出信息
     *
     * @param incomeExpenditure
     * @return 结果
     */
    public int deleteIncomeExpenditureById(IncomeExpenditure incomeExpenditure);
}
