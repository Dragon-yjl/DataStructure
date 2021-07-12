package poker1;

import java.util.Objects;

public class Card {
    public String suit;//花色
    public int rank;///点数

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("[%s,%d]",suit,rank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        poker.Card card = (poker.Card) o;
        return rank == card.rank &&
                Objects.equals(suit, card.suit);
    }

    //只比较点数相同
    public boolean equalsRank(Card card) {
        return rank == card.rank;
    }
}
