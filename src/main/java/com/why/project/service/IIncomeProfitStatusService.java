package com.why.project.service;

import com.why.project.entity.IncomeProfitStatus;
import com.why.project.entity.Zwkmye2020;

import java.util.List;

/**
 * 收入利润情况月报采集卡Service接口
 *
 * @author maomh
 * @date 2020-07-07
 */
public interface IIncomeProfitStatusService {
    /**
     * 查询收入利润情况月报采集卡
     *
     * @param id 收入利润情况月报采集卡ID
     * @return 收入利润情况月报采集卡
     */
    public IncomeProfitStatus selectIncomeProfitStatusById(Long id);

    /**
     * 生成报表数据插入到数据库
     * @return 报表数据
     */
    public String createReport(List<Zwkmye2020> datas);

    /**
     * 查询收入利润情况月报采集卡列表
     *
     * @param incomeProfitStatus 收入利润情况月报采集卡
     * @return 收入利润情况月报采集卡集合
     */
    public List<IncomeProfitStatus> selectIncomeProfitStatusList(IncomeProfitStatus incomeProfitStatus);

    /**
     * 新增收入利润情况月报采集卡
     *
     * @param incomeProfitStatus 收入利润情况月报采集卡
     * @return 结果
     */
    public int insertIncomeProfitStatus(IncomeProfitStatus incomeProfitStatus);

    /**
     * 修改收入利润情况月报采集卡
     *
     * @param incomeProfitStatus 收入利润情况月报采集卡
     * @return 结果
     */
    public int updateIncomeProfitStatus(IncomeProfitStatus incomeProfitStatus);

    /**
     * 批量删除收入利润情况月报采集卡
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteIncomeProfitStatusByIds(String ids);

    /**
     * 删除收入利润情况月报采集卡信息
     *
     * @return 结果
     */
    public int deleteIncomeProfitStatusById(IncomeProfitStatus incomeProfitStatus);
}
