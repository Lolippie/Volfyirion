package Using.Card;

import Using.Buy_Card.*;
import Using.Card.Protector;
import Field.Player.*;
import Field.Player.City.*;
import Using.Color.*;

public class Protector extends Card implements Buy_Card {
  private int power;
  private City city;

  public Protector(String name, int cost, String bonus, int power, Color color, String img) {
    super(name, cost, bonus, 0, 0, 0, color, img);
    this.power = power;
    this.city = null;
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

  public int getPower() {
    return this.power;
  }

  public City getCity() {
    return this.city;
  }

  public void setCity(City city) {
    this.city = city;
  }

  public boolean buyCard(Player p) {
    if (p.getCoin() >= this.cost) {
      p.setCoin(-this.cost);
      return true;
    } else {
      System.out.println("You don't have enought coin to buy this card");
      return false;
    }
  }

  public void getBonusByDestruct(Player player) {
    String firstStep = this.bonus.split("_")[1];
    if (firstStep.equals("bonus")) {
      if (this.bonus.length() <= 16) {
        String secondStep = this.bonus.split("_")[2];
        if (secondStep.equals("coin")) {
          player.setCoin(Integer.valueOf(this.bonus.split("_")[3]));
        } else if (secondStep.equals("wisdom")) {
          player.setWisdom(Integer.valueOf(this.bonus.split("_")[3]));
        } else {
          player.setAttack(Integer.valueOf(this.bonus.split("_")[3]));
        }
      } else {
        String secondStep = this.bonus.split("_")[2];
        String thirdStep = this.bonus.split("_")[4];

        if (secondStep.equals("coin")) {
          player.setCoin(Integer.valueOf(this.bonus.split("_")[3]));

          if (thirdStep.equals("coin")) {
            player.setCoin(Integer.valueOf(this.bonus.split("_")[5]));
          } else if (thirdStep.equals("attack")) {
            player.setAttack(Integer.valueOf(this.bonus.split("_")[5]));
          } else {
            player.setWisdom(Integer.valueOf(this.bonus.split("_")[5]));
          }
        } else if (secondStep.equals("attack")) {
          player.setAttack(Integer.valueOf(this.bonus.split("_")[3]));
          if (thirdStep.equals("coin")) {
            player.setCoin(Integer.valueOf(this.bonus.split("_")[5]));
          } else if (thirdStep.equals("attack")) {
            player.setAttack(Integer.valueOf(this.bonus.split("_")[5]));
          } else {
            player.setWisdom(Integer.valueOf(this.bonus.split("_")[5]));
          }
        } else {
          player.setWisdom(Integer.valueOf(this.bonus.split("_")[3]));
          if (thirdStep.equals("coin")) {
            player.setCoin(Integer.valueOf(this.bonus.split("_")[5]));
          } else if (thirdStep.equals("attack")) {
            player.setAttack(Integer.valueOf(this.bonus.split("_")[5]));
          } else {
            player.setWisdom(Integer.valueOf(this.bonus.split("_")[5]));
          }
        }
      }
    } 
  }
}