package com.why.project.mapper;

import java.util.List;

import com.why.project.entity.IncomeBalance;
import org.apache.ibatis.annotations.Mapper;

/**
 * 事业单位收入结余情况月报采集卡Mapper接口
 *
 * @author maomh
 * @date 2020-07-06
 */
@Mapper
public interface IncomeBalanceMapper {
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
     * 删除事业单位收入结余情况月报采集卡
     *
     * @param id 事业单位收入结余情况月报采集卡ID
     * @return 结果
     */
    public int deleteIncomeBalanceById(IncomeBalance id);

    /**
     * 批量删除事业单位收入结余情况月报采集卡
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteIncomeBalanceByIds(String[] ids);
}
