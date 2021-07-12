package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

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
        int n = 2;//n表示每名玩家发几张牌
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


         //打印每位玩家手牌
        for(Player player : players) {
            System.out.printf("玩家 [%s] 的手牌是：%s%n",player.name,player.cards);
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
