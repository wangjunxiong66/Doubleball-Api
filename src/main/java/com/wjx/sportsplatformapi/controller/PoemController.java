package com.wjx.sportsplatformapi.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.wjx.sportsplatformapi.dao.PoemDao;
import com.wjx.sportsplatformapi.entity.Poem;
import com.wjx.sportsplatformapi.entity.QueryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author wjx
 * @version 1.0
 * @date 2021/6/21 下午2:42
 */
@RestController
public class PoemController {

    @Autowired
    PoemDao poemDao;

    //  查询所有双色球信息
    @RequestMapping("/allpoem")
    public String getPoemList(QueryInfo queryInfo){
        System.out.println("进入allpoem方法，查询的诗歌信息是: "+queryInfo);
        //  获取双色球数量
        int numbers = poemDao.getPoemCounts("%"+queryInfo.getQuery()+"%") ;
        //  获取当前页记录的起始序号
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        //  获取当前页用户记录的所有信息
        List<Poem> poems = poemDao.getAllPoem("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize()) ;
        HashMap<String,Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",poems);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }

    @RequestMapping("/addpoem")
    public String addPoem(@RequestBody Poem poem){
        System.out.println("进入addPoem方法，要插入的诗歌信息是: "+poem);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();
        String create_time=dateTimeFormatter.format(date);
        String update_time = create_time;
        poem.setCreate_time(create_time);
        poem.setUpdate_time(update_time);
        int temp = poemDao.addPoem(poem) ;
        HashMap<String,Object> res = new HashMap<>();
        if (temp>0){
            System.out.println("插入诗歌成功！");
            res.put("code",1);
            res.put("data","插入诗歌成功！");
        } else {
            System.out.println("插入诗歌出现异常！");
            res.put("code",2);
            res.put("data","插入诗歌出现异常！");
        }
        String res_string = JSON.toJSONString(res) ;
        System.out.println("返回值是： "+res_string);
        return res_string ;
    }


}
