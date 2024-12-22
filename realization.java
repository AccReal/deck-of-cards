import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Класс карты
class Card {
    private String suit; // Масть
    private String rank; // Значение

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return suit.equals(card.suit) && rank.equals(card.rank);
    }

    @Override
    public int hashCode() {
        return suit.hashCode() + rank.hashCode();
    }
}

// Класс колоды
class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        // Создание колоды
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    // Перетасовка колоды
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Сдача карты
    public Card dealCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("В колоде больше нет карт.");
        }
        return cards.remove(0);
    }

    // Возврат карты в колоду
    public void returnCard(Card card) {
        if (cards.contains(card)) {
            System.out.println("Эта карта уже находится в колоде.");
        } else {
            cards.add(card);
            System.out.println(card + " возвращена в колоду.");
        }
    }

    // Отображение оставшихся карт
    public void showDeck() {
        System.out.println("Оставшиеся карты в колоде:");
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();

        System.out.println("Изначальная колода:");
        deck.showDeck();

        // Перетасовка колоды
        deck.shuffle();
        System.out.println("\nПеретасованная колода:");
        deck.showDeck();

        // Сдача карты
        Card dealtCard = deck.dealCard();
        System.out.println("\nСданная карта: " + dealtCard);

        // Попытка вернуть карту
        deck.returnCard(dealtCard);

        // Попытка вернуть ту же карту снова
        deck.returnCard(dealtCard);

        System.out.println("\nКолода после операций:");
        deck.showDeck();
    }
}
