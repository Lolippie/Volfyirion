package Field.Player.Deck;

import Using.Shuffle.*;
import Using.Card.*;
import java.util.ArrayList;
import Using.Card.Building;
import Using.Card.Protector;

public class Deck implements Shuffle {
  private ArrayList<Card> rest; // Le Repos = pioche personnelle du joueur, chaque cartes y va après leur achat
                                // et de la main après chaque tour (sans compter les défausses/envois au
                                // cimetière)
  private ArrayList<Card> hand; // La Main = chaque tour le joueur pioche cinq cartes du repos
                                // (éventuellement plus avec des effets)

  private ArrayList<Protector> protectors;
  private ArrayList<Normal> normals;
  private ArrayList<Building> buildings;

  public Deck(ArrayList<Protector> protectors, ArrayList<Normal> normals, ArrayList<Building> buildings) {
    this.rest = new ArrayList<Card>();
    this.hand = new ArrayList<Card>();
    this.protectors = protectors;
    this.normals = normals;
    this.buildings = buildings;
  }

  // Modalités Deck
  public ArrayList<Card> getRest() {
    return this.rest;
  }

  public ArrayList<Card> getHand() {
    return this.hand;
  }

  public ArrayList<Protector> getProtectors() {
    ArrayList<Protector> proHand = new ArrayList<Protector>();
    for (Card c : this.hand) {
      for (Protector p : this.protectors) {
        if (c.getName().equals(p.getName())) {
          proHand.add(p);
        }
      }
    }
    return proHand;
  }

  public ArrayList<Normal> getNormals() {
    ArrayList<Normal> norHand = new ArrayList<Normal>();
    for (Card c : this.hand) {
      for (Normal n : this.normals) {
        if (c.getName().equals(n.getName())) {
          norHand.add(n);
        }
      }
    }
    return norHand;
  }

  public ArrayList<Building> getBuildings() {
    ArrayList<Building> bui = new ArrayList<Building>();
    for (Card c : this.hand) {
      for (Building b : this.buildings) {
        if (c.getName().equals(b.getName())) {
          bui.add(b);
        }
      }
    }
    return bui;
  }

  public Building getBuildingFromCard(Card c) {
    ArrayList<Building> bui = getBuildings();
    for (Building b : bui) {
      if (c.getName().equals(b.getName())) {
        return b;
      }
    }
    return null;
  }

  public Protector getProtectorFromCard(Card c) {
    ArrayList<Protector> pro = getProtectors();
    for (Protector p : pro) {
      if (c.getName().equals(p.getName())) {
        return p;
      }
    }
    return null;
  } 

  public Normal getNormalFromCard(Card c) {
    ArrayList<Normal> nor = getNormals();
    for (Normal n : nor) {
      if (c.getName().equals(n.getName())) {
        return n;
      }
    }
    return null;
  }
  
  public boolean isNormal(Card c) {
    ArrayList<Normal> nor = getNormals();
    for (Normal n : nor) {
      if (c.getName().equals(n.getName())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isProtector(Card c) {
    ArrayList<Protector> pro = getProtectors();
    for (Protector d : pro) {
      if (c.getName().equals(d.getName())) {
        return true;
      }
    }
    return false;
  }

  public boolean isBuilding(Card c) {
    ArrayList<Building> bui = getBuildings();
    for (Building b : bui) {
      if (c.getName().equals(b.getName())) {
        return true;
      }
    }
    return false;
  }

  // methodes reste
  public void shuffledCard() {
    ArrayList<Card> cardsRest = new ArrayList<Card>();
    while (this.rest.size() > 0) {
      int index = (int) (Math.random() * this.rest.size()-1);
      Card removedCard = this.rest.get(index);
      this.rest.remove(index);
      cardsRest.add(removedCard);
    }
    this.rest = cardsRest;
    System.out.println("Shuffled Cards" + cardsRest);
  }

  public Card pickCardRest() {
    int index = (int) (Math.random() * this.rest.size());
    Card thisOne = this.rest.get(index);
    this.rest.remove(index);
    return thisOne;
  }

  public void addCardRest(Card card) {
    this.rest.add(card);
  }

  public void removeCardRest(Card card) {
    this.rest.remove(card);
  }

  // methodes main
  public void addCardHand(Card card) {
    this.hand.add(card);
  }

  public void removeCardHand(Card card) {
    this.hand.remove(card);
  }

  public int getAttackHand() {
    int attack = 0;
    for (int i = 0; i < this.hand.size(); i++) {
      attack = this.hand.get(i).getAttack() + attack;
    }
    return attack;
  }

  public int getWisdomHand() {
    int wisdom = 0;
    for (int i = 0; i < this.hand.size(); i++) {
      wisdom = this.hand.get(i).getWisdom() + wisdom;
    }
    return wisdom;
  }

  public int getCoinHand() {
    int coin = 0;
    for (int i = 0; i < this.hand.size(); i++) {
      coin = this.hand.get(i).getCoin() + coin;
    }
    return coin;
  }
}