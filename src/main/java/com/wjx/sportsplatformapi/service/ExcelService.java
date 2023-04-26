package com.wjx.sportsplatformapi.service;

import com.alibaba.fastjson.JSON;
import com.wjx.sportsplatformapi.dao.ExcelDao;
import com.wjx.sportsplatformapi.entity.BasicInfo;
import com.wjx.sportsplatformapi.entity.GoodsOnSale;
import com.wjx.sportsplatformapi.entity.GoodsOnSaleRelated;
import com.wjx.sportsplatformapi.entity.ProductInfo;
import com.wjx.sportsplatformapi.util.CheckTools;
import com.wjx.sportsplatformapi.util.FileUtil;
import com.wjx.sportsplatformapi.util.TimeUtil;
import org.apache.tomcat.util.buf.StringUtils;
import org.apache.commons.math3.util.* ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.util.NumberUtils;

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

        //  获取一级分类和二级分类的id，然后通过id获取对应的名称
        int first_category_id = Integer.parseInt(goodsOnSale.getFirst_category_name());
        int secondary_category_id = Integer.parseInt(goodsOnSale.getSecondary_category_name());
        System.out.println("first_category_id "+first_category_id+"      secondary_category_id "+secondary_category_id);

        List<BasicInfo> first_category_name_list = new ArrayList<>();
        first_category_name_list = excelDao.getFirstCategoryNameByShopidAndLevel(8,1);
        for (int i=0;i<first_category_name_list.size();i++){
            BasicInfo basicInfo = new BasicInfo();
            basicInfo = first_category_name_list.get(i);
            if (basicInfo.getId()==first_category_id){
                goodsOnSale.setFirst_category_name(basicInfo.getName());
            }
        }

        List<BasicInfo> Secondary_category_name_list = new ArrayList<>();
        Secondary_category_name_list = excelDao.getCategoryNameByShopidAndParentid(8,first_category_id);
        for (int i=0;i<Secondary_category_name_list.size();i++){
            BasicInfo basicInfo = new BasicInfo();
            basicInfo = Secondary_category_name_list.get(i);
            if (basicInfo.getId()==secondary_category_id){
                goodsOnSale.setSecondary_category_name(basicInfo.getName());
            }
        }

        //  获取分组的id，然后通过id获取对应的名称
        String group_temp = goodsOnSale.getGroup();
        String[] group_arr = group_temp.split(",");
        int[] group_array = new int[group_arr.length] ;
        for (int i=0;i<group_arr.length;i++)              //把group_arr中的数据进行类型转换并存入到int数组中
        {
            int num = Integer.parseInt(group_arr[i]);
            group_array[i] = num ;
        }
        String[] group_list = new String[group_arr.length];
        for (int i=0;i<group_array.length;i++){
            group_list[i] = excelDao.getGroupByShopIdAndId(8,group_array[i]);
        }
        group_temp = StringUtils.join(group_list);
        System.out.println("group_temp  "+group_temp);
        goodsOnSale.setGroup(group_temp);

        //  获取"商品详情显示库存"的id，然后通过id获取对应的名称
        if (CheckTools.isNumeric(goodsOnSale.getStock_hide())){
            int stock_hide_num = Integer.parseInt(goodsOnSale.getStock_hide());
            if (stock_hide_num==1){
                goodsOnSale.setStock_hide("隐藏");
            } else if (stock_hide_num==0){
                goodsOnSale.setStock_hide("显示");
            }
        }

        //  获取"商品编码"的id，然后通过id获取对应的名称
        if (CheckTools.isNumeric(goodsOnSale.getProduct_code())){
            int product_code_int = Integer.parseInt(goodsOnSale.getProduct_code());
            System.out.println("获取的商品编码id是  "+product_code_int);

            List<BasicInfo> product_code_list = new ArrayList<>();
            product_code_list = excelDao.getProductCodeBySuppliersn("0002");
            for (int i=0;i<product_code_list.size();i++){
                System.out.println("第 "+i+" 个商品 id 是 "+product_code_list.get(i).getId()+"  编码是  "+product_code_list.get(i).getName());
                if (product_code_int==product_code_list.get(i).getId()){
                    goodsOnSale.setProduct_code(product_code_list.get(i).getName());
                }
            }
        }


        //当前项目路径
        File file = new File("");
        String filePath = null;
        try {
            //  返回抽象路径名的规范路径名字符串。规范路径名是绝对路径名，并且是惟一的。
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
        System.out.println("进入 ExcelService -- goodsRelated 方法");
        //  获得商品编码
        List<BasicInfo> product_code_list = new ArrayList<>();
        product_code_list = excelDao.getProductCodeBySuppliersn("0002");
        for (int i=0;i<product_code_list.size();i++){
            System.out.println("第 "+i+" 个商品 id 是 "+product_code_list.get(i).getId()+"  编码是  "+product_code_list.get(i).getName());
        }

        //  获得商品分组
        List<String> group_list = new ArrayList<>();
        group_list = excelDao.getGroupByShopId(8);
        List<BasicInfo> group = new ArrayList<>();
        //  将商品分组进行转换，在前端页面进行操作
        for (int i=0;i<group_list.size();i++){
            System.out.println("第 "+i+" 个组是：  "+group_list.get(i));
            BasicInfo basicInfo = new BasicInfo();
            basicInfo.setId(i+1);
            basicInfo.setName(group_list.get(i));
            group.add(basicInfo);
        }

        //  获得商品一级分类
        List<BasicInfo> first_category_name = new ArrayList<>();
        first_category_name = excelDao.getFirstCategoryNameByShopidAndLevel(8,1);
        for (int i=0;i<first_category_name.size();i++){
            BasicInfo basicInfo = new BasicInfo();
            basicInfo = first_category_name.get(i);
            System.out.println("第 "+i+" 个一级分类是：  "+basicInfo.getId()+"     "+basicInfo.getName());
        }

        //  获取指定excel文件内容
        String relativepath = ClassUtils.getDefaultClassLoader().getResource("file").getPath() ;
        System.out.println("relativepath 是  "+relativepath);
        String desExcel = relativepath + "/storage-rack-goods-on-shelve.xlsx";  // 最终文件绝对路径
        FileUtil fileUtil = new FileUtil();
        List<GoodsOnSale> excel_content = fileUtil.readExcelContent(desExcel);


        //  将商品信息加到返回信息中
        HashMap<String,Object> res = new HashMap<>();
        res.put("product_code",product_code_list);       //  将商品编码加到返回信息中
        res.put("group",group);                  //  将商品分组加到返回信息中
        res.put("first_category_name",first_category_name);                  //  将商品一级分类加到返回信息中
        res.put("excelForm",excel_content);                         //  将excel中的商品信息返回
        String res_json = JSON.toJSONString(res);
        System.out.println("res_json 是 "+res_json);
        return res_json;
    }

    //  获取指定分类下的子分类
    public String getNextCategory(Integer parent_id){

        System.out.println("进入 ExcelService -- getNextCategory 方法 , 参数是  "+parent_id);
        List<BasicInfo> next_category_name = new ArrayList<>();
        next_category_name = excelDao.getCategoryNameByShopidAndParentid(8,parent_id);
        for (int i=0;i<next_category_name.size();i++){
            BasicInfo basicInfo = new BasicInfo();
            basicInfo = next_category_name.get(i);
            System.out.println("第 "+i+" 个二级分类是：  "+basicInfo.getId()+"     "+basicInfo.getName());
        }

        //  将商品信息加到返回信息中
        HashMap<String,Object> res = new HashMap<>();
        res.put("secondary_category_name",next_category_name);                  //  将商品二级分类加到返回信息中
        String res_json = JSON.toJSONString(res);
        System.out.println("res_json 是 "+res_json);
        return res_json;
    }

    //  读取指定Excel文件
    public void displaceExcel(){

    }

}
