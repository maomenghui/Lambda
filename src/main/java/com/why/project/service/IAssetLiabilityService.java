package com.why.project.service;

import com.why.project.entity.AssetLiability;
import com.why.project.entity.Zwkmye2020;

import java.util.List;

/**
 * 资产负债Service接口
 *
 * @author maomh
 * @date 2020-06-24
 */
public interface IAssetLiabilityService {

    /**
     * 生成报表数据插入到数据库
     * @return 报表数据
     */
    public String createReport(List<Zwkmye2020> datas);

    /**
     * 查询资产负债
     *
     * @param id 资产负债ID
     * @return 资产负债
     */
    public AssetLiability selectAssetLiabilityById(Long id);

    /**
     * 查询资产负债列表
     *
     * @param assetLiability 资产负债
     * @return 资产负债集合
     */
    public List<AssetLiability> selectAssetLiabilityList(AssetLiability assetLiability);

    /**
     * 新增资产负债
     *
     * @param assetLiability 资产负债
     * @return 结果
     */
    public int insertAssetLiability(AssetLiability assetLiability);

    /**
     * 修改资产负债
     *
     * @param assetLiability 资产负债
     * @return 结果
     */
    public int updateAssetLiability(AssetLiability assetLiability);

    /**
     * 批量删除资产负债
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAssetLiabilityByIds(String ids);

    /**
     * 删除资产负债信息
     *
     * @return 结果
     */
    public int deleteAssetLiabilityById(AssetLiability assetLiability);
}
