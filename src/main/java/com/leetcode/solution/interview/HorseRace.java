package com.leetcode.solution.interview;

import java.util.Random;

/**
 * @author yangguang14
 * @date 2020/5/10.
 */
public class HorseRace {
    /**
     * 假设入参总是存在某种内在联系 speeds=trackNum * trackNum;trackNum>topNum
     *
     * @param speeds   参与者速度 length=64
     * @param trackNum 跑道数量 8
     * @param topNum   top数 4
     * @return 比赛次数
     */
    public int findLessTime(int[] speeds, int trackNum, int topNum) {
        if (speeds.length <= topNum) {
            return 1;
        }
        int result = 0;

        //第一轮次让所有参与者比赛
        int firstNum = speeds.length / trackNum;
        result += firstNum;
        //可能剩余未参与的数量,此处=0
        int firstNoNum = speeds.length % trackNum;
        //第二轮次让所有场次的第一名与未参与者共同比赛。
        int secondNum = (firstNum + firstNoNum) / trackNum;
        result += secondNum;
        //可能剩余未参与的数量,此处=0
        int secNoNum = (firstNum + firstNoNum) % trackNum;
        //如果大于1，此处无法选择出topNum所属轮次，需要递归处理
        if (secNoNum > 1) {

        }
        //记录topNum所属轮次，此时剩余候选者为topNum所属轮次

        //此时top1肯定为结果，后续判断top1轮次中的后继者与其他top关系
        //如果top1的后继者<topNum，则确定结果为topNum；
        //如果top1轮次中最小者>top2则确定结果为top1轮次中
        //此处根据设定，trackNum>topNum;则本轮次剔除top1，加入top1后继者与top1轮次中最小者(如有其他空位可顺序加入top2的后继者)
        result++;


        //在其他情况下，无法确认，但可以确定部分top，即top中除top1中会加入所有>top1后继者的top
        //在此处设定下，一个轮次即可
        if (new Random().nextInt(10) > 5) {
            System.out.println("较坏情况。。。");
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        int trackNum = 5;
        int speedLength = trackNum * trackNum;
        int topNum = 3;
        int[] speeds = new int[speedLength];
        System.out.println(new HorseRace().findLessTime(speeds, trackNum, topNum));

        trackNum = 8;
        speedLength = trackNum * trackNum;
        topNum = 4;
        speeds = new int[speedLength];
        System.out.println(new HorseRace().findLessTime(speeds, trackNum, topNum));
    }
}
