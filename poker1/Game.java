package poker1;

import java.lang.management.PlatformLoggingMXBean;
import java.util.*;

public class Game {

    public static void main(String[] args) {

        //初始化玩家
        List<Player> playerList = initializedPlayerList();

        //初始化牌组
        List<Card> cardList = initializedCardList();

        //洗牌
        Collections.shuffle(cardList);

        //抽牌
        drawCard(playerList,cardList);
        System.out.println("摸牌之后");
        //打印手牌
        printHands(playerList);

        //把没有手牌的玩家去掉
        Iterator<Player> iterator = playerList.iterator();
        while (iterator.hasNext()) {
            Player next = iterator.next();
            if(next.cardList.isEmpty()) {
                iterator.remove();
            }
        }

        System.out.println("开始游戏之前");
        System.out.println(playerList);

        //开始游戏
        Random random = new Random();
        while (true) {
            //只剩下一名玩家时游戏结束
            if (playerList.size() == 1) {
                break;
            }


            //每名玩家抽取下家的牌
            for (int i = 0; i < playerList.size(); i++) {

                if (playerList.size() == 1) {
                    break;
                }


                Player current = playerList.get(i);
                int nextIndex = i == playerList.size() - 1 ? 0 : i + 1;
                Player next = playerList.get(i == playerList.size() - 1 ? 0 : i + 1);
                //current随机抽取一张next的牌
                int randomIndex = random.nextInt(next.cardList.size());

                System.out.println("目前在当前游戏中的玩家有：");
                printHands(playerList);

                //先把牌抽出来
                Card card = next.cardList.remove(randomIndex);

                System.out.println(current.name + "抽了" + next.name + "一张牌" + card);


                //如果下家手牌空了，下家退出
                if (next.cardList.isEmpty()) {
                    playerList.remove(nextIndex);
                }

                //尝试把抽出来的牌，加入到当前玩家手中，但是，如果有对子，就不用加
                boolean needAdd = true;
                Iterator<Card> it2 = current.cardList.iterator();
                while (it2.hasNext()) {
                    if (it2.next().equalsRank(card)) {
                        it2.remove();
                        needAdd = false;
                    }
                }
                if (needAdd) {
                    current.cardList.add(card);
                }
                //如果当前玩家手牌为空，退出循环
                if (current.cardList.isEmpty()) {
                    playerList.remove(i);
                    i = i - 1;
                }
            }

        }

        System.out.println(playerList + "是鬼！");


    }

    public static void drawCard(List<Player> playerList,List<Card> cardList) {

        while (true) {
            //每轮都是依次抽排
            for (Player player : playerList) {//把牌从牌组中取出来，并没有发到玩家手里
                //if(cardList.size() == 0)
                if (cardList.isEmpty()) {
                    //唯一的出口
                    return;
                }

                //抽一张牌,意思就是从牌组中取出一张牌
                Card card = cardList.remove(0);
                //吧牌加入手牌之前，先检查一下有没有对子
                boolean 是否需要把Card加入手牌 = true;
                Iterator<Card> it = player.cardList.iterator();
                //用迭代器遍历手中的每一张牌
                while (it.hasNext()) {
                    Card everyCard = it.next();
                    if(everyCard.equalsRank(card)) {
                        //遍历过程中检查是否点数相同，相同就删除
                        it.remove();
                        是否需要把Card加入手牌 = false;
                    }
                }
                if(是否需要把Card加入手牌) {
                    player.cardList.add(card);
                }
            }

        }
    }

    public static void printHands(List<Player> playerList) {
        for(Player player : playerList) {
            System.out.printf("%s 的手牌: %s%n",player.name,player.cardList);

        }
    }

    public static List<Player> initializedPlayerList() {
        List<Player> playerList = new ArrayList<>();

        playerList.add(new Player("周润发"));
        playerList.add(new Player("刘德华"));
        playerList.add(new Player("周星驰"));
        playerList.add(new Player("小刀"));
        playerList.add(new Player("高进"));


        return playerList;
     }

    public static List<Card> initializedCardList(){
        List<Card> cardList = new ArrayList<>();

        for(String suit : new String[] {"♠","♥","♦","♣"}) {
            for (int rank = 1;rank < 5;rank++) {

                cardList.add(new Card(suit,rank));
            }
        }

        //删掉一张A
        cardList.remove(0);


        return cardList;
    }
}
