package com.why.project.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.why.project.common.DateUtils;
import com.why.project.common.JDBCUtils;
import com.why.project.common.MathUtils;
import com.why.project.entity.PersonnelLabour;
import com.why.project.entity.Zwkmye2020;
import com.why.project.mapper.PersonnelLabourMapper;
import com.why.project.service.IPersonnelLabourService;
import com.why.project.service.IZwkmyeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 人事、劳资月报采集卡Service业务层处理
 *
 * @author maomh
 * @date 2020-07-08
 */
@Service
public class PersonnelLabourServiceImpl implements IPersonnelLabourService {
    @Autowired
    private PersonnelLabourMapper personnelLabourMapper;

    @Autowired
    private IZwkmyeService zwkmye2020Service;

    /**
     * 生成报表数据插入到数据库
     *
     * @return 报表数据
     */
    @Override
    public String createReport(List<Zwkmye2020> datas) {
        return getAndSetData(datas);
    }

    private String getAndSetData(List<Zwkmye2020> datas) {
        Map map = new HashMap<String, BigDecimal>();
        // 从业人员劳动报酬（RL12＝RL13+RL14+RL30）
        BigDecimal labourReward = new BigDecimal(0);

        // 其中：在岗职工工资总额 220101借方发生数-RL14行-RL17行
        BigDecimal totalWages = new BigDecimal(0);
        BigDecimal num220101 = MathUtils.filterDataBorrow(datas, "220101");


        // 劳务派遣人员劳动报酬 550538借方发生数
        BigDecimal num550538 = MathUtils.filterDataBorrow(datas, "550538");

        // 其他从业人员劳动报酬 22010102借方发生数
        BigDecimal num22010102 = MathUtils.filterDataBorrow(datas, "22010102");
        totalWages = num220101.subtract(num22010102);

        // 社会保险费用 220103借方发生数
        BigDecimal num220103 = MathUtils.filterDataBorrow(datas, "220103");

        // 职工福利费 220102借方发生数+手填+32010103借方发生数
        BigDecimal num220102 = MathUtils.filterDataBorrow(datas, "220102");
        BigDecimal num32010103 = MathUtils.filterDataBorrow(datas, "32010103");
        BigDecimal employeeBenefit = MathUtils.getBigDecimalSum(num220102, num32010103);

        // 教育经费  23050402借方发生数
        BigDecimal num23050402 = MathUtils.filterDataBorrow(datas, "23050402");

        // 住房费用（公积金+财政房帖）220104借方发生数
        BigDecimal num220104 = MathUtils.filterDataBorrow(datas, "220104");

        // 公积金    22010401借方发生数
        BigDecimal num22010401 = MathUtils.filterDataBorrow(datas, "22010401");

        // 工会经费  23050401借方发生数
        BigDecimal num23050401 = MathUtils.filterDataBorrow(datas, "23050401");

        setResult(map, labourReward, totalWages, num550538, num22010102, num220103, employeeBenefit, num23050402, num220104, num22010401, num23050401);
        PersonnelLabour personnelLabour = new PersonnelLabour(labourReward, labourReward, totalWages, num550538,
                num22010102, num220103, employeeBenefit, num23050402, num220104, num22010401);
        insertPersonnelLabour(personnelLabour);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("收入利润情况月报采集卡", map);
        return jsonObject.toJSONString();
    }

    private void setResult(Map map, BigDecimal labourReward, BigDecimal totalWages, BigDecimal num550538, BigDecimal num22010102, BigDecimal num220103, BigDecimal employeeBenefit, BigDecimal num23050402, BigDecimal num220104, BigDecimal num22010401, BigDecimal num23050401) {
        map.put("从业人员劳动报酬", labourReward);
        map.put("在岗职工工资总额", totalWages);
        map.put("劳务派遣人员劳动报酬", num550538);
        map.put("其他从业人员劳动报酬", num22010102);
        map.put("社会保险费用", num220103);
        map.put("职工福利费", employeeBenefit);
        map.put("教育经费", num23050402);
        map.put("住房费用", num220104);
        map.put("公积金", num22010401);
        map.put("工会经费", num23050401);
    }

    /**
         * 查询人事、劳资月报采集卡
         *
         * @param id 人事、劳资月报采集卡ID
         * @return 人事、劳资月报采集卡
         */
    @Override
    public PersonnelLabour selectPersonnelLabourById(Long id) {
        return personnelLabourMapper.selectPersonnelLabourById(id);
    }

    /**
     * 查询人事、劳资月报采集卡列表
     *
     * @param personnelLabour 人事、劳资月报采集卡
     * @return 人事、劳资月报采集卡
     */
    @Override
    public List<PersonnelLabour> selectPersonnelLabourList(PersonnelLabour personnelLabour) {
        return personnelLabourMapper.selectPersonnelLabourList(personnelLabour);
    }

    /**
     * 新增人事、劳资月报采集卡
     *
     * @param personnelLabour 人事、劳资月报采集卡
     * @return 结果
     */
    @Override
    public int insertPersonnelLabour(PersonnelLabour personnelLabour) {
        if (StringUtils.isEmpty(personnelLabour.getCfKjq())) {
            personnelLabour.setCfKjq(DateUtils.getMonth());
        }
        if (StringUtils.isEmpty(personnelLabour.getCfKjnd())) {
            personnelLabour.setCfKjnd(DateUtils.getYear());
        }
        personnelLabourMapper.deletePersonnelLabourById(personnelLabour);
        return personnelLabourMapper.insertPersonnelLabour(personnelLabour);
    }

    /**
     * 修改人事、劳资月报采集卡
     *
     * @param personnelLabour 人事、劳资月报采集卡
     * @return 结果
     */
    @Override
    public int updatePersonnelLabour(PersonnelLabour personnelLabour) {
        return personnelLabourMapper.updatePersonnelLabour(personnelLabour);
    }

    /**
     * 删除人事、劳资月报采集卡对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePersonnelLabourByIds(String ids) {
        return personnelLabourMapper.deletePersonnelLabourByIds(null);
    }

    /**
     * 删除人事、劳资月报采集卡信息
     * @return 结果
     */
    @Override
    public int deletePersonnelLabourById(PersonnelLabour personnelLabour) {
        return personnelLabourMapper.deletePersonnelLabourById(personnelLabour);
    }
}
