package com.wjx.sportsplatformapi.controller;

import com.alibaba.fastjson.JSON;
import com.wjx.sportsplatformapi.dao.UserDao;
import com.wjx.sportsplatformapi.entity.QueryInfo;
import com.wjx.sportsplatformapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/alluser")
    public String getUserList(QueryInfo queryInfo){
        System.out.println("queryInfo: "+queryInfo);
        //  获取用户数量
        int numbers = userDao.getUserCounts("%"+queryInfo.getQuery()+"%") ;
        //  获取当前页用户记录的起始序号
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        //  获取当前页用户记录的所有信息
        List<User> users = userDao.getAllUser("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize()) ;
        System.out.println("users: "+users);
        HashMap<String,Object>  res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",users);
        String res_string = JSON.toJSONString(res);
        return res_string;

    }

    @RequestMapping("/updateuserstate")
    public String updateUserState(@RequestParam("id") Integer id,@RequestParam("state") Boolean state){
        int i = userDao.updateState(id,state) ;
        return i > 0 ? "success":"error";
    }

    @RequestMapping("/adduser")
    public String addUser(@RequestBody User user){
        user.setRole("普通用户");
        user.setState(false);
        System.out.println("插入的 user 内容是:  "+user);
        int i = userDao.addUser(user);
        return i > 0 ? "success":"error";
    }

    @RequestMapping("/deleteuser")
    public String deleteUser(int id){
        int i = userDao.deleteUser(id);
        return i > 0 ? "success":"error";
    }

    @RequestMapping("/getupdateuser")
    public String getUpdateUser(int id){
        User user = userDao.getupdateuser(id);
        String string = JSON.toJSONString(user) ;
        return string ;
    }

    @RequestMapping("/edituser")
    public String editUser(@RequestBody User user){
        int i = userDao.editUser(user);
        return i > 0 ? "success":"error";
    }

}
