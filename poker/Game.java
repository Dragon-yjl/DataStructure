package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/***
 * 扑克牌游戏
 * 1-5总共20张牌，五个玩家每人发四张牌，每个玩家抽取
 * 一张下家的牌，如果某张牌再谁手里谁获胜
 */
public class Game {

    public static void printPlayerHandCards (List<Player> players) {
        for(Player player : players) {
            System.out.printf("玩家 [%s] 的手牌是：%s%n",player.name,player.cards);
        }
    }

    public static void main(String[] args) {

        //新增5名玩家,使用List
        List<Player> players = new ArrayList<>();
        players.add(new Player("周润发"));
        players.add(new Player("刘德华"));
        players.add(new Player("小刀"));
        players.add(new Player("周星驰"));
        players.add(new Player("高进"));

        //List作为线性表，表现生活中很多前后关系的物品
        List<Card> cards = new ArrayList<>();

        //初始化扑克牌
        initializeCards(cards);
        System.out.println("新牌");
        System.out.println(cards);

        //调用Collection(jdk 提供的类)下的 shuffle（洗牌）方法、
        //进行洗牌操作
        Collections.shuffle(cards);
        System.out.println("发牌前洗过的牌");
        System.out.println(cards);


        //发牌操作
        int n = 4;//n表示每名玩家发几张牌
        for(int i = 0;i<n;i++) {//一共发两轮牌
            for(Player player : players) {//每名玩家依次抽排

                Card card = cards.remove(0);
                //从牌组0号下标开始抽一张牌出来

                player.cards.add(card);
                //把这抽出来的牌放到玩家手中
            }
        }
        System.out.println("发过牌后牌组中剩余的牌");
        System.out.println(cards);


        //要找的牌
        Card toFindCard  = new Card("♥",1);

         //打印每位玩家手牌
        System.out.println("抽牌之前的情况");
        printPlayerHandCards(players);

        Player 周润发  = players.get(0);
        发哥发功(周润发,toFindCard,players);
        System.out.println("发哥第一次发功之后的牌");
        printPlayerHandCards(players);


        //抽牌操作
        Random random = new Random();
        //轮番交换牌
        //每名玩家抽取其下家一张随机的牌
        for(int i = 0;i < players.size();i++) {//遍历玩家的牌
            Player currentPlayer = players.get(i);//当前玩家
            Player nextPlayer = players.get(i != players.size() - 1  ? i+1 : 0);
            //下一名玩家如果是最后一名玩家就抽第一名玩家的

            //要取得牌的下标
            int toDrawIndex = random.nextInt(nextPlayer.cards.size());
            //取牌 取下一个玩家的牌
            Card drawCard = nextPlayer.cards.remove(toDrawIndex);
            //放入当前玩家手中
            currentPlayer.cards.add(drawCard);

        }
        System.out.println("抽牌之后的情况");
        printPlayerHandCards(players);

        发哥发功(周润发,toFindCard,players);
        System.out.println("发哥第二次发功之后的牌");
        printPlayerHandCards(players);





        for(Player player : players) {//遍历每位玩家
            //方法一
            if(player.cards.contains(toFindCard)) {
                System.out.println(player.name+" 获胜！");
                return;
            }


            //方法二
//            for(Card card : player.cards) {//遍历每位玩家手中的牌
//                //比较每张牌和要找的那张牌是否是同一张牌
//                //if(toFindCard.equals(card))
//                if(card.equals(toFindCard)) {
//                    //如果equals方法没有重写，就无人获胜
//                    //所以要在card中重写equals方法
//                    System.out.println(player.name +"获胜！");
//                    return;
//                }
//            }

        }
        System.out.println("无人获胜！");
    }

    public static void 发哥发功(Player 周润发,Card toFindCard,List<Player> players) {
        if(!周润发.cards.contains(toFindCard)) {
            Card card = 周润发.cards.get(0);
            周润发.cards.set(0,toFindCard);

            //跳过0号下标
            for(int i = 1;i < players.size();i++) {
                if(players.get(i).cards.contains(toFindCard)) {
                    //下标为i的玩家持有黑桃A

                    //下标顺序改变，只是单纯的加进去
//                    players.get(i).cards.remove(toFindCard);
//                    players.get(i).cards.add(card);

                    //下标顺序不动
                    int j = players.get(i).cards.indexOf(toFindCard);
                    players.get(i).cards.set(j,card);
                }
             }
        }
    }

    public static void initializeCards(List<Card> cards) {
        for(String suit : new String[] {"♠","♥","♦","♣"}) {
            for(int rank = 1; rank <= 5; rank++) {
                Card card = new Card(suit,rank);

                //把扑克牌放到牌组中
                cards.add(card);

            }

        }
    }
}
