package poker;

import java.util.ArrayList;
import java.util.List;

public class Player {

    List<Card> cards = new ArrayList<>();
    public String name;

    public Player(String name) {
        this.name = name;
    }
}
