package com.why.project.mapper;

import com.why.project.entity.Profit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 利润Mapper接口
 *
 * @author maomh
 * @date 2020-06-29
 */
@Mapper
public interface ProfitMapper {
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
     * 删除利润
     *
     * @return 结果
     */
    public int deleteProfitById(Profit profit);

    /**
     * 批量删除利润
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProfitByIds(String[] ids);
}
