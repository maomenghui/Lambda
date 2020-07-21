package com.why.project.service;

import com.why.project.entity.Profit;
import com.why.project.entity.Zwkmye2020;

import java.util.List;

/**
 * 利润Service接口
 *
 * @author maomh
 * @date 2020-06-29
 */
public interface IProfitService {

    /**
     * 生成报表数据插入到数据库
     * @return 报表数据
     */
    public String createReport(List<Zwkmye2020> datas);

    /**
     * 查询利润
     *
     * @param id 利润ID
     * @return 利润
     */
    public Profit selectProfitById(Long id);

    /**
     * 查询利润列表
     *
     * @param profit 利润
     * @return 利润集合
     */
    public List<Profit> selectProfitList(Profit profit);

    /**
     * 新增利润
     *
     * @param profit 利润
     * @return 结果
     */
    public int insertProfit(Profit profit);

    /**
     * 修改利润
     *
     * @param profit 利润
     * @return 结果
     */
    public int updateProfit(Profit profit);

    /**
     * 批量删除利润
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProfitByIds(String ids);

    /**
     * 删除利润信息
     *
     * @return 结果
     */
    public int deleteProfitById(Profit profit);
}
