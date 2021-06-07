package com.wjx.sportsplatformapi.controller;

import com.alibaba.fastjson.JSON;
import com.wjx.sportsplatformapi.dao.UserDao;
import com.wjx.sportsplatformapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author wjx
 * @version 1.0
 * @date 2020/10/10 下午3:50
 */
@RestController
public class LoginController {

    @Autowired
    UserDao userDao;

    @PostMapping("/login")
    public String login(@RequestBody User user){
        System.out.println("进入login方法，传入的参数为："+user);
        String flag = "error";
        System.out.println("查询的参数为："+user.getUsername()+"  "+user.getPassword());
        User us = userDao.getUserByMessage(user.getUsername(),user.getPassword()) ;
        HashMap<String,Object> res = new HashMap<>();
        if (us!=null){
            flag = "ok";
        }
        res.put("flag",flag);
        res.put("user",user);
        System.out.println("请求的用户信息: "+user);
        System.out.println("查询出来的用户信息: "+us);
        String res_json = JSON.toJSONString(res);
        return res_json;
    }

    @RequestMapping("/test")
    public String test(){
        return "OK";
    }

}
