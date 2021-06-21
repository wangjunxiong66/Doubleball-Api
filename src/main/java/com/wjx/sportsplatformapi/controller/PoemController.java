package com.wjx.sportsplatformapi.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.wjx.sportsplatformapi.dao.PoemDao;
import com.wjx.sportsplatformapi.entity.Poem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * @author wjx
 * @version 1.0
 * @date 2021/6/21 下午2:42
 */
@RestController
public class PoemController {

    @Autowired
    PoemDao poemDao;

    @RequestMapping("/addpoem")
    public String addPoem(@RequestBody Poem poem){
        System.out.println("进入addPoem方法，要插入的诗歌信息是: "+poem);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String create_time = simpleDateFormat.format(new Date());
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
