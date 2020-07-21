package com.why.project.service;

import com.why.project.entity.GrossOutput;
import com.why.project.entity.Zwkmye2020;

import java.util.List;

/**
 * 总产出月报采集卡Service接口
 *
 * @author maomh
 * @date 2020-07-07
 */
public interface IGrossOutputService {

    /**
     * 生成报表数据插入到数据库
     * @return 报表数据
     */
    public String createReport(List<Zwkmye2020> datas);

    /**
     * 查询总产出月报采集卡
     *
     * @param id 总产出月报采集卡ID
     * @return 总产出月报采集卡
     */
    public GrossOutput selectGrossOutputById(Long id);

    /**
     * 查询总产出月报采集卡列表
     *
     * @param grossOutput 总产出月报采集卡
     * @return 总产出月报采集卡集合
     */
    public List<GrossOutput> selectGrossOutputList(GrossOutput grossOutput);

    /**
     * 新增总产出月报采集卡
     *
     * @param grossOutput 总产出月报采集卡
     * @return 结果
     */
    public int insertGrossOutput(GrossOutput grossOutput);

    /**
     * 修改总产出月报采集卡
     *
     * @param grossOutput 总产出月报采集卡
     * @return 结果
     */
    public int updateGrossOutput(GrossOutput grossOutput);

    /**
     * 批量删除总产出月报采集卡
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGrossOutputByIds(String ids);

    /**
     * 删除总产出月报采集卡信息
     *
     * @return 结果
     */
    public int deleteGrossOutputById(GrossOutput grossOutput);
}
