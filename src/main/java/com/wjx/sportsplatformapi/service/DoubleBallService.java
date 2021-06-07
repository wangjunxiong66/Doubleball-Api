package com.wjx.sportsplatformapi.service;

import com.wjx.sportsplatformapi.dao.BallDao;
import com.wjx.sportsplatformapi.entity.Ball;
import com.wjx.sportsplatformapi.entity.BallNameValue;
import com.wjx.sportsplatformapi.entity.BallStatistics;
import com.wjx.sportsplatformapi.entity.BallStatisticsDivide;
import com.wjx.sportsplatformapi.util.CheckTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wjx
 * @version 1.0
 * @date 2021/5/31 下午6:12
 */
@Service
public class DoubleBallService {

    @Autowired
    BallDao ballDao;

    //  对各种球类出现次数的统计（到"计算双色球统计信息结果表doubleballcalculate"）
    public BallStatistics calculateBall(){
        List<Ball> ballList = ballDao.getAllBalls();

        int[] red=new int[33] ;
        int[] blue=new int[16] ;
        int[] temp=new int[7];

        for(Ball ball:ballList){
            //  将记录中的红球和蓝球数据进行抓取
            temp[0]=ball.getRed_one();
            temp[1]=ball.getRed_two();
            temp[2]=ball.getRed_three();
            temp[3]=ball.getRed_four();
            temp[4]=ball.getRed_five();
            temp[5]=ball.getRed_six();
            temp[6]=ball.getBlue();
            //   统计红球出现的次数
            for (int i=0;i<6;i++){
                for (int j=1;j<=33;j++){
                    if (temp[i]==j)
                        red[j-1]=red[j-1]+1;
                }
            }
            //   统计蓝球出现的次数
            for (int i=1;i<=16;i++){
                if (temp[6]==i)
                    blue[i-1]=blue[i-1]+1;
            }
        }
        System.out.println("统计出来红球数据为：");
        for (int i=1;i<34;i++){
            System.out.print("红球"+i+"为："+red[i-1]+"   ");

        }
        //  抵消上面的输出
        System.out.println();

        System.out.println("统计出来蓝球数据为：");
        for (int i=1;i<17;i++){
            System.out.print("蓝球"+i+"为："+blue[i-1]+"   ");

        }

        //  抵消上面的输出
        System.out.println();

        BallStatistics ballStatistics = new BallStatistics();
        ballStatistics.setRed_one(red[0]);
        ballStatistics.setRed_two(red[1]);
        ballStatistics.setRed_three(red[2]);
        ballStatistics.setRed_four(red[3]);
        ballStatistics.setRed_five(red[4]);
        ballStatistics.setRed_six(red[5]);
        ballStatistics.setRed_seven(red[6]);
        ballStatistics.setRed_eight(red[7]);
        ballStatistics.setRed_nine(red[8]);
        ballStatistics.setRed_ten(red[9]);
        ballStatistics.setRed_eleven(red[10]);
        ballStatistics.setRed_twelve(red[11]);
        ballStatistics.setRed_thirteen(red[12]);
        ballStatistics.setRed_fourteen(red[13]);
        ballStatistics.setRed_fifteen(red[14]);
        ballStatistics.setRed_sixteen(red[15]);
        ballStatistics.setRed_seventeen(red[16]);
        ballStatistics.setRed_eighteen(red[17]);
        ballStatistics.setRed_nineteen(red[18]);
        ballStatistics.setRed_twenty(red[19]);
        ballStatistics.setRed_twenty_one(red[20]);
        ballStatistics.setRed_twenty_two(red[21]);
        ballStatistics.setRed_twenty_three(red[22]);
        ballStatistics.setRed_twenty_four(red[23]);
        ballStatistics.setRed_twenty_five(red[24]);
        ballStatistics.setRed_twenty_six(red[25]);
        ballStatistics.setRed_twenty_seven(red[26]);
        ballStatistics.setRed_twenty_eight(red[27]);
        ballStatistics.setRed_twenty_nine(red[28]);
        ballStatistics.setRed_thirty(red[29]);
        ballStatistics.setRed_thirty_one(red[30]);
        ballStatistics.setRed_thirty_two(red[31]);
        ballStatistics.setRed_thirty_three(red[32]);
        ballStatistics.setBlue_one(blue[0]);
        ballStatistics.setBlue_two(blue[1]);
        ballStatistics.setBlue_three(blue[2]);
        ballStatistics.setBlue_four(blue[3]);
        ballStatistics.setBlue_five(blue[4]);
        ballStatistics.setBlue_six(blue[5]);
        ballStatistics.setBlue_seven(blue[6]);
        ballStatistics.setBlue_eight(blue[7]);
        ballStatistics.setBlue_nine(blue[8]);
        ballStatistics.setBlue_ten(blue[9]);
        ballStatistics.setBlue_eleven(blue[10]);
        ballStatistics.setBlue_twelve(blue[11]);
        ballStatistics.setBlue_thirteen(blue[12]);
        ballStatistics.setBlue_fourteen(blue[13]);
        ballStatistics.setBlue_fifteen(blue[14]);
        ballStatistics.setBlue_sixteen(blue[15]);
        return ballStatistics;
    }

    //   将统计出的数据插入到"计算双色球统计信息结果表doubleballcalculate"
    public int insertCalculateData(BallStatistics ballStatistics ){
        int red_one,red_two,red_three,red_four,red_five,red_six,red_seven,red_eight,red_nine,red_ten,red_eleven,red_twelve,red_thirteen,red_fourteen,red_fifteen,red_sixteen,red_seventeen,red_eighteen,red_nineteen,red_twenty,red_twenty_one,red_twenty_two,red_twenty_three,red_twenty_four,red_twenty_five,red_twenty_six,red_twenty_seven,red_twenty_eight,red_twenty_nine,red_thirty,red_thirty_one, red_thirty_two,red_thirty_three,blue_one,blue_two,blue_three,blue_four,blue_five,blue_six,blue_seven,blue_eight,blue_nine,blue_ten,blue_eleven,blue_twelve,blue_thirteen,blue_fourteen,blue_fifteen,blue_sixteen;
        red_one=ballStatistics.getRed_one();
        red_two=ballStatistics.getRed_two();
        red_three=ballStatistics.getRed_three();
        red_four=ballStatistics.getRed_four();
        red_five=ballStatistics.getRed_five();
        red_six=ballStatistics.getRed_six();
        red_seven=ballStatistics.getRed_seven();
        red_eight=ballStatistics.getRed_eight();
        red_nine=ballStatistics.getRed_nine();
        red_ten=ballStatistics.getRed_ten();
        red_eleven=ballStatistics.getRed_eleven();
        red_twelve=ballStatistics.getRed_twelve();
        red_thirteen=ballStatistics.getRed_thirteen();
        red_fourteen=ballStatistics.getRed_fourteen();
        red_fifteen=ballStatistics.getRed_fifteen();
        red_sixteen=ballStatistics.getRed_sixteen();
        red_seventeen=ballStatistics.getRed_seventeen();
        red_eighteen=ballStatistics.getRed_eighteen();
        red_nineteen=ballStatistics.getRed_nineteen();
        red_twenty=ballStatistics.getRed_twenty();
        red_twenty_one=ballStatistics.getRed_twenty_one();
        red_twenty_two=ballStatistics.getRed_twenty_two();
        red_twenty_three=ballStatistics.getRed_twenty_three();
        red_twenty_four=ballStatistics.getRed_twenty_four();
        red_twenty_five=ballStatistics.getRed_twenty_five();
        red_twenty_six=ballStatistics.getRed_twenty_six();
        red_twenty_seven=ballStatistics.getRed_twenty_seven();
        red_twenty_eight=ballStatistics.getRed_twenty_eight();
        red_twenty_nine=ballStatistics.getRed_twenty_nine();
        red_thirty=ballStatistics.getRed_thirty();
        red_thirty_one=ballStatistics.getRed_thirty_one();
        red_thirty_two=ballStatistics.getRed_thirty_two();
        red_thirty_three=ballStatistics.getRed_thirty_three();
        blue_one=ballStatistics.getBlue_one();
        blue_two=ballStatistics.getBlue_two();
        blue_three=ballStatistics.getBlue_three();
        blue_four=ballStatistics.getBlue_four();
        blue_five=ballStatistics.getBlue_five();
        blue_six=ballStatistics.getBlue_six();
        blue_seven=ballStatistics.getBlue_seven();
        blue_eight=ballStatistics.getBlue_eight();
        blue_nine=ballStatistics.getBlue_nine();
        blue_ten=ballStatistics.getBlue_ten();
        blue_eleven=ballStatistics.getBlue_eleven();
        blue_twelve=ballStatistics.getBlue_twelve();
        blue_thirteen=ballStatistics.getBlue_thirteen();
        blue_fourteen=ballStatistics.getBlue_fourteen();
        blue_fifteen=ballStatistics.getBlue_fifteen();
        blue_sixteen=ballStatistics.getBlue_sixteen();

        //  这种获得时间的方式只能是12小时制的
//        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        String calculate_date = simpleDateFormat.format(new Date());
//        System.out.println("calculate_date  是    "+calculate_date);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();
        String calculate_date=dateTimeFormatter.format(date);
        System.out.println("系统当前时间      ："+calculate_date);

        int i = ballDao.insertBallCalculate(red_one,red_two,red_three,red_four,red_five,red_six,red_seven,red_eight,red_nine,red_ten,red_eleven,red_twelve,red_thirteen,red_fourteen,red_fifteen,red_sixteen,red_seventeen,red_eighteen,red_nineteen,red_twenty,red_twenty_one,red_twenty_two,red_twenty_three,red_twenty_four,red_twenty_five,red_twenty_six,red_twenty_seven,red_twenty_eight,red_twenty_nine,red_thirty,red_thirty_one, red_thirty_two,red_thirty_three,blue_one,blue_two,blue_three,blue_four,blue_five,blue_six,blue_seven,blue_eight,blue_nine,blue_ten,blue_eleven,blue_twelve,blue_thirteen,blue_fourteen,blue_fifteen,blue_sixteen, calculate_date);
        return i;
    }

    //  查询每个球出现的次数的统计数据，并分为红球统计数据和蓝球统计数据（从"计算双色球统计信息结果表doubleballcalculate"）
    public BallStatisticsDivide getstatisticsdivide(BallStatistics ballStatistics){
        System.out.println("进入getstatisticsdivide方法");

        BallStatisticsDivide ballStatisticsDivide = new BallStatisticsDivide();
        int[] redball = new int[33] ;
        int[] blueball = new int[16] ;
        List<BallNameValue> redballs = new ArrayList<>();
        List<BallNameValue> blueballs = new ArrayList<>();

        if (CheckTools.isNotEmpty(ballStatistics)){
            System.out.println("对记录进行拆分");
            redball[0] = ballStatistics.getRed_one();
            redballs.add(new BallNameValue(ballStatistics.getRed_one(),"红球1"));
            redball[1] = ballStatistics.getRed_two();
            redballs.add(new BallNameValue(ballStatistics.getRed_two(),"红球2"));
            redball[2] = ballStatistics.getRed_three();
            redballs.add(new BallNameValue(ballStatistics.getRed_three(),"红球3"));
            redball[3] = ballStatistics.getRed_four();
            redballs.add(new BallNameValue(ballStatistics.getRed_four(),"红球4"));
            redball[4] = ballStatistics.getRed_five();
            redballs.add(new BallNameValue(ballStatistics.getRed_five(),"红球5"));
            redball[5] = ballStatistics.getRed_six();
            redballs.add(new BallNameValue(ballStatistics.getRed_six(),"红球6"));
            redball[6] = ballStatistics.getRed_seven();
            redballs.add(new BallNameValue(ballStatistics.getRed_seven(),"红球7"));
            redball[7] = ballStatistics.getRed_eight();
            redballs.add(new BallNameValue(ballStatistics.getRed_eight(),"红球8"));
            redball[8] = ballStatistics.getRed_nine();
            redballs.add(new BallNameValue(ballStatistics.getRed_nine(),"红球9"));
            redball[9] = ballStatistics.getRed_ten();
            redballs.add(new BallNameValue(ballStatistics.getRed_ten(),"红球10"));
            redball[10] = ballStatistics.getRed_eleven();
            redballs.add(new BallNameValue(ballStatistics.getRed_eleven(),"红球11"));
            redball[11] = ballStatistics.getRed_twelve();
            redballs.add(new BallNameValue(ballStatistics.getRed_twelve(),"红球12"));
            redball[12] = ballStatistics.getRed_thirteen();
            redballs.add(new BallNameValue(ballStatistics.getRed_thirteen(),"红球13"));
            redball[13] = ballStatistics.getRed_fourteen();
            redballs.add(new BallNameValue(ballStatistics.getRed_fourteen(),"红球14"));
            redball[14] = ballStatistics.getRed_fifteen();
            redballs.add(new BallNameValue(ballStatistics.getRed_fifteen(),"红球15"));
            redball[15] = ballStatistics.getRed_sixteen();
            redballs.add(new BallNameValue(ballStatistics.getRed_sixteen(),"红球16"));
            redball[16] = ballStatistics.getRed_seventeen();
            redballs.add(new BallNameValue(ballStatistics.getRed_seventeen(),"红球17"));
            redball[17] = ballStatistics.getRed_eighteen();
            redballs.add(new BallNameValue(ballStatistics.getRed_eighteen(),"红球18"));
            redball[18] = ballStatistics.getRed_nineteen();
            redballs.add(new BallNameValue(ballStatistics.getRed_nineteen(),"红球19"));
            redball[19] = ballStatistics.getRed_twenty();
            redballs.add(new BallNameValue(ballStatistics.getRed_twenty(),"红球20"));
            redball[20] = ballStatistics.getRed_twenty_one();
            redballs.add(new BallNameValue(ballStatistics.getRed_twenty_one(),"红球21"));
            redball[21] = ballStatistics.getRed_twenty_two();
            redballs.add(new BallNameValue(ballStatistics.getRed_twenty_two(),"红球22"));
            redball[22] = ballStatistics.getRed_twenty_three();
            redballs.add(new BallNameValue(ballStatistics.getRed_twenty_three(),"红球23"));
            redball[23] = ballStatistics.getRed_twenty_four();
            redballs.add(new BallNameValue(ballStatistics.getRed_twenty_four(),"红球24"));
            redball[24] = ballStatistics.getRed_twenty_five();
            redballs.add(new BallNameValue(ballStatistics.getRed_twenty_five(),"红球25"));
            redball[25] = ballStatistics.getRed_twenty_six();
            redballs.add(new BallNameValue(ballStatistics.getRed_twenty_six(),"红球26"));
            redball[26] = ballStatistics.getRed_twenty_seven();
            redballs.add(new BallNameValue(ballStatistics.getRed_twenty_seven(),"红球27"));
            redball[27] = ballStatistics.getRed_twenty_eight();
            redballs.add(new BallNameValue(ballStatistics.getRed_twenty_eight(),"红球28"));
            redball[28] = ballStatistics.getRed_twenty_nine();
            redballs.add(new BallNameValue(ballStatistics.getRed_twenty_nine(),"红球29"));
            redball[29] = ballStatistics.getRed_thirty();
            redballs.add(new BallNameValue(ballStatistics.getRed_thirty(),"红球30"));
            redball[30] = ballStatistics.getRed_thirty_one();
            redballs.add(new BallNameValue(ballStatistics.getRed_thirty_one(),"红球31"));
            redball[31] = ballStatistics.getRed_thirty_two();
            redballs.add(new BallNameValue(ballStatistics.getRed_thirty_two(),"红球32"));
            redball[32] = ballStatistics.getRed_thirty_three();
            redballs.add(new BallNameValue(ballStatistics.getRed_thirty_three(),"红球33"));
            blueball[0] = ballStatistics.getBlue_one();
            blueballs.add(new BallNameValue(ballStatistics.getBlue_one(),"蓝球1"));
            blueball[1] = ballStatistics.getBlue_two();
            blueballs.add(new BallNameValue(ballStatistics.getBlue_two(),"蓝球2"));
            blueball[2] = ballStatistics.getBlue_three();
            blueballs.add(new BallNameValue(ballStatistics.getBlue_three(),"蓝球3"));
            blueball[3] = ballStatistics.getBlue_four();
            blueballs.add(new BallNameValue(ballStatistics.getBlue_four(),"蓝球4"));
            blueball[4] = ballStatistics.getBlue_five();
            blueballs.add(new BallNameValue(ballStatistics.getBlue_five(),"蓝球5"));
            blueball[5] = ballStatistics.getBlue_six();
            blueballs.add(new BallNameValue(ballStatistics.getBlue_six(),"蓝球6"));
            blueball[6] = ballStatistics.getBlue_seven();
            blueballs.add(new BallNameValue(ballStatistics.getBlue_seven(),"蓝球7"));
            blueball[7] = ballStatistics.getBlue_eight();
            blueballs.add(new BallNameValue(ballStatistics.getBlue_eight(),"蓝球8"));
            blueball[8] = ballStatistics.getBlue_nine();
            blueballs.add(new BallNameValue(ballStatistics.getBlue_nine(),"蓝球9"));
            blueball[9] = ballStatistics.getBlue_ten();
            blueballs.add(new BallNameValue(ballStatistics.getBlue_ten(),"蓝球10"));
            blueball[10] = ballStatistics.getBlue_eleven();
            blueballs.add(new BallNameValue(ballStatistics.getBlue_eleven(),"蓝球11"));
            blueball[11] = ballStatistics.getBlue_twelve();
            blueballs.add(new BallNameValue(ballStatistics.getBlue_twelve(),"蓝球12"));
            blueball[12] = ballStatistics.getBlue_thirteen();
            blueballs.add(new BallNameValue(ballStatistics.getBlue_thirteen(),"蓝球13"));
            blueball[13] = ballStatistics.getBlue_fourteen();
            blueballs.add(new BallNameValue(ballStatistics.getBlue_fourteen(),"蓝球14"));
            blueball[14] = ballStatistics.getBlue_fifteen();
            blueballs.add(new BallNameValue(ballStatistics.getBlue_fifteen(),"蓝球15"));
            blueball[15] = ballStatistics.getBlue_sixteen();
            blueballs.add(new BallNameValue(ballStatistics.getBlue_sixteen(),"蓝球16"));

            System.out.println("拆分后红球、蓝球分别是：");
            System.out.println("redball ");
            for (int i=0;i<33;i++){
                System.out.print(redball[i]+"   ");
            }
            System.out.println();
            System.out.println("blueball ");
            for (int i=0;i<16;i++){
                System.out.print(blueball[i]+"   ");
            }
            ballStatisticsDivide.setRedball(redball);
            ballStatisticsDivide.setBlueball(blueball);
            ballStatisticsDivide.setRedballs(redballs);
            ballStatisticsDivide.setBlueballs(blueballs);

        }

        return ballStatisticsDivide;

    }


}
