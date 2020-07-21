package com.why.project.mapper;

import com.why.project.entity.PersonnelLabour;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 人事、劳资月报采集卡Mapper接口
 *
 * @author maomh
 * @date 2020-07-08
 */
@Mapper
public interface PersonnelLabourMapper {
    /**
     * 查询人事、劳资月报采集卡
     *
     * @param id 人事、劳资月报采集卡ID
     * @return 人事、劳资月报采集卡
     */
    public PersonnelLabour selectPersonnelLabourById(Long id);

    /**
     * 查询人事、劳资月报采集卡列表
     *
     * @param personnelLabour 人事、劳资月报采集卡
     * @return 人事、劳资月报采集卡集合
     */
    public List<PersonnelLabour> selectPersonnelLabourList(PersonnelLabour personnelLabour);

    /**
     * 新增人事、劳资月报采集卡
     *
     * @param personnelLabour 人事、劳资月报采集卡
     * @return 结果
     */
    public int insertPersonnelLabour(PersonnelLabour personnelLabour);

    /**
     * 修改人事、劳资月报采集卡
     *
     * @param personnelLabour 人事、劳资月报采集卡
     * @return 结果
     */
    public int updatePersonnelLabour(PersonnelLabour personnelLabour);

    /**
     * 删除人事、劳资月报采集卡
     *
     * @return 结果
     */
    public int deletePersonnelLabourById(PersonnelLabour personnelLabour);

    /**
     * 批量删除人事、劳资月报采集卡
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePersonnelLabourByIds(String[] ids);
}
