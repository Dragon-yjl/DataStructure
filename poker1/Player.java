package poker1;

import java.util.ArrayList;
import java.util.List;

public class Player {

    List<Card> cardList = new ArrayList<>();

    public String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "cardList=" + cardList +
                ", name='" + name + '\'' +
                '}';
    }
}
