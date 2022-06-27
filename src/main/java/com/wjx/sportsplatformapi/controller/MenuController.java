package com.wjx.sportsplatformapi.controller;

import com.alibaba.fastjson.JSON;
import com.wjx.sportsplatformapi.dao.MenuDao;
import com.wjx.sportsplatformapi.entity.MainMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.HashMap;
import java.util.List;

/**
 * @author wjx
 * @version 1.0
 * @date 2020/10/28 上午11:12
 */
@RestController
public class MenuController {

    public static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    MenuDao menuDao;

    @RequestMapping("/menus")
    public String getAllMenus(){
        log.info("访问home成功，查询菜单栏");
        HashMap<String,Object> data = new HashMap<>();
        List<MainMenu> menus = menuDao.getMenus();
        if (menus!=null){
            data.put("menus",menus);
            data.put("flag",200);
        }else{
            data.put("flag",404);
        }
        String s= JSON.toJSONString(data);
//        log.info("查询菜单栏结果为："+s);
        log.info("查询菜单栏结果为 {} .",s);

        return s;
    }

}
