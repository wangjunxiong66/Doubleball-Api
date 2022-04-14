package com.wjx.sportsplatformapi.dao;

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
    public List<String> getGroupByShopId(@Param("shop_id") String shop_id);
//    public List<String> getFirstCategoryNameByShopId(@Param("shop_id") String shop_id);

}

