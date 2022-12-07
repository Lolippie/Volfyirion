// !!! getBonusByCombo : comment faire avec les interactions de la carte avec le reste ? demander le nom de la ville ? du Protecteur ? Ou cliquer dessus ? 
// !!! getBonusByDistruct : verifier que ce soit bien un destruct et pas
package Using.Card; 
import Using.Bonus.*;
import Using.Buy_Card.*;
import Field.Player.*;
import Using.Color.*;
import java.util.ArrayList;
// !!! getBonusByCombo : comment faire avec les interactions de la carte avec le reste ? demander le nom de la ville ? du Protecteur ? Ou cliquer dessus ? 
// !!! getBonusByDistruct : verifier que ce soit bien un destruct et pas 
public class Normal extends Card implements Bonus,Buy_Card{
  public enum ComboNor{magenta, cyan, red, cyan_red, red_magenta, cyan_magenta, red_red, destruct, saboteur, none};
private ComboNor combos;

public Normal(String name, int cost, ComboNor combo, String bonus, int coin, int attack, int wisdom, Color color, String img) {
  super(name, cost, bonus, coin, attack, wisdom, color, img);
  this.combos = combo;
}

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

public ComboNor getComboNor(){
  return this.combos;
}

public boolean buyCard(Player p) {
  if (p.getCoin() >= this.cost) {
    p.setCoin(p.getCoin() - this.cost);
    return true;
  } else {
    System.out.println("You don't have enought coin to buy this card");
    return false;
  }
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
  return (this.combos.equals(ComboNor.red_red) && r >= 2) || (this.combos.equals(ComboNor.cyan) && c >= 1)
      || (this.combos.equals(ComboNor.red) && r >= 1) || (this.combos.equals(ComboNor.red_magenta) && r >= 1 && m >= 1)
      || (this.combos.equals(ComboNor.cyan_magenta) && c >= 1 && m >= 1) || (this.combos.equals(ComboNor.cyan_red) && r >= 1 && c >= 1) || (this.combos.equals(ComboNor.magenta) && m >= 1);
}

// e_bonus_attack_2_wisdom_2
public void getBonusByCombo(Player player) {
  if (this.combos != ComboNor.destruct) {
    String firstStep = this.bonus.split("_")[1];
    if (firstStep.equals("bonus") && this.bonus != "null") {
      if (this.bonus.length() < 16) {
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
        for (int i = 1; i <= Integer.valueOf(this.bonus.split("_")[3]); i++) {
          player.getDeckPlayer().addCardHand(player.getDeckPlayer().pickCardRest());
        }
      }
    }
  }
}

public void getBonusByDestruct(Player player) {
  String firstStep = this.bonus.split("_")[1];
  if (this.combos == ComboNor.destruct && this.bonus != "null") {
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
          } 
          else if (thirdStep.equals("attack")) {
            player.setAttack(Integer.valueOf(this.bonus.split("_")[5]));
          } 
          else {
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
    else if(firstStep.equals("bat")){
      player.setCanDestroyBuilding(true);
    }
    else if (firstStep.equals("kill")){
      player.setCanDestroyProtector(true);
    }
    else if (firstStep.equals("move")){
      player.setCanDestroyProtector(true);
    }
  } 
  else {
    System.out.println("This card does nothing");
  }
  }
}