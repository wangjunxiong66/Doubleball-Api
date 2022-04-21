package com.wjx.sportsplatformapi.util;

import com.alibaba.fastjson.JSON;
import com.wjx.sportsplatformapi.entity.GoodsOnSale;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.ClassUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileUtil {

    //  复制文件至指定路径
    public void copyFile(String srcFilePathStr, String desPathStr, String otherLogo)
    {
        String desFileStr = null ;   // 定义目标文件的具体地址
        System.out.println("进到FileUtil类-->copyFile方法");
        //获取源文件的名称，srcPathStr是文件路径，desPathStr是文件夹路径，otherLogo是为了给原文件名加一个其他字符标记
        File srcFile = new File(srcFilePathStr);
        if (srcFile.isFile() && srcFile.exists()) { //判断文件是否存在
            String srcFileName = srcFilePathStr.substring(srcFilePathStr.lastIndexOf("\\")+1);
            System.out.println("源文件名称:  "+srcFileName);
            String newFileName = null ;
            if (otherLogo.length()>0){
                newFileName = otherLogo + srcFilePathStr.substring(srcFilePathStr.lastIndexOf("\\")+1);     //目标文件名字
            } else {
                newFileName = srcFilePathStr.substring(srcFilePathStr.lastIndexOf("\\")+1);     //目标文件名字
            }

            desFileStr = desPathStr + File.separator + newFileName;     // 设置目标文件的具体地址
            System.out.println("目标文件地址: "+desFileStr);
            try
            {
                FileInputStream fis = new FileInputStream(srcFilePathStr);    //创建输入流对象
                FileOutputStream fos = new FileOutputStream(desFileStr);     //创建输出流对象
                byte datas[] = new byte[1024*8];    //创建搬运工具
                int len = 0;    //创建长度
                while((len = fis.read(datas))!=-1)    //循环读取数据
                {
                    fos.write(datas,0,len);
                }
                fis.close();    //释放资源
                fos.close();    //释放资源
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        } else {
                System.out.println("找不到指定的源文件，生成目标文件失败！");
                return;
            }

         File desFile = new File(desFileStr);
         if (desFile.isFile() && desFile.exists()) { //判断文件是否存在
             System.out.println("生成目标文件成功");
         }else {
            System.out.println("找不到指定的目标文件，生成目标文件失败！");
             return;
         }


    }

    //  读取excel文件内容
    public void readExcel(String fielPath){
        System.out.println("进到FileUtil类-->readExcel方法");
        try {
            File excel = new File(fielPath);
            if (excel.isFile() && excel.exists()) { //判断文件是否存在
                String[] split = excel.getName().split("\\."); //   "."是特殊字符，需要转义，最终得到了名字storage-rack-goods.xlsx的字符数组
                for (int i = 0; i < split.length; i++) {
                    System.out.println("split[" + i + "]      " + split[i]);
                }
                Workbook wb;
                //根据文件后缀(xls/xlsx)进行判断
                FileInputStream fis = new FileInputStream(excel); // 文件流对象
                if ("x1s".equals(split[1])) {
//                    FileInputStream fis = new FileInputStream(excel); // 文件流对象
                    wb = new HSSFWorkbook(fis);
                } else if ("xlsx".equals(split[1])) {
                    wb = new XSSFWorkbook(excel);
                } else {
                    System.out.println("文件类型错误!");
                    return ;
                }

                // 读取Excel文件，开始解析
                Sheet sheet = wb.getSheetAt(0);     //读取sheet 0
                int firstRowIndex = sheet.getFirstRowNum();     // 获取实际行的第一行，如果前几行是列名，可以加上指定行数略过不读，例如 sheet.getFirstRowNum()+3
                int lastRowIndex = sheet.getLastRowNum();   // 获取实际行的最后一行
                System.out.println("firstRowIndex: " + firstRowIndex);
                System.out.println("lastRowIndex: " + lastRowIndex);
                for (int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) { //遍历行
                    System.out.println("rIndex: " + rIndex);
                    Row row = sheet.getRow(rIndex);   // 获取指定行
                    if (row != null) {
                        int firstCellIndex = row.getFirstCellNum();  // 获取指定行的第一个实际单元格
                        int lastCellIndex = row.getLastCellNum();   // 获取指定行的最后一个实际单元格
                        for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) { // 遍历列
                            Cell cell = row.getCell(cIndex);    // 获取指定行的指定单元格
                            if (cell != null) {
                                System.out.println(cell.toString());
                            }
                        }
                    }
                }
            }else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //  读取excel文件内容并返回到页面
    public List<GoodsOnSale> readExcelContent(String fielPath){
        System.out.println("进到FileUtil类-->readExcel方法");
        List<GoodsOnSale> goodsOnSales_list = new ArrayList<>();

        try {
            File excel = new File(fielPath);
            if (excel.isFile() && excel.exists()) { //判断文件是否存在
                String[] split = excel.getName().split("\\."); //   "."是特殊字符，需要转义，最终得到了名字storage-rack-goods.xlsx的字符数组
                for (int i = 0; i < split.length; i++) {
                    System.out.println("split[" + i + "]      " + split[i]);
                }
                Workbook wb;
                //根据文件后缀(xls/xlsx)进行判断
                FileInputStream fis = new FileInputStream(excel); // 文件流对象
                if ("x1s".equals(split[1])) {
//                    FileInputStream fis = new FileInputStream(excel); // 文件流对象
                    wb = new HSSFWorkbook(fis);
                } else if ("xlsx".equals(split[1])) {
                    wb = new XSSFWorkbook(excel);
                } else {
                    System.out.println("文件类型错误!");
                    GoodsOnSale goodsOnSale = new GoodsOnSale();
                    goodsOnSale = null;
                    goodsOnSales_list.add(goodsOnSale);
                    return goodsOnSales_list ;
                }

                // 读取Excel文件，开始解析
                Sheet sheet = wb.getSheetAt(0);     //读取sheet 0
                int firstRowIndex = sheet.getFirstRowNum()+3;     // 获取实际行的第一行，如果前几行是列名，可以加上指定行数略过不读，例如 sheet.getFirstRowNum()+3
                int lastRowIndex = sheet.getLastRowNum();   // 获取实际行的最后一行
                System.out.println("firstRowIndex: " + firstRowIndex);
                System.out.println("lastRowIndex: " + lastRowIndex);
                for (int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) { //遍历行
                    GoodsOnSale goodsOnSale = new GoodsOnSale();
                    System.out.println("rIndex: " + rIndex);
                    Row row = sheet.getRow(rIndex);   // 获取指定行
                    if (row != null) {
                        int firstCellIndex = row.getFirstCellNum();  // 获取指定行的第一个实际单元格
                        int lastCellIndex = row.getLastCellNum();   // 获取指定行的最后一个实际单元格
                        for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) { // 遍历列
                            System.out.println("cIndex = "+cIndex);
                            Cell cell = row.getCell(cIndex);    // 获取指定行的指定单元格
                            if (cell != null) {
                                String cell_content = getCellValue(cell);
                                System.out.println("cell_content   "+cell_content);
                                System.out.println("cell.getCellType()    "+cell.getCellType());

                                switch (cIndex){
                                    case 0: goodsOnSale.setShop_id(Double.valueOf(cell_content).intValue()); break;
                                    case 1: goodsOnSale.setSpec_type(cell_content); break;
                                    case 2: goodsOnSale.setIssue(cell_content); break;
                                    case 3: goodsOnSale.setProduct_type(cell_content); break;
                                    case 4: goodsOnSale.setProduct_name(cell_content); break;
                                    case 5: goodsOnSale.setSub_product_name(cell_content); break;
                                    case 6: goodsOnSale.setMain_picture_num(Double.valueOf(cell_content).intValue()); break;
                                    case 7: goodsOnSale.setCarousel_figure_num(Double.valueOf(cell_content).intValue()); break;
                                    case 8: goodsOnSale.setFirst_category_name(cell_content); break;
                                    case 9: goodsOnSale.setSecondary_category_name(cell_content); break;
                                    case 10: goodsOnSale.setShort_name(cell_content); break;
                                    case 11: goodsOnSale.setGroup(cell_content); break;
                                    case 12: goodsOnSale.setLabel(cell_content); break;
                                    case 13: goodsOnSale.setGood_specification(cell_content); break;
                                    case 14: goodsOnSale.setPeck_gift_good_code(cell_content); break;
                                    case 15: goodsOnSale.setProduct_spec(cell_content); break;
                                    case 16: goodsOnSale.setProduct_spec_item(cell_content); break;
                                    case 17: goodsOnSale.setSpec_picture__num(Double.valueOf(cell_content).intValue()); break;
                                    case 18: goodsOnSale.setSelling_price(Float.valueOf(cell_content)); break;
                                    case 19: goodsOnSale.setOriginal_price(Float.valueOf(cell_content)); break;
                                    case 20: goodsOnSale.setCost_price(Float.parseFloat(cell_content)); break;
                                    case 21: goodsOnSale.setStock(Double.valueOf(cell_content).intValue()); break;
                                    case 22: goodsOnSale.setStock_warning(Double.valueOf(cell_content).intValue()); break;
                                    case 23: goodsOnSale.setProduct_code(cell_content); break;
                                    case 24: goodsOnSale.setProduct_sn(cell_content); break;
                                    case 25: goodsOnSale.setStock_hide(cell_content); break;
                                    case 26: goodsOnSale.setVirtual_sales(Double.valueOf(cell_content).intValue()); break;
                                    case 27: goodsOnSale.setSales_hide(cell_content); break;
                                    case 28: goodsOnSale.setDispatch_mode(cell_content); break;
                                    case 29: goodsOnSale.setExpress_price(cell_content); break;
                                    case 30: goodsOnSale.setExpress_template(cell_content); break;
                                    case 31: goodsOnSale.setAuto_warehouse_time(cell_content); break;
                                    case 32: goodsOnSale.setStatus(cell_content); break;
                                    case 33: goodsOnSale.setIs_buy_num_limit(cell_content); break;
                                    case 34: goodsOnSale.setMin_buy(Double.valueOf(cell_content).intValue()); break;
                                    case 35: goodsOnSale.setMax_buy_total(Double.valueOf(cell_content).intValue()); break;
                                    case 36: goodsOnSale.setBrowse_authority(cell_content); break;
                                    case 37: goodsOnSale.setBuy_authority(cell_content); break;
                                    case 38: goodsOnSale.setJoin_member_discount(cell_content); break;
                                    case 39: goodsOnSale.setPromotion_diagram_name(cell_content); break;
                                    case 40: goodsOnSale.setPromotion_diagram_link(cell_content); break;
                                    case 41: goodsOnSale.setPromotion_diagram_degree(cell_content); break;
                                    case 42: goodsOnSale.setDetailed_diagram_num(Double.valueOf(cell_content).intValue()); break;
                                    case 43: goodsOnSale.setAuthorize_diagram_name(cell_content); break;
                                    case 44: goodsOnSale.setCommon_diagram_name(cell_content); break;
                                    case 45: goodsOnSale.setActivity_name(cell_content); break;
                                    case 46: goodsOnSale.setActivity_start_time(cell_content); break;
                                    case 47: goodsOnSale.setActivity_end_time(cell_content); break;
                                    case 48: goodsOnSale.setActivity_channel(cell_content); break;
                                    case 49: goodsOnSale.setActivity_object(cell_content); break;
                                    case 50: goodsOnSale.setMember_degree(cell_content); break;
                                    case 51: goodsOnSale.setCredit(Double.valueOf(cell_content).intValue()); break;
                                    case 52: goodsOnSale.setAllow_accumulate(cell_content); break;
                                }

                            }

                        }
                    }

                    goodsOnSales_list.add(goodsOnSale) ;

                }


            }else {
                System.out.println("找不到指定的文件");
                GoodsOnSale goodsOnSale = new GoodsOnSale();
                goodsOnSale = null;
                goodsOnSales_list.add(goodsOnSale);
                return goodsOnSales_list ;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return goodsOnSales_list  ;
    }

    //  将商品信息写入excel文件
    public String writeGoodsInfoToExcel(GoodsOnSale goodsOnSale, String srcExcelPath){
        System.out.println("进入 FileUtil --》 writeGoodsInfoToExcel");
            File excel = new File(srcExcelPath);
            if (excel.isFile() && excel.exists()) { //判断文件是否存在
                String[] split = excel.getName().split("\\."); //   "."是特殊字符，需要转义，最终得到了名字storage-rack-goods.xlsx的字符数组
                for (int i = 0; i < split.length; i++) {
                    System.out.println("split[" + i + "]      " + split[i]);
                }

                Workbook wb;
                try {
                    //  根据文件后缀(xls/xlsx)进行判断，将要操作的文件加载到内存
                    FileInputStream fis = new FileInputStream(excel); // 文件流对象
                    if ("x1s".equals(split[1])) {
                        wb = new HSSFWorkbook(fis);
                    } else if ("xlsx".equals(split[1])) {
                        wb = new XSSFWorkbook(excel);
                    } else {
                        System.out.println("文件类型错误!");
                        return "Error";
                    }

                    Sheet sheet = wb.getSheetAt(0);   // 可以通过名称获得sheet页，例如getSheet("学生信息")，也可以通过下标得到getSheetAt(0)
                    Row row = sheet.createRow(sheet.getLastRowNum() + 1);    //  在实际行下面追加一行数据
                    row.createCell(0).setCellValue(goodsOnSale.getShop_id());  //  第一列  店铺ID
                    row.createCell(1).setCellValue(goodsOnSale.getSpec_type());   //  第二列  规格类型
                    row.createCell(2).setCellValue(goodsOnSale.getIssue());   //  第三列  上架用序号
                    row.createCell(3).setCellValue(goodsOnSale.getProduct_type());   //  第四列  商品类型
                    row.createCell(4).setCellValue(goodsOnSale.getProduct_name());   //  第五列  商品名称
                    row.createCell(5).setCellValue(goodsOnSale.getSub_product_name());   //  第六列  商品副标题
                    row.createCell(6).setCellValue(goodsOnSale.getMain_picture_num());   //  第七列  商品主图张数
                    row.createCell(7).setCellValue(goodsOnSale.getCarousel_figure_num());   //  第八列  商品轮播图张数
                    row.createCell(8).setCellValue(goodsOnSale.getFirst_category_name());   //  第九列  商品分类一级
                    row.createCell(9).setCellValue(goodsOnSale.getSecondary_category_name());   //  第十列  商品分类二级
                    row.createCell(10).setCellValue(goodsOnSale.getShort_name());   //  第十一列  商品短标题
                    row.createCell(11).setCellValue(goodsOnSale.getGroup());   //  第十二列  商品分组
                    row.createCell(12).setCellValue(goodsOnSale.getLabel());   //  第十三列  商品支持
                    row.createCell(13).setCellValue(goodsOnSale.getGood_specification());   //  第十四列  商品规格
                    row.createCell(14).setCellValue(goodsOnSale.getPeck_gift_good_code());   //  第十五列  礼包内商品编码
                    row.createCell(15).setCellValue(goodsOnSale.getProduct_spec());   //  第十六列  规格
                    row.createCell(16).setCellValue(goodsOnSale.getProduct_spec_item());   //  第十七列  子规格
                    row.createCell(17).setCellValue(goodsOnSale.getSpec_picture__num());   //  第十八列  规格图张数
                    row.createCell(18).setCellValue(goodsOnSale.getSelling_price());   //  第十九列  售卖价格
                    row.createCell(19).setCellValue(goodsOnSale.getOriginal_price());   //  第二十列  划线价
                    row.createCell(20).setCellValue(goodsOnSale.getCost_price());   //  第二十一列  成本价
                    row.createCell(21).setCellValue(goodsOnSale.getStock());   //  第二十二列  库存量
                    row.createCell(22).setCellValue(goodsOnSale.getStock_warning());   //  第二十三列  库存预警
                    row.createCell(23).setCellValue(goodsOnSale.getProduct_code());   //  第二十四列  商品编码
                    row.createCell(24).setCellValue(goodsOnSale.getProduct_sn());   //  第二十五列  商品条形码
                    row.createCell(25).setCellValue(goodsOnSale.getStock_hide());   //  第二十六列  商品详情显示库存，显示或隐藏
                    row.createCell(26).setCellValue(goodsOnSale.getVirtual_sales());   //  第二十七列  已出售数
                    row.createCell(27).setCellValue(goodsOnSale.getSales_hide());   //  第二十八列  商品详情显示销量，显示或隐藏
                    row.createCell(28).setCellValue(goodsOnSale.getDispatch_mode());   //  第二十九列  物流支持，快递发货、同城配送、上门自提
                    row.createCell(29).setCellValue(goodsOnSale.getExpress_price());   //  第三十列  快递运费，“统一运费”或者“运费模板”
                    row.createCell(30).setCellValue(goodsOnSale.getExpress_template());   //  第三十一列  运费模板，取自数据库
                    row.createCell(31).setCellValue(goodsOnSale.getAuto_warehouse_time());   //  第三十二列  定时下架
                    row.createCell(32).setCellValue(goodsOnSale.getStatus());   //  第三十三列  状态，上架售卖、上架隐藏、定时上架、放置仓库
                    row.createCell(33).setCellValue(goodsOnSale.getIs_buy_num_limit());   //  第三十四列  开启限购，是或否
                    row.createCell(34).setCellValue(goodsOnSale.getMin_buy());   //  第三十五列  起购数量
                    row.createCell(35).setCellValue(goodsOnSale.getMax_buy_total());   //  第三十六列  每人限购数量
                    row.createCell(36).setCellValue(goodsOnSale.getBrowse_authority());   //  第三十七列  浏览权限
                    row.createCell(37).setCellValue(goodsOnSale.getBuy_authority());   //  第三十八列  购买权限
                    row.createCell(38).setCellValue(goodsOnSale.getJoin_member_discount());   //  第三十九列  参与会员权益，会员卡、会员价、会员等级折扣
                    row.createCell(39).setCellValue(goodsOnSale.getPromotion_diagram_name());   //  第四十列  推广图文件名
                    row.createCell(40).setCellValue(goodsOnSale.getPromotion_diagram_link());   //  第四十一列  推广图链接
                    row.createCell(41).setCellValue(goodsOnSale.getPromotion_diagram_degree());   //  第四十二列  推广图会员等级是否展示
                    row.createCell(42).setCellValue(goodsOnSale.getDetailed_diagram_num());   //  第四十三列  商品详情图张数
                    row.createCell(43).setCellValue(goodsOnSale.getAuthorize_diagram_name());   //  第四十四列  授权图文件名
                    row.createCell(44).setCellValue(goodsOnSale.getCommon_diagram_name());   //  第四十五列  公用图文件名
                    row.createCell(45).setCellValue(goodsOnSale.getActivity_name());   //  第四十六列  活动名称
                    row.createCell(46).setCellValue(goodsOnSale.getActivity_start_time());   //  第四十七列  活动开始时间
                    row.createCell(47).setCellValue(goodsOnSale.getActivity_end_time());   //  第四十八列  活动结束时间
                    row.createCell(48).setCellValue(goodsOnSale.getActivity_channel());   //  第四十九列  活动渠道
                    row.createCell(49).setCellValue(goodsOnSale.getActivity_object());   //  第五十列  规则1活动对象，全部会员、会员等级、会员标签
                    row.createCell(50).setCellValue(goodsOnSale.getMember_degree());   //  第五十一列  规则1会员等级
                    row.createCell(51).setCellValue(goodsOnSale.getCredit());   //  第五十二列  规则1最大积分抵扣
                    row.createCell(52).setCellValue(goodsOnSale.getAllow_accumulate());   //  第五十三列  规则1允许多件累计抵扣

                    // 设置目标文件地址
                    File file = new File("");
                    String filePath = null;
                    try {
                        filePath = file.getCanonicalPath();            //  当前项目下路径
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //    在结果目标中设置文件位置的路径。必须在目标路径中设置，要是在源码中设置，就会提示有代码访问该文件，也是因为访问时访问的是目标路径中的资源
                    String relativepath = ClassUtils.getDefaultClassLoader().getResource("file").getPath() ;
                    System.out.println("relativepath 是  "+relativepath);
                    String desExcel = relativepath + "/storage-rack-goods-on-shelve.xlsx";  // 最终文件绝对路径

                    FileOutputStream fout = new FileOutputStream(desExcel);
                    wb.write(fout);
                    fout.close();
                    System.out.println("写入Excel成功");
                } catch(Exception e){
                    e.printStackTrace();
                }
            } else{
                System.out.println("文件不存在!");
                return "Error";
            }
            return "OK";
    }

    //  将cell对象中的值转换成string类型
    public  String getCellValue(Cell cell) {
        String strCell = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case STRING:     // 字符串类型
                    strCell = cell.getStringCellValue();
                    break;
                case BOOLEAN:    // boolean类型
                    strCell = String.valueOf(cell.getBooleanCellValue());
                    break;
                case BLANK:      // 空白类型
                    strCell = "";
                    break;
                case ERROR:      // 错误类型
                    strCell = "error value!";
                    break;
                case NUMERIC:  //数字类型
                    strCell = String.valueOf(cell.getNumericCellValue());
                    break;
                case FORMULA:
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式
                        SimpleDateFormat sdf = null;
                        //  short dataFormat = cell.getCellStyle().getDataFormat();
                        sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        Date date = cell.getDateCellValue();
                        strCell = sdf.format(date);
                    }
                    break;
                default:
                    strCell = "";
                    break;
            }
        }
        if (strCell.equals("") || strCell == null) {
            strCell = "";
        }
        return strCell.trim();
    }





}
