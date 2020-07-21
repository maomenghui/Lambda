package com.why.project.service;

import com.why.project.entity.CashFlow;
import com.why.project.entity.Zwkmye2020;

import java.util.List;

/**
 * 现金流量Service接口
 *
 * @author maomh
 * @date 2020-06-30
 */
public interface ICashFlowService {
    /**
     *  创建报表
     * @return
     */
    public String createReport(List<Zwkmye2020> datas);

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
     * 批量删除现金流量
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCashFlowByIds(String ids);

    /**
     * 删除现金流量信息
     *
     * @param id 现金流量ID
     * @return 结果
     */
    public int deleteCashFlowById(Long id);
}
