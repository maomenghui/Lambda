package com.why.project.service;

import com.why.project.entity.PersonnelLabour;
import com.why.project.entity.Zwkmye2020;

import java.util.List;

/**
 * 人事、劳资月报采集卡Service接口
 *
 * @author maomh
 * @date 2020-07-08
 */
public interface IPersonnelLabourService {

    /**
     * 生成报表数据插入到数据库
     * @return 报表数据
     */
    public String createReport(List<Zwkmye2020> datas);

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
     * 批量删除人事、劳资月报采集卡
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePersonnelLabourByIds(String ids);

    /**
     * 删除人事、劳资月报采集卡信息
     *
     * @return 结果
     */
    public int deletePersonnelLabourById(PersonnelLabour personnelLabour);
}
