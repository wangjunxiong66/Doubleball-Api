package com.wjx.sportsplatformapi.dao;

import com.wjx.sportsplatformapi.entity.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

//  @Mapper
@Repository
public interface ExcelDao {

    public ProductInfo getProductInfoByProductCode(@Param("product_code") String product_code);


}

