package com.why.project.mapper;

import com.why.project.entity.AssetLiability;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 资产负债Mapper接口
 *
 * @author maomh
 * @date 2020-06-24
 */
@Mapper
public interface AssetLiabilityMapper {
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
     * @return 资产负债集合
     */
    public List<AssetLiability> selectAssetLiabilityList(AssetLiability assetLiability);

    /**
     * 新增资产负债
     *
     * @return 结果
     */
    public int insertAssetLiability(AssetLiability assetLiability);

    /**
     * 修改资产负债
     *
     * @return 结果
     */
    public int updateAssetLiability(AssetLiability assetLiability);

    /**
     * 删除资产负债
     *
     * @param id 资产负债ID
     * @return 结果
     */
    public int deleteAssetLiabilityById(AssetLiability assetLiability);

    /**
     * 批量删除资产负债
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAssetLiabilityByIds(String[] ids);
}
