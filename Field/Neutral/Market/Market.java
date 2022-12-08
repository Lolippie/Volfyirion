package Field.Neutral.Market;

import Using.Shuffle.*;
import java.util.ArrayList;
import Using.Card.*;;

public class Market implements Shuffle {
  private ArrayList<Card> market;
  private ArrayList<Card> market_pile;

  public Market(ArrayList<Card> pile) {
    this.market_pile = pile;
    this.market = new ArrayList<Card>();
  }

  // getter/setter
  public ArrayList<Card> getMarket() {
    return this.market;
  }

  public ArrayList<Card> getMarketPile() {
    return this.market_pile;
  }

  public void setMarket(ArrayList<Card> l_c) {
    this.market = l_c;
  }

  public void setMarketPile(ArrayList<Card> l_c) {
    this.market_pile = l_c;
  }

  // fonctionnalité faire marché
  public void shuffledCard() {
    ArrayList<Card> marketCards = new ArrayList<Card>();
    while (this.market_pile.size() > 0) {
      int index = (int) (Math.random() * this.market_pile.size());
      Card removedCard = this.market_pile.get(index);
      this.market_pile.remove(index);
      marketCards.add(removedCard);
    }
    this.market_pile = marketCards;
    System.out.println("Shuffled Cards Market");
  }

  public void makeMarket() {
    while (this.market.size() != 5) {
      Card card = randomCard();
      this.market.add(card);
    }
  }

  public Card randomCard() {
    int number = (int) (Math.random() * (this.market_pile.size() - 1));
    Card pickThisOne = market_pile.get(number);
    removeCardPile(pickThisOne);
    return pickThisOne;
  }

  public void removeCardPile(Card c) {
    this.market_pile.remove(c);
  }

  public void removeCardMarket(Card c) {
    this.market.remove(c);
  }

  public void addCardMarket(Card c){
    this.market.add(c);
  }
}