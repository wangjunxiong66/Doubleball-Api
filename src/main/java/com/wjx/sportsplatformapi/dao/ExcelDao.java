package com.wjx.sportsplatformapi.dao;

import com.wjx.sportsplatformapi.entity.BasicInfo;
import com.wjx.sportsplatformapi.entity.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//  @Mapper
@Repository
public interface ExcelDao {

    public ProductInfo getProductInfoByProductCode(@Param("product_code") String product_code);
    public List<String> getProductCodeBySuppliersn(@Param("supplier_sn") String supplier_sn);
    public List<String> getGroupByShopId(@Param("shop_id") Integer shop_id);
    public String getGroupByShopIdAndId(@Param("shop_id") Integer shop_id, @Param("id") Integer id);
    public List<BasicInfo> getFirstCategoryNameByShopidAndLevel(@Param("shop_id") Integer shop_id, @Param("level") Integer level);
    public List<BasicInfo> getCategoryNameByShopidAndParentid(@Param("shop_id") Integer shop_id, @Param("parent_id") Integer parent_id);

}

