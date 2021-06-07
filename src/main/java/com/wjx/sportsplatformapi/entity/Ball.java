package com.wjx.sportsplatformapi.entity;

/**
 * @author wjx
 * @version 1.0
 * @date 2021/5/18 下午2:40
 * 这是双色球记录
 */
public class Ball {

    public int id ;
    public int issue ;
    public int red_one ;
    public int red_two ;
    public int red_three ;
    public int red_four ;
    public int red_five ;
    public int red_six ;
    public int blue ;
    public String draw_prize_date ;

    public Ball() {
    }

    public Ball(int issue, int red_one, int red_two, int red_three, int red_four, int red_five, int red_six, int blue, String draw_prize_date) {
        this.issue = issue;
        this.red_one = red_one;
        this.red_two = red_two;
        this.red_three = red_three;
        this.red_four = red_four;
        this.red_five = red_five;
        this.red_six = red_six;
        this.blue = blue;
        this.draw_prize_date = draw_prize_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    public int getRed_one() {
        return red_one;
    }

    public void setRed_one(int red_one) {
        this.red_one = red_one;
    }

    public int getRed_two() {
        return red_two;
    }

    public void setRed_two(int red_two) {
        this.red_two = red_two;
    }

    public int getRed_three() {
        return red_three;
    }

    public void setRed_three(int red_three) {
        this.red_three = red_three;
    }

    public int getRed_four() {
        return red_four;
    }

    public void setRed_four(int red_four) {
        this.red_four = red_four;
    }

    public int getRed_five() {
        return red_five;
    }

    public void setRed_five(int red_five) {
        this.red_five = red_five;
    }

    public int getRed_six() {
        return red_six;
    }

    public void setRed_six(int red_six) {
        this.red_six = red_six;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public String getDraw_prize_date() {
        return draw_prize_date;
    }

    public void setDraw_prize_date(String draw_prize_date) {
        this.draw_prize_date = draw_prize_date;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "id=" + id +
                ", issue=" + issue +
                ", red_one=" + red_one +
                ", red_two=" + red_two +
                ", red_three=" + red_three +
                ", red_four=" + red_four +
                ", red_five=" + red_five +
                ", red_six=" + red_six +
                ", blue=" + blue +
                ", draw_prize_date='" + draw_prize_date + '\'' +
                '}';
    }
}
