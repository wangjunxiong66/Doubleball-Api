package com.wjx.sportsplatformapi.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.wjx.sportsplatformapi.dao.PoemDao;
import com.wjx.sportsplatformapi.entity.Poem;
import com.wjx.sportsplatformapi.entity.PoemQueryInfo;
import com.wjx.sportsplatformapi.entity.QueryInfo;
import com.wjx.sportsplatformapi.util.CheckTools;
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
@RequestMapping("/poemapi")
public class PoemController {

    @Autowired
    PoemDao poemDao;

    //  查询所有诗歌信息
//    @RequestMapping("/allpoem")
//    public String getPoemList(PoemQueryInfo poemQueryInfo){
//        System.out.println("进入allpoem方法，查询的诗歌内容是: "+poemQueryInfo);
//        //  获取诗歌数量
//        int numbers = poemDao.getPoemCounts("%"+poemQueryInfo.getContent()+"%") ;
//        //  获取当前页记录的起始序号
//        int pageStart = (poemQueryInfo.getPageNum()-1)*poemQueryInfo.getPageSize();
//        //  获取当前页诗歌的所有信息
//        List<Poem> poems = poemDao.getAllPoem("%"+poemQueryInfo.getContent()+"%",pageStart,poemQueryInfo.getPageSize()) ;
//        HashMap<String,Object> res = new HashMap<>();
//        res.put("numbers",numbers);
//        res.put("data",poems);
//        String res_string = JSON.toJSONString(res);
//        System.out.println("获取的结果是: "+res_string);
//        return res_string;
//    }
    @RequestMapping("/allpoem")
    public String getPoemList(PoemQueryInfo poemQueryInfo){
        System.out.println("进入allpoem方法，查询的诗歌内容是: "+poemQueryInfo);
        //  获取诗歌数量
//        int numbers = poemDao.getPoemCounts("%"+poemQueryInfo.getContent()+"%") ;
        int numbers = poemDao.getPoemCounts(poemQueryInfo) ;
        //  获取当前页记录的起始序号
        int pageStart = (poemQueryInfo.getPageNum()-1)*poemQueryInfo.getPageSize();
        //  获取当前页诗歌的所有信息
        poemQueryInfo.setPageIndex(pageStart);
//        List<Poem> poems = poemDao.getAllPoem("%"+poemQueryInfo.getContent()+"%",pageStart,poemQueryInfo.getPageSize()) ;
        List<Poem> poems = poemDao.getAllPoem(poemQueryInfo) ;
        HashMap<String,Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",poems);
        String res_string = JSON.toJSONString(res);
        System.out.println("获取的结果是: "+res_string);
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

    //  查询要修改的诗歌
    @RequestMapping("/getupdatepoem")
    public String getUpdatePoem(int id){
        System.out.println("进入getUpdatePoem方法，传入参数 id 值为 ："+id);
        Poem poem = poemDao.getupdatepoem(id);
        HashMap<String,Object> res = new HashMap<>();
        if ( CheckTools.isNotEmpty(poem)){
            System.out.println("查询出来的诗歌内容是："+poem);
            res.put("code",1);
            res.put("data",poem);
        } else {
            res.put("code",0);
            res.put("data",null);
        }
        String res_string = JSON.toJSONString(res) ;
        System.out.println("返回值是： "+res_string);
        return res_string ;
    }

    //  修改诗歌
    @RequestMapping("/editpoem")
    public String editPoem(@RequestBody Poem poem){
        System.out.println("进入editPoem方法，修改的双色球记录最终是："+poem);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();
        String update_time=dateTimeFormatter.format(date);
        System.out.println("系统当前时间      ："+update_time);
        poem.setUpdate_time(update_time);
        int i = poemDao.editPoem(poem);
        HashMap<String,Object> res = new HashMap<>();
        if ( i > 0){
            res.put("code",1);
            res.put("data",null);
        } else {
            res.put("code",0);
            res.put("data",null);
        }
        String res_string = JSON.toJSONString(res) ;
        System.out.println("返回值是： "+res_string);
        return res_string ;
    }

    //  通过诗歌的id删除诗歌
    @RequestMapping("/deletepoem")
    public String deletePoem(int id){
        System.out.println("进入deletePoem方法，传入参数 id 值为 ："+id);
        int i = poemDao.deletePoem(id);
        HashMap<String,Object> res = new HashMap<>();
        if ( i > 0){
            res.put("code",1);
            res.put("data",null);
        } else {
            res.put("code",0);
            res.put("data",null);
        }
        String res_string = JSON.toJSONString(res) ;
        System.out.println("返回值是： "+res_string);
        return res_string ;
    }

}
