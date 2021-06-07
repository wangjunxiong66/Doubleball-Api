package com.wjx.sportsplatformapi.entity;

import java.util.Arrays;
import java.util.List;

/**
 * @author wjx
 * @version 1.0
 * @date 2021/6/4 下午3:54
 *  这是双色球统计记录的细化拆分
 */
public class BallStatisticsDivide {
    public List<BallNameValue> redballs;
    public List<BallNameValue> blueballs;
    public int[] redball;
    public int[] blueball;

    public BallStatisticsDivide() {
    }

    public BallStatisticsDivide(List<BallNameValue> redballs, List<BallNameValue> blueballs, int[] redball, int[] blueball) {
        this.redballs = redballs;
        this.blueballs = blueballs;
        this.redball = redball;
        this.blueball = blueball;
    }

    public List<BallNameValue> getRedballs() {
        return redballs;
    }

    public void setRedballs(List<BallNameValue> redballs) {
        this.redballs = redballs;
    }

    public List<BallNameValue> getBlueballs() {
        return blueballs;
    }

    public void setBlueballs(List<BallNameValue> blueballs) {
        this.blueballs = blueballs;
    }

    public int[] getRedball() {
        return redball;
    }

    public void setRedball(int[] redball) {
        this.redball = redball;
    }

    public int[] getBlueball() {
        return blueball;
    }

    public void setBlueball(int[] blueball) {
        this.blueball = blueball;
    }

    @Override
    public String toString() {
        return "BallStatisticsDivide{" +
                "redballs=" + redballs +
                ", blueballs=" + blueballs +
                ", redball=" + Arrays.toString(redball) +
                ", blueball=" + Arrays.toString(blueball) +
                '}';
    }
}
