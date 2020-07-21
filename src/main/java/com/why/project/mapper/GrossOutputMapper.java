package com.why.project.mapper;

import java.util.List;

import com.why.project.entity.GrossOutput;
import org.apache.ibatis.annotations.Mapper;

/**
 * 总产出月报采集卡Mapper接口
 *
 * @author maomh
 * @date 2020-07-07
 */
@Mapper
public interface GrossOutputMapper {
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
     * 删除总产出月报采集卡
     *
     * @return 结果
     */
    public int deleteGrossOutputById(GrossOutput grossOutput);

    /**
     * 批量删除总产出月报采集卡
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGrossOutputByIds(String[] ids);
}
