package com.wjx.sportsplatformapi.dao;

import com.wjx.sportsplatformapi.entity.Ball;
import com.wjx.sportsplatformapi.entity.BallStatistics;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BallDao {

    //  在下面语句中，不能省略 "@Param..."，否则会提示类似"nested exception is org.apache.ibatis.binding.BindingException: Parameter 'roleIds' not found. Available parameters are [0, 1, param1, param2]"的异常
    public List<Ball> getAllBall(@Param("issue") String issue, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int getBallCounts(@Param("issue") String issue);
    public int addBall(Ball ball) ;
    public Ball getupdateball(int id);
    public int editBall(Ball ball);
    public int queryBallByIssue(int issue);
    public int queryBallByDrawPrizeDate(String draw_prize_date);
    public int deleteBall(int id);
    public List<Ball> getAllBalls();
    public int insertBallCalculate(@Param("red_one") Integer red_one,@Param("red_two") Integer red_two, @Param("red_three") Integer red_three,@Param("red_four") Integer red_four,@Param("red_five") Integer red_five, @Param("red_six") Integer red_six, @Param("red_seven") Integer red_seven,@Param("red_eight") Integer red_eight,@Param("red_nine") Integer red_nine,@Param("red_ten") Integer red_ten,@Param("red_eleven") Integer red_eleven,@Param("red_twelve") Integer red_twelve, @Param("red_thirteen") Integer red_thirteen,@Param("red_fourteen") Integer red_fourteen,@Param("red_fifteen") Integer red_fifteen,@Param("red_sixteen") Integer red_sixteen,@Param("red_seventeen") Integer red_seventeen, @Param("red_eighteen") Integer red_eighteen,@Param("red_nineteen") Integer red_nineteen,@Param("red_twenty") Integer red_twenty,@Param("red_twenty_one") Integer red_twenty_one,@Param("red_twenty_two") Integer red_twenty_two, @Param("red_twenty_three") Integer red_twenty_three,@Param("red_twenty_four") Integer red_twenty_four,@Param("red_twenty_five") Integer red_twenty_five,@Param("red_twenty_six") Integer red_twenty_six, @Param("red_twenty_seven") Integer red_twenty_seven,@Param("red_twenty_eight") Integer red_twenty_eight,@Param("red_twenty_nine") Integer red_twenty_nine,@Param("red_thirty") Integer red_thirty, @Param("red_thirty_one") Integer red_thirty_one,@Param("red_thirty_two") Integer red_thirty_two,@Param("red_thirty_three") Integer red_thirty_three,@Param("blue_one") Integer blue_one,@Param("blue_two") Integer blue_two, @Param("blue_three") Integer blue_three,@Param("blue_four") Integer blue_four,@Param("blue_five") Integer blue_five,@Param("blue_six") Integer blue_six,@Param("blue_seven") Integer blue_seven, @Param("blue_eight") Integer blue_eight,@Param("blue_nine") Integer blue_nine,@Param("blue_ten") Integer blue_ten,@Param("blue_eleven") Integer blue_eleven,@Param("blue_twelve") Integer blue_twelve, @Param("blue_thirteen") Integer blue_thirteen,@Param("blue_fourteen") Integer blue_fourteen,@Param("blue_fifteen") Integer blue_fifteen,@Param("blue_sixteen") Integer blue_sixteen,@Param("calculate_date") String calculate_date);
    public BallStatistics findLastBallCalculate();

}
