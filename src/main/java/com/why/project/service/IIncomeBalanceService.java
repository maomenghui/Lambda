package com.why.project.service;

import com.why.project.entity.IncomeBalance;
import com.why.project.entity.Zwkmye2020;

import java.util.List;

/**
 * 事业单位收入结余情况月报采集卡Service接口
 *
 * @author maomh
 * @date 2020-07-06
 */
public interface IIncomeBalanceService {

    /**
     * 生成报表数据插入到数据库
     * @return 报表数据
     */
    public String createReport(List<Zwkmye2020> datas);

    /**
     * 查询事业单位收入结余情况月报采集卡
     *
     * @param id 事业单位收入结余情况月报采集卡ID
     * @return 事业单位收入结余情况月报采集卡
     */
    public IncomeBalance selectIncomeBalanceById(Long id);

    /**
     * 查询事业单位收入结余情况月报采集卡列表
     *
     * @param incomeBalance 事业单位收入结余情况月报采集卡
     * @return 事业单位收入结余情况月报采集卡集合
     */
    public List<IncomeBalance> selectIncomeBalanceList(IncomeBalance incomeBalance);

    /**
     * 新增事业单位收入结余情况月报采集卡
     *
     * @param incomeBalance 事业单位收入结余情况月报采集卡
     * @return 结果
     */
    public int insertIncomeBalance(IncomeBalance incomeBalance);

    /**
     * 修改事业单位收入结余情况月报采集卡
     *
     * @param incomeBalance 事业单位收入结余情况月报采集卡
     * @return 结果
     */
    public int updateIncomeBalance(IncomeBalance incomeBalance);

    /**
     * 批量删除事业单位收入结余情况月报采集卡
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteIncomeBalanceByIds(String ids);

    /**
     * 删除事业单位收入结余情况月报采集卡信息
     *
     * @return 结果
     */
    public int deleteIncomeBalanceById(IncomeBalance incomeBalance);
}
