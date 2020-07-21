package com.why.project.mapper;

import com.why.project.entity.IncomeProfitStatus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 收入利润情况月报采集卡Mapper接口
 *
 * @author maomh
 * @date 2020-07-07
 */
@Mapper
public interface IncomeProfitStatusMapper {
    /**
     * 查询收入利润情况月报采集卡
     *
     * @param id 收入利润情况月报采集卡ID
     * @return 收入利润情况月报采集卡
     */
    public IncomeProfitStatus selectIncomeProfitStatusById(Long id);

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
     * 删除收入利润情况月报采集卡
     *
     * @return 结果
     */
    public int deleteIncomeProfitStatusById(IncomeProfitStatus incomeProfitStatus);

    /**
     * 批量删除收入利润情况月报采集卡
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteIncomeProfitStatusByIds(String[] ids);
}
