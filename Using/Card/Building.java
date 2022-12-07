package Using.Card;

import Using.Buy_Card.*;
import Field.Player.City.*;
import Field.Player.*;
import java.util.ArrayList;
import Using.Color.*;
import Using.Bonus.*;

// !!! getBonusByCombo : comment faire avec les interactions de la carte avec le reste ? la destruction d'une carte au choix ? 
public class Building extends Card implements Bonus, Buy_Card {

  private City city;

  public enum ComboBui {
    cyan_cyan, red_red, cyan, red, red_magenta, cyan_magenta, cyan_red, destruct
  };

  private ComboBui combos;

  public Building(String name, int cost, ComboBui combo, String bonus, int coin, int attack, int wisdom, Color color,
      String img) {
    super(name, cost, bonus, coin, attack, wisdom, color, img);
    this.combos = combo;
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

  public City getCity() {
    return this.city;
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

  public String getImgSource() {
    return this.imgSrc;
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

    }
    return false;
  }

  public boolean comboIsActive(ArrayList<Color> colors) {
    colors.remove(this.color);
    int cyan = 0;
    int magenta = 0;
    int red = 0;
    for (Color color : colors) {
      if (color.equals(Color.cyan)) {
        cyan += 1;
      }
      if (color.equals(Color.red)) {
        red += 1;
      }
      if (color.equals(Color.magenta)) {
        magenta += 1;
      }
    }
    colors.add(this.color);
    return canActivate(cyan, red, magenta);
  }

  public boolean canActivate(int c, int r, int m) {
    return (this.combos.equals(ComboBui.cyan_cyan) && c >= 2) || (this.combos.equals(ComboBui.red_red) && r >= 2)
        || (this.combos.equals(ComboBui.cyan) && c >= 1) || (this.combos.equals(ComboBui.red) && r >= 1)
        || (this.combos.equals(ComboBui.red_magenta) && r >= 1 && m >= 1)
        || (this.combos.equals(ComboBui.cyan_magenta) && c >= 1 && m >= 1)
        || (this.combos.equals(ComboBui.cyan_red) && r >= 1 && c >= 1);
  }

  public void getBonusByCombo(Player player) {
    String firstStep = this.bonus.split("_")[1];
    if (firstStep.equals("bonus") && this.bonus != "null") {
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
    } else if (firstStep.equals("card")) {
      String secondStep = this.bonus.split("_")[2];
      if (secondStep.equals("draw")) {
        for (int i = 0; i < Integer.valueOf(this.bonus.split("_")[3]); i++) {
          player.getDeckPlayer().addCardHand(player.getDeckPlayer().pickCardRest());
        }
      }
      else {
        player.setCanDestroyCard(true);
      }
  }
}
}
