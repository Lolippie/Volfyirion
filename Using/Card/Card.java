//import /Ressources/Ressources.java;
package Using.Card;

import Using.Ressource.Ressource;
import Using.Color.*;

public abstract class Card {
  protected String name;
  protected int cost;
  protected String bonus;
  protected Ressource ressources;
  protected Color color;
  protected String imgSrc;

  // essayer de garder coin/attack/wisdom dans le même ordre pour simplifier
  public Card(String name, int cost, String bonus, int coin, int attack, int wisdom, Color color,String img) {
    this.name = name;
    this.cost = cost;
    this.bonus = bonus;
    this.ressources = new Ressource(coin, attack, wisdom);
    this.color = color;
    this.imgSrc=img;
  }

  // methodes
  public String getName() {
    return this.name;
  }

  public int getCost() {
    return this.cost;
  }

  public String getBonus() {
    return this.bonus;
  }

  public int getCoin() {
    return this.ressources.getCoin();
  }

  public int getAttack() {
    return this.ressources.getAttack();
  }

  public int getWisdom() {
    return this.ressources.getWisdom();
  }

  public Color getColor() {
    return this.color;
  }
  public String getImgSrc(){
    return this.imgSrc;
  }
}