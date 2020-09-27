package main.java.com.bobozhuang.collection.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 * description： 规则:
 *                      一共三个玩家
 *                      每个玩家按照顺序依次抽取扑克牌，美人总共抽取17张
 *                      剩余3张扑克牌作为底牌，由“地主”收取
 *
 *        流程：
 *          将54张扑克牌依次存储一个ArrayList中（装进牌盒子）
 *          打乱这54张扑克牌（洗牌）
 *          按顺序给三个TreeSet依次发牌，并留三张牌存入另一个TreeSet中（发牌、理牌）
 *          遍历这四个TreeSet（看牌）
 *
 * author Hubery
 * date 2020-08-30
 * version v0.0.1
 * since v0.0.1
 **/
public class PokerGame {

    public static void main(String[] args) {
        //斗地主： 发牌 理牌 看牌

        /* 创建牌盒子 */
        ArrayList<String> pokerBox = new ArrayList<>();
        /* 生成牌 装进牌盒子 */
        String[] colos = {"♥", "♠", "♦", "♣"};
        String[] nums = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (String color : colos) {
            for (String num : nums) {
                String poker = color.concat(num);//将指定的字符串连接到该字符串的末尾。
                pokerBox.add(poker);
            }
        }
        /* 手动添加大小王 */
        pokerBox.add("🌙");	//假设🌙代表小王
        pokerBox.add("☀");		//假设☀代表小王
        /* 洗牌 */
        Collections.shuffle(pokerBox); //随机打乱集合中元素的顺序

        /* 发牌、理牌 */
        //三个人，对应三个集合 底牌也是个集合
        //三个人 一人17张牌一副牌， 还有三张底牌
        TreeSet<String> gaoJin = new TreeSet<String>(new PokerSorter());
        TreeSet<String> chenDaoZai = new TreeSet<String>(new PokerSorter());
        TreeSet<String> zhouXingXing = new TreeSet<String>(new PokerSorter());
        TreeSet<String> lastPokers = new TreeSet<String>(new PokerSorter());
        //发牌的顺序：
        //高进 0 3 6 9 ... ...
        //陈刀仔 1 4 7 10 ... ...
        //周星星 2 5 8 11 ... ...
        for (int i = 0; i < pokerBox.size(); i++) {
            if(i>=pokerBox.size()-3){
                lastPokers.add(pokerBox.get(i));
            }else if(i%3==0){
                gaoJin.add(pokerBox.get(i));
            } else if (i % 3 == 1) {
                chenDaoZai.add(pokerBox.get(i));
            }else {
                zhouXingXing.add(pokerBox.get(i));
            }
        }

        /* 看牌 */
        lookPoker("高进", gaoJin);
        lookPoker("陈刀仔", chenDaoZai);
        lookPoker("周星星", zhouXingXing);
        lookPoker("底牌", lastPokers);
    }

    private static void lookPoker(String name, TreeSet<String> treeSet) {
        System.out.println(name);
        for (String poker : treeSet) {
            System.out.print(poker + "\t");
        }
        System.out.println();

    }

}

