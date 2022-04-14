package com.wjx.sportsplatformapi.service;

import com.alibaba.fastjson.JSON;
import com.wjx.sportsplatformapi.dao.ExcelDao;
import com.wjx.sportsplatformapi.entity.BasicInfo;
import com.wjx.sportsplatformapi.entity.GoodsOnSale;
import com.wjx.sportsplatformapi.entity.GoodsOnSaleRelated;
import com.wjx.sportsplatformapi.entity.ProductInfo;
import com.wjx.sportsplatformapi.util.FileUtil;
import com.wjx.sportsplatformapi.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wjx
 * @version 1.0
 * @date 2022/4/10 下午10:09
 */
@Service
public class ExcelService {

    @Autowired
    ExcelDao excelDao;

    //  将页面指定信息写入Excel
    public String writeToExcel(GoodsOnSale goodsOnSale){

//        String productcode = "0002-007099-02";
//        //  查询指定商品编码的商品信息
//        System.out.println("查询的商品编码是: " + productcode);
//
//        ProductInfo productInfo = excelDao.getProductInfoByProductCode(productcode);
//
//        System.out.println("获取的对象是 " + productInfo.toString());
//
//        TimeUtil timeUtil = new TimeUtil();
//
//        //  设置商品基本信息
//        //  店铺ID
//        int shop_id = 8;
//        //  规格类型
//        String spec_type = "多规格";
//        //  上架用序号
//        String issue = "20220319001";
//        //  商品类型
//        String product_type = "实体商品";
//        //  商品名称
//        String product_name = productInfo.getProduct_name();
//        //  商品副标题
//        String sub_product_name = productInfo.getProduct_name();
//        //  商品主图张数
//        int main_picture_num = 1;
//        //  商品轮播图张数
//        int carousel_figure_num = 2;
//        //  商品分类一级
//        // String first_category_name = productInfo.getFirst_category_name();
//        String first_category_name = "首饰名表";
//        //  商品分类二级
//        // String secondary_category_name = productInfo.getSecondary_category_name();
//        String secondary_category_name = "珠宝玉石";
//        //  商品短标题，截取商品名称前16位
//        String short_name;
//        if (productInfo.getProduct_name().length() <= 16) {
//            short_name = productInfo.getProduct_name().trim();
//        } else {
//            short_name = productInfo.getProduct_name().trim().substring(0, 15);
//        }
//
//        //  商品分组
//        String group = "小额消耗品";
//        //  商品支持
//        String label = "质量问题包赔";
//        //  商品规格
//        String good_specification = "多规格商品";
//        //  礼包内商品编码
//        String peck_gift_good_code = "0002-007083-01";
//        //  规格
//        String product_spec = "形状";
//        //  子规格
//        String product_spec_item = "方形";
//        //  规格图张数
//        int spec_picture__num = 1;
//        //  售卖价格
//        float selling_price = 200;
//        //  划线价
//        float original_price = 250;
//        //  成本价
//        float cost_price = 300;
//        //  库存量
//        int stock = productInfo.getStock();
//        //  库存预警
//        int stock_warning = 10;
//        //  商品编码
//        String product_code = productInfo.getProduct_code();
//        //  商品条形码
//        String product_sn = productInfo.getProduct_code().replaceAll("-", "");
//        //  商品详情显示库存，显示或隐藏
//        String stock_hide = "显示";
//        //  已出售数
//        int virtual_sales = 20;
//        //  商品详情显示销量，显示或隐藏
//        String sales_hide = "隐藏";
//        //  物流支持，快递发货、同城配送、上门自提
//        String dispatch_mode = "快递发货";
//        //  快递运费，“统一运费”或者“运费模板”
//        String express_price = "统一运费";
//        //  运费模板，取自数据库
//        String express_template = "10";
////        String express_template1 = "全国一件包邮运费模板";
//        //  定时下架
//        String auto_warehouse_time = timeUtil.DayLater(100) + " 23:59:59";
//        //  状态，上架售卖、上架隐藏、定时上架、放置仓库
//        String status = "上架售卖";
//        //  开启限购，是或否
//        String is_buy_num_limit = "是";
//        //  起购数量
//        int min_buy = 2;
//        //  每人限购数量
//        int max_buy_total = 100;
//        //  浏览权限
//        String browse_authority = "会员";
//        //  购买权限
//        String buy_authority = "VIP会员";
//        //  参与会员权益，会员卡、会员价、会员等级折扣
//        String join_member_discount = "会员价";
//        //  推广图文件名
//        String promotion_diagram_name = "tgt1.png,tgt2.png";
//        //  推广图链接
//        String promotion_diagram_link = "http://www.baidu.com";
//        //  推广图会员等级是否展示
//        String promotion_diagram_degree = "会员";
//        //  商品详情图张数
//        int detailed_diagram_num = 2;
//        //  授权图文件名
//        String authorize_diagram_name = "sqt1.jpg,sqt2.jpg";
//        //  公用图文件名
//        String common_diagram_name = "gyt1.png,gyt2.png";
//        //  活动名称
//        String acitvity_name = "活动" + System.currentTimeMillis();
//        //  活动开始时间
//        String acitvity_start_time = timeUtil.CurrentTime();
//        //  活动结束时间
//        String acitvity_end_time = timeUtil.DayLater(200) + " 23:59:59";
//        //  活动渠道
//        String acitvity_channel = "H5";
//        //  规则1活动对象，全部会员、会员等级、会员标签
//        String activity_object = "会员等级";
//        //  规则1会员等级
//        String member_degree = "普通会员";
//        //  规则1最大积分抵扣
//        int credit = 100;
//        //  规则1允许多件累计抵扣
//        String allow_accumulate = "是";
//
        //当前项目路径
        File file = new File("");
        String filePath = null;
        try {
            filePath = file.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("项目路径  " + filePath);



        //exce1文件路径
//        String excelPath = "\\src\\main\\resources\\file\\storage-rack-goods.xlsx";   // 源文件相对路径
        String excelPath = "/src/main/resources/file/storage-rack-goods.xlsx";   // 源文件相对路径
        String srcExcelPath = filePath + excelPath;        // 源文件绝对路径
        System.out.println("原 excel 文件路径  " + srcExcelPath);
//        String desPath = filePath + "\\src\\main\\resources\\file";;        // 最终文件夹相对路径
//        String desExcelPath = filePath + "\\src\\main\\resources\\file\\bak-storage-rack-goods1.xlsx";  // 最终文件绝对路径
//        //    在结果目标中设置文件位置的路径。必须在目标路径中设置，要是在源码中设置，就会提示有代码访问该文件，也是因为访问时访问的是目标路径中的资源
//        String relativepath = ClassUtils.getDefaultClassLoader().getResource("file").getPath() ;
//        System.out.println("relativepath 是  "+relativepath);
//        String desPath = relativepath;        // 最终文件夹相对路径
//        String desExcelPath = relativepath + "\\bak-storage-rack-goods.xlsx";  // 最终文件绝对路径

        FileUtil fileUtil = new FileUtil();
        //  fileUtil.readExcel(srcExcelPath);
        //  fileUtil.copyFile(srcExcelPath, desPath, "bak-");

        //  赋值给上架商品类
        GoodsOnSale goodsOnSalenew = new GoodsOnSale() ;
        goodsOnSalenew.setShop_id(goodsOnSale.getShop_id()) ;
        goodsOnSalenew.setSpec_type(goodsOnSale.getSpec_type());
        goodsOnSalenew.setIssue(goodsOnSale.getIssue());
        goodsOnSalenew.setProduct_type(goodsOnSale.getProduct_type());
        goodsOnSalenew.setProduct_name(goodsOnSale.getProduct_name());
        goodsOnSalenew.setSub_product_name(goodsOnSale.getSub_product_name());
        goodsOnSalenew.setMain_picture_num(goodsOnSale.getMain_picture_num());
        goodsOnSalenew.setCarousel_figure_num(goodsOnSale.getCarousel_figure_num());
        goodsOnSalenew.setFirst_category_name(goodsOnSale.getFirst_category_name());
        goodsOnSalenew.setSecondary_category_name(goodsOnSale.getSecondary_category_name())   ;
        goodsOnSalenew.setShort_name(goodsOnSale.getShort_name())  ;
        goodsOnSalenew.setGroup(goodsOnSale.getGroup())  ;
        goodsOnSalenew.setLabel(goodsOnSale.getLabel());
        goodsOnSalenew.setGood_specification(goodsOnSale.getGood_specification());
        goodsOnSalenew.setPeck_gift_good_code(goodsOnSale.getPeck_gift_good_code()) ;
        goodsOnSalenew.setProduct_spec(goodsOnSale.getProduct_spec());
        goodsOnSalenew.setProduct_spec_item(goodsOnSale.getProduct_spec_item())  ;
        goodsOnSalenew.setSpec_picture__num(goodsOnSale.getSpec_picture__num());
        goodsOnSalenew.setSelling_price(goodsOnSale.getSelling_price());
        goodsOnSalenew.setOriginal_price(goodsOnSale.getOriginal_price());
        goodsOnSalenew.setCost_price(goodsOnSale.getCost_price());
        goodsOnSalenew.setStock(goodsOnSale.getStock());
        goodsOnSalenew.setStock_warning(goodsOnSale.getStock_warning())  ;
        goodsOnSalenew.setProduct_code(goodsOnSale.getProduct_code())  ;
        goodsOnSalenew.setProduct_sn(goodsOnSale.getProduct_sn())  ;
        goodsOnSalenew.setStock_hide(goodsOnSale.getStock_hide());
        goodsOnSalenew.setVirtual_sales(goodsOnSale.getVirtual_sales())  ;
        goodsOnSalenew.setSales_hide(goodsOnSale.getSales_hide())  ;
        goodsOnSalenew.setDispatch_mode(goodsOnSale.getDispatch_mode())  ;
        goodsOnSalenew.setExpress_price(goodsOnSale.getExpress_price());
        goodsOnSalenew.setExpress_template(goodsOnSale.getExpress_template());
        goodsOnSalenew.setAuto_warehouse_time(goodsOnSale.getAuto_warehouse_time());
        goodsOnSalenew.setStatus(goodsOnSale.getStatus());
        goodsOnSalenew.setIs_buy_num_limit(goodsOnSale.getIs_buy_num_limit());
        goodsOnSalenew.setMin_buy(goodsOnSale.getMin_buy());
        goodsOnSalenew.setMax_buy_total(goodsOnSale.getMax_buy_total());
        goodsOnSalenew.setBrowse_authority(goodsOnSale.getBrowse_authority());
        goodsOnSalenew.setBuy_authority(goodsOnSale.getBuy_authority());
        goodsOnSalenew.setJoin_member_discount(goodsOnSale.getJoin_member_discount());
        goodsOnSalenew.setPromotion_diagram_name(goodsOnSale.getPromotion_diagram_name());
        goodsOnSalenew.setPromotion_diagram_link(goodsOnSale.getPromotion_diagram_link());
        goodsOnSalenew.setPromotion_diagram_degree(goodsOnSale.getPromotion_diagram_degree());
        goodsOnSalenew.setDetailed_diagram_num(goodsOnSale.getDetailed_diagram_num());
        goodsOnSalenew.setAuthorize_diagram_name(goodsOnSale.getAuthorize_diagram_name());
        goodsOnSalenew.setCommon_diagram_name(goodsOnSale.getCommon_diagram_name());
        goodsOnSalenew.setActivity_name(goodsOnSale.getActivity_name());
        goodsOnSalenew.setActivity_start_time(goodsOnSale.getActivity_start_time());
        goodsOnSalenew.setActivity_end_time(goodsOnSale.getActivity_end_time());
        goodsOnSalenew.setActivity_channel(goodsOnSale.getActivity_channel());
        goodsOnSalenew.setActivity_object(goodsOnSale.getActivity_object());
        goodsOnSalenew.setMember_degree(goodsOnSale.getMember_degree());
        goodsOnSalenew.setCredit(goodsOnSale.getCredit());
        goodsOnSalenew.setAllow_accumulate(goodsOnSale.getAllow_accumulate());

        String message = fileUtil.writeGoodsInfoToExcel( goodsOnSalenew, srcExcelPath);

        HashMap<String,Object> res = new HashMap<>();
        int  code = 0 ;
        if (message.equals("OK")){
            code = 1 ;
        } else {
            code = 0 ;
        }
        res.put("code",code);
        String res_json = JSON.toJSONString(res);
        System.out.println("res_json 是 "+res_json);
        return res_json;
    }

    //  将商品信息返回页面
    public String goodsRelated(){
        //  获得商品编码
        List<String> product_code_list = new ArrayList<>();
        product_code_list = excelDao.getProductCodeBySuppliersn("0002");
        for (int i=0;i<product_code_list.size();i++){
            System.out.println("第 "+i+" 个商品编码是：  "+product_code_list.get(i));
        }
        List<BasicInfo> product_code = new ArrayList<>();
        //  将商品编码进行转换，在前端页面进行操作
        for (int i=0;i<product_code_list.size();i++){
            System.out.println("第 "+i+" 个编码是：  "+product_code_list.get(i));
            BasicInfo basicInfo = new BasicInfo();
            basicInfo.setId(i+1);
            basicInfo.setName(product_code_list.get(i));
            product_code.add(basicInfo);
        }

        //  获得商品分组
        List<String> group_list = new ArrayList<>();
        group_list = excelDao.getGroupByShopId("8");
        List<BasicInfo> group = new ArrayList<>();
        //  将商品分组进行转换，在前端页面进行操作
        for (int i=0;i<group_list.size();i++){
            System.out.println("第 "+i+" 个组是：  "+group_list.get(i));
            BasicInfo basicInfo = new BasicInfo();
            basicInfo.setId(i+1);
            basicInfo.setName(group_list.get(i));
            group.add(basicInfo);
        }

        for (int j=0;j<group.size();j++){
            System.out.println(group.get(j).getId()+"   "+group.get(j).getName());
        }

        //  将商品信息加到返回信息中
        HashMap<String,Object> res = new HashMap<>();
        res.put("product_code",product_code);       //  将商品编码加到返回信息中
        res.put("group",group);                  //  将商品分组加到返回信息中
        String res_json = JSON.toJSONString(res);
        System.out.println("res_json 是 "+res_json);
        return res_json;
    }

}
