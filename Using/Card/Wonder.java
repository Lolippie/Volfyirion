// !!! L'affichage ne se fait que dans un static main et pas dans les classes
// !!! destroyWonder : detruire la carte : comment faire sans le clique pour detruire un batiment, tuer un protector ou bouger volfyirion ?
package Using.Card;

import Using.Buy_Card.*;
import Field.Player.*;
import Using.Color.*;
public class Wonder extends Card implements Buy_Card {
  private boolean lock;

  public Wonder(String name, int cost, String bonus, int coin, int attack, int wisdom, Color color, String img) {
    super(name, cost, bonus, coin, attack, wisdom, color, img);
    this.lock = true;
  }

  public boolean buyCard(Player p) {
    if (p.getAttack() >= this.cost) {
      p.setAttack(-this.cost);
      return true;
    } else {
      System.out.println("You don't have enought attack to buy this wonder");
      return false;
    }
  }

  public boolean getIsLock() {
    return this.lock;
  }

  public void setLock(boolean b, Player p) {
    if (p.getWisdom() >= this.cost) {
      this.lock = b;
      p.setWisdom(-(this.cost));
    } else {
      System.out.println("You don't have enought widsom to lock/unlock this wonder");
    }
  }

  public void getBonusByDestroyWonder(Player player) {
    String firstStep = this.bonus.split("_")[1];
    if (firstStep.equals("bonus")) {
      String secondStep = this.bonus.split("_")[2];
      if (secondStep.equals("coin")) {
        player.setCoin(Integer.valueOf(this.bonus.split("_")[3]));
      } else if (secondStep.equals("wisdom")) {
        player.setWisdom(Integer.valueOf(this.bonus.split("_")[3]));
      } else {
        player.setAttack(Integer.valueOf(this.bonus.split("_")[3]));
      }
    } 
    else if (firstStep.equals("card")) {
      String secondStep = this.bonus.split("_")[2];
      if (secondStep.equals("draw")) {
        player.getDeckPlayer().addCardHand(player.getDeckPlayer().pickCardRest());
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
}