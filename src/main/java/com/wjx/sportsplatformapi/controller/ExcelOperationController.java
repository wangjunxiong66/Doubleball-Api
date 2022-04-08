package com.wjx.sportsplatformapi.controller;

import com.alibaba.fastjson.JSON;
import com.wjx.sportsplatformapi.dao.ExcelDao;
import com.wjx.sportsplatformapi.entity.GoodsOnSale;
import com.wjx.sportsplatformapi.entity.ProductInfo;
import com.wjx.sportsplatformapi.util.FileUtil;
import com.wjx.sportsplatformapi.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/excelOP")
public class ExcelOperationController {

    @Autowired
    ExcelDao excelDao;

    @PostMapping("/writeto")
    public String tableTo(@RequestBody GoodsOnSale goodsOnSale){
        System.out.println("goodsOnSale 信息是  "+goodsOnSale.toString());
        HashMap<String,Object> res = new HashMap<>();
        String  code = "OK";
        res.put("code",code);
        String res_json = JSON.toJSONString(res);
        System.out.println("res_json 是 "+res_json);
        return res_json;

    }

    @GetMapping("/writetoexcel")
    public void tableToExcel() {

        System.out.println("进入 controller -- TableToExcel() 方法");
        String productcode = "0002-007099-02";
        //  查询指定商品编码的商品信息
        System.out.println("查询的商品编码是: " + productcode);

        ProductInfo productInfo = excelDao.getProductInfoByProductCode(productcode);

        System.out.println("获取的对象是 " + productInfo.toString());

        TimeUtil timeUtil = new TimeUtil();

        //  设置商品基本信息
        //  店铺ID
        int shop_id = 8;
        //  规格类型
        String spec_type = "多规格";
        //  上架用序号
        String issue = "20220319001";
        //  商品类型
        String product_type = "实体商品";
        //  商品名称
        String product_name = productInfo.getProduct_name();
        //  商品副标题
        String sub_product_name = productInfo.getProduct_name();
        //  商品主图张数
        int main_picture_num = 1;
        //  商品轮播图张数
        int carousel_figure_num = 2;
        //  商品分类一级
        // String first_category_name = productInfo.getFirst_category_name();
        String first_category_name = "首饰名表";
        //  商品分类二级
        // String secondary_category_name = productInfo.getSecondary_category_name();
        String secondary_category_name = "珠宝玉石";
        //  商品短标题，截取商品名称前16位
        String short_name;
        if (productInfo.getProduct_name().length() <= 16) {
            short_name = productInfo.getProduct_name().trim();
        } else {
            short_name = productInfo.getProduct_name().trim().substring(0, 15);
        }

        //  商品分组
        String group = "小额消耗品";
        //  商品支持
        String label = "质量问题包赔";
        //  商品规格
        String good_specification = "多规格商品";
        //  礼包内商品编码
        String peck_gift_good_code = "0002-007083-01";
        //  规格
        String product_spec = "形状";
        //  子规格
        String product_spec_item = "方形";
        //  规格图张数
        int spec_picture__num = 1;
        //  售卖价格
        float selling_price = 200;
        //  划线价
        float original_price = 250;
        //  成本价
        float cost_price = 300;
        //  库存量
        int stock = productInfo.getStock();
        //  库存预警
        int stock_warning = 10;
        //  商品编码
        String product_code = productInfo.getProduct_code();
        //  商品条形码
        String product_sn = productInfo.getProduct_code().replaceAll("-", "");
        //  商品详情显示库存，显示或隐藏
        String stock_hide = "显示";
        //  已出售数
        int virtual_sales = 20;
        //  商品详情显示销量，显示或隐藏
        String sales_hide = "隐藏";
        //  物流支持，快递发货、同城配送、上门自提
        String dispatch_mode = "快递发货";
        //  快递运费，“统一运费”或者“运费模板”
        String express_price = "统一运费";
        //  运费模板，取自数据库
        String express_template = "10";
//        String express_template1 = "全国一件包邮运费模板";
        //  定时下架
        String auto_warehouse_time = timeUtil.DayLater(100) + " 23:59:59";
        //  状态，上架售卖、上架隐藏、定时上架、放置仓库
        String status = "上架售卖";
        //  开启限购，是或否
        String is_buy_num_limit = "是";
        //  起购数量
        int min_buy = 2;
        //  每人限购数量
        int max_buy_total = 100;
        //  浏览权限
        String browse_authority = "会员";
        //  购买权限
        String buy_authority = "VIP会员";
        //  参与会员权益，会员卡、会员价、会员等级折扣
        String join_member_discount = "会员价";
        //  推广图文件名
        String promotion_diagram_name = "tgt1.png,tgt2.png";
        //  推广图链接
        String promotion_diagram_link = "http://www.baidu.com";
        //  推广图会员等级是否展示
        String promotion_diagram_degree = "会员";
        //  商品详情图张数
        int detailed_diagram_num = 2;
        //  授权图文件名
        String authorize_diagram_name = "sqt1.jpg,sqt2.jpg";
        //  公用图文件名
        String common_diagram_name = "gyt1.png,gyt2.png";
        //  活动名称
        String acitvity_name = "活动" + System.currentTimeMillis();
        //  活动开始时间
        String acitvity_start_time = timeUtil.CurrentTime();
        //  活动结束时间
        String acitvity_end_time = timeUtil.DayLater(200) + " 23:59:59";
        //  活动渠道
        String acitvity_channel = "H5";
        //  规则1活动对象，全部会员、会员等级、会员标签
        String activity_object = "会员等级";
        //  规则1会员等级
        String member_degree = "普通会员";
        //  规则1最大积分抵扣
        int credit = 100;
        //  规则1允许多件累计抵扣
        String allow_accumulate = "是";

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
        String excelPath = "\\src\\main\\resources\\file\\storage-rack-goods.xlsx";   // 源文件相对路径
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
        GoodsOnSale goodsOnSale = new GoodsOnSale() ;
        goodsOnSale.setShop_id(shop_id) ;
        goodsOnSale.setSpec_type(spec_type);
        goodsOnSale.setIssue(issue);
        goodsOnSale.setProduct_type(product_type);
        goodsOnSale.setProduct_name(product_name);
        goodsOnSale.setSub_product_name(sub_product_name);
        goodsOnSale.setMain_picture_num(main_picture_num);
        goodsOnSale.setCarousel_figure_num(carousel_figure_num);
        goodsOnSale.setFirst_category_name(first_category_name);
        goodsOnSale.setSecondary_category_name(secondary_category_name)   ;
        goodsOnSale.setShort_name(short_name)  ;
        goodsOnSale.setGroup(group)  ;
        goodsOnSale.setLabel(label);
        goodsOnSale.setGood_specification(good_specification);
        goodsOnSale.setPeck_gift_good_code(peck_gift_good_code) ;
        goodsOnSale.setProduct_spec(product_spec);
        goodsOnSale.setProduct_spec_item(product_spec_item)  ;
        goodsOnSale.setSpec_picture__num(spec_picture__num);
        goodsOnSale.setSelling_price(selling_price);
        goodsOnSale.setOriginal_price(original_price);
        goodsOnSale.setCost_price(cost_price);
        goodsOnSale.setStock(stock);
        goodsOnSale.setStock_warning(stock_warning)  ;
        goodsOnSale.setProduct_code(product_code)  ;
        goodsOnSale.setProduct_sn(product_sn)  ;
        goodsOnSale.setStock_hide(stock_hide);
        goodsOnSale.setVirtual_sales(virtual_sales)  ;
        goodsOnSale.setSales_hide(sales_hide)  ;
        goodsOnSale.setDispatch_mode(dispatch_mode)  ;
        goodsOnSale.setExpress_price(express_price);
        goodsOnSale.setExpress_template(express_template);
        goodsOnSale.setAuto_warehouse_time(auto_warehouse_time);
        goodsOnSale.setStatus(status);
        goodsOnSale.setIs_buy_num_limit(is_buy_num_limit);
        goodsOnSale.setMin_buy(min_buy);
        goodsOnSale.setMax_buy_total(max_buy_total);
        goodsOnSale.setBrowse_authority(browse_authority);
        goodsOnSale.setBuy_authority(buy_authority);
        goodsOnSale.setJoin_member_discount(join_member_discount);
        goodsOnSale.setPromotion_diagram_name(promotion_diagram_name);
        goodsOnSale.setPromotion_diagram_link(promotion_diagram_link);
        goodsOnSale.setPromotion_diagram_degree(promotion_diagram_degree);
        goodsOnSale.setDetailed_diagram_num(detailed_diagram_num);
        goodsOnSale.setAuthorize_diagram_name(authorize_diagram_name);
        goodsOnSale.setCommon_diagram_name(common_diagram_name);
        goodsOnSale.setActivity_name(acitvity_name);
        goodsOnSale.setActivity_start_time(acitvity_start_time);
        goodsOnSale.setActivity_end_time(acitvity_end_time);
        goodsOnSale.setActivity_channel(acitvity_channel);
        goodsOnSale.setActivity_object(activity_object);
        goodsOnSale.setMember_degree(member_degree);
        goodsOnSale.setCredit(credit);
        goodsOnSale.setAllow_accumulate(allow_accumulate);

        fileUtil.writeGoodsInfoToExcel( goodsOnSale, srcExcelPath);

    }


    @GetMapping("/test")
    public void test(){
        TimeUtil timeUtil = new TimeUtil();
        System.out.println(" 当前时间是  "+timeUtil.CurrentTime());
        System.out.println(" 2天后时间是  "+timeUtil.DayLater(2));

    }


}
