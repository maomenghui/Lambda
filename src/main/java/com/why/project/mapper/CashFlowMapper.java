package com.why.project.mapper;

import com.why.project.entity.CashFlow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 现金流量Mapper接口
 *
 * @author maomh
 * @date 2020-06-30
 */
@Mapper
public interface CashFlowMapper {
    /**
     * 查询现金流量
     *
     * @param id 现金流量ID
     * @return 现金流量
     */
    public CashFlow selectCashFlowById(Long id);

    /**
     * 查询现金流量列表
     *
     * @param cashFlow 现金流量
     * @return 现金流量集合
     */
    public List<CashFlow> selectCashFlowList(CashFlow cashFlow);

    /**
     * 新增现金流量
     *
     * @param cashFlow 现金流量
     * @return 结果
     */
    public int insertCashFlow(CashFlow cashFlow);

    /**
     * 修改现金流量
     *
     * @param cashFlow 现金流量
     * @return 结果
     */
    public int updateCashFlow(CashFlow cashFlow);

    /**
     * 删除现金流量
     *
     * @return 结果
     */
    public int deleteCashFlowById(CashFlow cashFlow);

    /**
     * 批量删除现金流量
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCashFlowByIds(String[] ids);
}
