package com.leetcode.solution.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * @author yangguang14
 * @date 2020/5/15.
 */
public class HorseRace2 {
    /**
     * 假设入参总是存在某种内在联系 固定数量
     *
     * @param speeds 参与者速度 length=64
     * @return 比赛次数
     */
    public int findLessTime(int[] speeds) {
        int trackNum = 8;
        int topNum = 4;
        if (speeds.length <= topNum) {
            return 1;
        }
        int result = 0;

        //第一轮次让所有参与者分组比赛
        int firstNum = speeds.length / trackNum;
        //分组。
        int[][] firstRound = new int[firstNum][trackNum];
        //记录原数组已分配索引
        int index = 0;
        //分配组员
        for (int i = 0; i < firstRound.length; i++) {
            System.out.println("初始分组第"+i+"组：");
            for (int j = 0; j < firstRound[0].length; j++) {
                firstRound[i][j] = speeds[index++];
                System.out.print(firstRound[i][j]+",");
            }
            System.out.println();
        }
        System.out.println();
        //记录第一轮次比赛次数
        result += firstNum;
        //模拟比赛使用排序
        for (int[] rounds : firstRound) {
            //默认降序排序，简单起见不指定排序方式
            Arrays.sort(rounds);
        }
        for (int i = 0; i < firstRound.length; i++) {
            System.out.println("分组第"+i+"组，比赛结果：");
            for (int j = 0; j < firstRound[0].length; j++) {
                System.out.print(firstRound[i][j]+",");
            }
            System.out.println();
        }
        System.out.println();
        //第二轮次让所有场次的第一名比赛。
        int secondNum = firstNum / trackNum;
        //本轮次需要记录原始分组，建立一个Node类型存储
        Node[] secondRound = new Node[trackNum];
        for (int i = 0; i < secondRound.length; i++) {
            secondRound[i] = new Node(firstRound[i][trackNum - 1], i);
            System.out.println("第二轮次参与者，所属分组："+secondRound[i].round+"，速度："+secondRound[i].speed);
        }
        System.out.println();
        //按速度排序
        Arrays.sort(secondRound, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.speed - o1.speed;
            }
        });
        result += secondNum;
        //记录topNum所属轮次,取出前topNum名，此时剩余候选者为topNum所属轮次;
        Node[] resultNode = new Node[topNum];
        for (int i = 0; i < secondRound.length; i++) {
            System.out.println("第二轮次参与者比赛结果，所属分组："+secondRound[i].round+"，速度："+secondRound[i].speed);
        }
        //此时top1肯定为结果，后续判断top1轮次中的后继者与其他top关系
        resultNode[0] = secondRound[0];
        //如果top1的后继者<topNum，则确定结果为topNum；
        Node[] thirdRound = new Node[trackNum];
        //找出本轮次8名参与者
        //加入top1后继者
        thirdRound[0] = new Node(firstRound[secondRound[0].round][trackNum-2], secondRound[0].round);
        //加入top1轮次中(第四名)
        thirdRound[1] = new Node(firstRound[secondRound[0].round][trackNum - topNum + 1], secondRound[0].round);
        //加入top2,3,4
        thirdRound[2] = secondRound[1];
        thirdRound[3] = secondRound[2];
        thirdRound[4] = secondRound[3];
        //其他空位可顺序加入top2的第二名及第三名（他的第四名肯定不在候选名单）
        thirdRound[5] = new Node(firstRound[secondRound[1].round][trackNum-2], secondRound[1].round);
        thirdRound[6] = new Node(firstRound[secondRound[1].round][trackNum-3], secondRound[1].round);
        thirdRound[7] = new Node(firstRound[secondRound[2].round][trackNum-2], secondRound[2].round);
        for (int i = 0; i < thirdRound.length; i++) {
            System.out.println("第三轮次参与者，所属分组："+thirdRound[i].round+"，速度："+thirdRound[i].speed);
        }
        System.out.println();
        //按速度排序
        Arrays.sort(thirdRound, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.speed - o1.speed;
            }
        });
        for (int i = 0; i < thirdRound.length; i++) {
            System.out.println("第三轮次参与者比赛结果，所属分组："+thirdRound[i].round+"，速度："+thirdRound[i].speed);
        }
        System.out.println();
        result++;
        /**
         * 此后逻辑判断，前三名状态
         * 1.如果第1名为top1后继者，
         *  1.1 top1轮次中(第四名)在前三. 即可确定；（第二，则top1分组的前四即为结果；第三则top2替换top1轮次中(第四名)）
         *  1.2 top1轮次中(第四名)不在前三，则本场第二为top2，此时无法确定top1中第三名是否应该在结果。需加赛1
         * 2.如果第一名为top2，则比较top2的后继者位置。具体情况同1，只不过是需要选前二
         *  2.1 如果第二名为top2的后继者，即可确定；（前三名即结果）
         *  2.2 如果第二名为top3，无法确定top2的第二名与top3的第三名及第四名谁该归属结果，需加赛1
         */
        if (thirdRound[0].round == secondRound[0].round) {
            if (thirdRound[1].round == secondRound[0].round
                    || thirdRound[2].round == secondRound[0].round) {
                System.out.println("1.1,结束");
            } else {
                System.out.println("1.2,加赛");
                result++;
            }
        } else if (thirdRound[0].round == secondRound[1].round) {
            if (thirdRound[1].round == secondRound[1].round) {
                System.out.println("2.1,结束");
            } else {
                System.out.println("2.2,加赛");
                result++;
            }
        }
        System.out.println("比赛结束了--共" + result + "场次");
        return result;
    }

    class Node {
        int speed;
        int round;

        public Node(int s, int r) {
            speed = s;
            round = r;
        }
    }

    public static void main(String[] args) {
        int[] speeds = new int[64];
        for (int i = 0; i < speeds.length; i++) {
            speeds[i] = new Random().nextInt(1000);
        }
        System.out.println(new HorseRace2().findLessTime(speeds));

    }
}
