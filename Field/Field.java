// Faire EndTurn et StartTurn

package Field;

import Field.Neutral.*;
import Field.Player.*;
import Field.Player.City.*;
import Using.Card.*;
import Using.IdPlayer.*;
import java.util.ArrayList;

public class Field {
  private Neutral neutralField;
  private Player p1;
  private Player p2;

  public Field(String namePlayer1, String namePlayer2, City city8Player1, City city9Player1, City city10Player1,
      City city8Player2, City city9Player2, City city10Player2, ArrayList<Card> market_pile,
      ArrayList<Wonder> wonders_pile, ArrayList<Protector> protectors, ArrayList<Normal> normals,
      ArrayList<Building> buildings) {
    p1 = new Player(IdPlayer.P1, true, namePlayer1, city8Player1, city9Player1, city10Player1, protectors, normals,
        buildings);
    p2 = new Player(IdPlayer.P2, false, namePlayer2, city8Player2, city9Player2, city10Player2, protectors, normals,
        buildings);
    neutralField = new Neutral(market_pile, wonders_pile);
  }

  public Player getPlayer1() {
    return this.p1;
  }

  public Player getPlayer2() {
    return this.p2;
  }

  public Neutral getNeutral() {
    return this.neutralField;
  }

  public void endTurn() {
    if (this.p1.getHisTurn()){
      this.p1.unmakeHand();
      this.p2.makeHand();
      this.p1.endTurnRessources();
      this.p1.endTurnBonus();
      this.p1.setHisTurn(false);
      this.p2.setHisTurn(true);
    } else {
      this.p2.unmakeHand();
      this.p1.makeHand();
      this.p2.endTurnRessources();
      this.p2.endTurnBonus();
      this.p2.setHisTurn(false);
      this.p1.setHisTurn(true);
    }
  }

  public Player getHisTurn(){
    if(p1.getHisTurn()){
      return p1;
    } else {
      return p2;
    }
  }
  public void buyCard(Card c, Player p) {
    if (p.buyCard(c)) {
      this.neutralField.getMarket().removeCardMarket(c);
    }
  }

  public void buyWonder(Wonder w, Player p) {
    if (p.buyWonder(w)) {
      this.neutralField.getCave().removeWonderCave(w);
    }
  }

  public void attackCity(City city, Player attack) {
    if (city.defenceValue() > attack.getAttack()) {
      System.out.println("You don't have enough attack to attack this city");
    } else if (city.haveProtector()) {
      if (city.getProtector().getBonus() != "e_mercenary"){
        attack.setAttack(-city.defenceValue());
        city.removeProtector();
      }
      else {
        attack.setAttack(-city.defenceValue());
        city.removeProtector();
        city.removeBuilding();
      }
    } else {
      attack.setAttack(-city.defenceValue());
      city.setIsStanding(false);;
      city.removeBuilding();
    }
  }

  public boolean moveVolfyirionToCity(City c, Player p) {
    return this.neutralField.getVolfyirion().moveToCityFromHisPlace(c, p);
  }

  public boolean moveVolfyirionToBase(City c, Player p) {
    return this.neutralField.getVolfyirion().moveToHisPlaceFromCity(c, p);
  }

  public boolean moveVolfyirionCityToCity(City c, Player p) {
    return this.neutralField.getVolfyirion().moveToCityEnnemie(p, c);
  }

  public void attackVolfyirion(Player p){
    if (this.neutralField.getVolfyirion().getIsAlive()){
      if (p.getAttack() >= 16){
        this.neutralField.volfyirionDead(p);
      }
      else {
      System.out.println("You don't have enought attack to defeat Volfyirion");
      }
    }
    else {
      System.out.println("Volfyirion is already dead");

    }
  }
}
