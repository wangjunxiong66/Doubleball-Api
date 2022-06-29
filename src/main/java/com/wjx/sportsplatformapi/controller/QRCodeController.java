package com.wjx.sportsplatformapi.controller;

import com.google.zxing.WriterException;
import com.wjx.sportsplatformapi.service.QRCodeGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

/**
 *  此功能是为了访问生成的二维码
 */

@RestController
public class QRCodeController {

    public static final Logger log = LoggerFactory.getLogger(QRCodeController.class);

    @Autowired
    QRCodeGenerator qrCodeGenerator;

    @RequestMapping("/generateqrcode")
    public String QRCodeGeneratorMethod(@RequestParam("url") String url){
        log.info("请求参数是：  {}",url);
        //    在结果目标中设置图片的位置的路径。必须在目标路径中设置，要是在源码中设置，在访问的时候就会访问不到，因为访问时访问的是目标路径中的资源
        String relativepath = ClassUtils.getDefaultClassLoader().getResource("static/images").getPath() ;
        log.info("relativepath 是:  {}",relativepath);
        //  源码中设置图片的位置的路径
//            String path = System.getProperty("user.dir");
//            System.out.println("path 是  "+path);
        try {
//            qrCodeGenerator.generateQRCodeImage(url, 350, 350, path+"/src/main/resources/static/images/QRCode.png");
            qrCodeGenerator.generateQRCodeImage(url, 350, 350, relativepath+"/QRCode.png");
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  需要后缀一个随机字符串，不然会产生图片缓存
        String imgurl = "http://localhost:9000/images/QRCode.png" ;
        log.info("二维码地址：  {}",imgurl);
        String temp = imgurl+"?v="+ Math.random() ;
        log.info("返回字符串是：  "+temp);
        return temp  ;
    }


}
