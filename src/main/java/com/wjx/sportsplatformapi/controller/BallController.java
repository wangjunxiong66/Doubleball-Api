package com.wjx.sportsplatformapi.controller;


import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.wjx.sportsplatformapi.dao.BallDao;
import com.wjx.sportsplatformapi.entity.*;
import com.wjx.sportsplatformapi.service.DoubleBallService;
import com.wjx.sportsplatformapi.util.CheckTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class BallController {

    @Autowired
    BallDao ballDao;

    @Autowired
    DoubleBallService doubleBallService ;

    //  查询所有双色球信息
    @RequestMapping("/allball")
    public String getBallList(QueryInfo queryInfo){
        System.out.println("进入allball方法，查询的双色球信息是: "+queryInfo);
        //  获取双色球数量
        int numbers = ballDao.getBallCounts("%"+queryInfo.getQuery()+"%") ;
        //  获取当前页记录的起始序号
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        //  获取当前页用户记录的所有信息
        List<Ball> balls = ballDao.getAllBall("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize()) ;
        HashMap<String,Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",balls);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }

    //  增加双色球记录
    @PostMapping("/addball")
    public String addBall(@RequestBody Ball ball){
        System.out.println("插入的 user 内容是:  "+ball);
        int issue = ball.getIssue();
        String drawprizedate = ball.getDraw_prize_date();
        int querybuyissuecount = ballDao.queryBallByIssue(issue);
        int querybuydatacount = ballDao.queryBallByDrawPrizeDate(drawprizedate);
        int temp = querybuydatacount + querybuyissuecount ;
        HashMap<String,Object> res = new HashMap<>();
        if (temp>0){
            res.put("code",0);
            res.put("data","已有相同期号或者开奖日期的双色球纪录，请确定数据是否正确！");
            String res_str = JSON.toJSONString(res) ;
            System.out.println("返回值是： "+res_str);
            return res_str ;
        }
        int i = ballDao.addBall(ball);
        if (i>0){
            res.put("code",1);
            res.put("data","新增双色球纪录成功！");
        } else {
            res.put("code",2);
            res.put("data","新增双色球纪录异常！");
        }
        String res_string = JSON.toJSONString(res) ;
        System.out.println("返回值是： "+res_string);
        return res_string ;
    }

    //  查询要修改的双色球记录
    @RequestMapping("/getupdateball")
    public String getUpdateBall(int id){
        System.out.println("进入getUpdateBall方法，传入参数 id 值为 ："+id);
        Ball ball = ballDao.getupdateball(id);
        HashMap<String,Object> res = new HashMap<>();
        if ( CheckTools.isNotEmpty(ball)){
            System.out.println("查询出来的双色球记录是："+ball);
            res.put("code",1);
            res.put("data",ball);
        } else {
            res.put("code",0);
            res.put("data",null);
        }
        String res_string = JSON.toJSONString(res) ;
        System.out.println("返回值是： "+res_string);
        return res_string ;
    }

    //  修改双色球记录
    @RequestMapping("/editball")
    public String editBall(@RequestBody Ball ball){
        System.out.println("进入editBall方法，修改的双色球记录最终是："+ball);
        int i = ballDao.editBall(ball);
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

    //  通过期号查询双色球记录
    public int queryBallByIssue(int issue){
        System.out.println("进入queryBallByIssue方法，传入参数 issue 值为 ："+issue);
        int i = ballDao.queryBallByIssue(issue);
        return i;
    }

    //  通过开奖日期查询双色球记录
    public int queryBallByDrawPrizeDate(String drawprizedate){
        System.out.println("进入queryBallByDrawPrizeDate方法，传入参数 drawprizedate 值为 ："+drawprizedate);
        int i = ballDao.queryBallByDrawPrizeDate(drawprizedate);
        return i;
    }

    //  通过双色球记录的id删除双色球记录
    @RequestMapping("/deleteball")
    public String deleteBall(int id){
        System.out.println("进入deleteBall方法，传入参数 id 值为 ："+id);
        int i = ballDao.deleteBall(id);
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

    //  预测下一期双色球记录
    @RequestMapping("/getrandomball")
    public String getrandomball(){
        System.out.println("进入getrandomball方法");
        int blueball;
        Random ranblue = new Random() ;
        blueball=ranblue.nextInt(16)+1;

        int[] redball=new int[6];
        Random ranred = new Random() ;
        Set<Integer> ran=new TreeSet<Integer>() ;
        int i=0;
        while (ran.size()<6){
            ran.add(ranred.nextInt(33)+1);
        }
        Iterator<Integer> integerIterator = ran.iterator();
        while(integerIterator.hasNext()){
            redball[i]=integerIterator.next();
            i++;
        }
        System.out.println("红球是："+redball[0]+" "+redball[1]+" "+redball[2]+" "+redball[3]+" "+redball[4]+" "+redball[5]+"    蓝球是："+blueball);

        Ball ball = new Ball();
        ball.setBlue(blueball);
        ball.setRed_one(redball[0]);
        ball.setRed_two(redball[1]);
        ball.setRed_three(redball[2]);
        ball.setRed_four(redball[3]);
        ball.setRed_five(redball[4]);
        ball.setRed_six(redball[5]);

        HashMap<String,Object> res = new HashMap<>();
        if ( CheckTools.isNotEmpty(ball)){
            res.put("code",1);
            res.put("data",ball);
        } else {
            res.put("code",0);
            res.put("data",ball);
        }
        String res_string = JSON.toJSONString(res) ;
        System.out.println("返回值是： "+res_string);
        return res_string ;
    }

    //  查询每个球出现的次数的统计数据，并分为红球统计数据和蓝球统计数据（从"计算双色球统计信息结果表doubleballcalculate"）
    @RequestMapping("/calculateBall")
    public String calculateBall(){
        System.out.println("进入calculateBall方法");

        //  统计记录最后一条计算的时间和当前时间作比较，是否当天已经计算过
        BallStatistics ballStatistics =new BallStatistics() ;
        ballStatistics=ballDao.findLastBallCalculate();

        HashMap<String,Object> res = new HashMap<>();

        if (CheckTools.isEmpty(ballStatistics)){
            System.out.println("双色球数据还未统计过，需要进行统计");
            BallStatistics ballStatistics1 = doubleBallService.calculateBall();
            int i = doubleBallService.insertCalculateData(ballStatistics1);
            if (i>0){
                System.out.println("插入双色球统计数据成功！");
                res.put("code",1);
                res.put("data","插入双色球统计数据成功！");
            } else {
                System.out.println("插入双色球统计数据出现异常！");
                res.put("code",2);
                res.put("data","插入双色球统计数据出现异常！");
            }
        } else {

            //  比较上一条记录和当前时间
            String Calculate_date_record = ballStatistics.getCalculate_date();

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String calculate_date_now = simpleDateFormat.format(new Date());

            DateTime date_record = DateUtil.parse(Calculate_date_record) ;
            DateTime date_now = DateUtil.parse(calculate_date_now) ;

            System.out.println("统计记录最后一条计算的时间为："+date_record);
            System.out.println("当前时间为："+date_now);

            boolean issame = DateUtil.isSameDay(date_record,date_now);

            if (issame){
                res.put("code",0);
                res.put("data","今日双色球数据已经统计过了！");
            } else {
                BallStatistics ballStatistics1 = doubleBallService.calculateBall();
                int i = doubleBallService.insertCalculateData(ballStatistics1);
                if (i>0){
                    System.out.println("插入双色球统计数据成功！");
                    res.put("code",1);
                    res.put("data","插入双色球统计数据成功！");
                } else {
                    System.out.println("插入双色球统计数据出现异常！");
                    res.put("code",2);
                    res.put("data","插入双色球统计数据出现异常！");
                }
            }

        }

        String res_string = JSON.toJSONString(res) ;
        System.out.println("返回值是： "+res_string);
        return res_string ;
    }

    //  查询每个球出现的次数的统计数据，并分为红球统计数据和蓝球统计数据（从"计算双色球统计信息结果表doubleballcalculate"）
    @GetMapping("/getstatisticsdivide")
    public String getStatisticsDivide() {
        System.out.println("进入getStatisticsDivide方法");
        //  统计记录最后一条计算的时间和当前时间作比较，是否当天已经计算过
        BallStatistics ballStatistics =new BallStatistics() ;
        ballStatistics=ballDao.findLastBallCalculate();
        HashMap<String,Object> res = new HashMap<>();

        if (CheckTools.isEmpty(ballStatistics)){
            System.out.println("双色球数据还未统计过，需要进行统计");
            BallStatistics ballStatistics1 = doubleBallService.calculateBall();
            int i = doubleBallService.insertCalculateData(ballStatistics1);
            if (i>0){
                System.out.println("插入双色球统计数据成功！");
                BallStatisticsDivide ballStatisticsDivide = doubleBallService.getstatisticsdivide(ballStatistics1);
                res.put("code",1);
                res.put("data",ballStatisticsDivide);
            } else {
                System.out.println("插入双色球统计数据出现异常！");
                res.put("code",2);
                res.put("data","插入双色球统计数据出现异常！");
            }
        } else {
            System.out.println("双色球数据统计过，需要进行拆分");
            System.out.println("ballStatistics 是  "+ballStatistics.toString());

            BallStatisticsDivide ballStatisticsDivide = doubleBallService.getstatisticsdivide(ballStatistics);
            res.put("code",1);
            res.put("data",ballStatisticsDivide);
            System.out.println("ballStatisticsDivide 是  "+ballStatisticsDivide.toString());
        }
        String res_string = JSON.toJSONString(res) ;
        System.out.println("返回值是： "+res_string);
        return res_string ;

    }




}
