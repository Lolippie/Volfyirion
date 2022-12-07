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

  public Player endTurn() {
    if (this.p1.getHisTurn()){
      this.p1.unmakeHand();
      this.p2.makeHand();
      this.p1.endTurnRessources();
      this.p1.setHisTurn(false);
      this.p2.setHisTurn(true);
      return p2;
    } else {
      this.p2.unmakeHand();
      this.p1.makeHand();
      this.p2.endTurnRessources();
      this.p2.setHisTurn(false);
      this.p1.setHisTurn(true);
      return p1;
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

  public void attackCity(City city, Player attack, Player defense) {
    if ((defense.getCities().get(defense.getCities().indexOf(city)).getDefense()) > attack.getAttack()) {
      System.out.println("You don't have enough attack to attack this city");
    } else if (defense.getCities().get(defense.getCities().indexOf(city)).haveProtector()) {
      defense.getCities().get(defense.getCities().indexOf(city)).removeProtector();
      attack.setAttack(-(defense.getCities().get(defense.getCities().indexOf(city)).getDefense()));
    } else {

      attack.setAttack(-defense.getCities().get(defense.getCities().indexOf(city)).getDefense());
      defense.getCities().remove(city);
    }
  }

  public void moveVolfyirionToCity(City c, Player p) {
    this.neutralField.getVolfyirion().moveToCity(c, p);
  }

  public void moveVolfyirionToBase(City c, Player p) {
    this.neutralField.getVolfyirion().returnToHisPlace(p, c);
  }

  public void moveVolfyirionCityToCity(City c, Player p) {
    this.neutralField.getVolfyirion().moveToCityEnnemie(p, c);
  }

  public void attackVolfyirion(Player p){
    if (p.getAttack() >= 16){
      this.neutralField.getVolfyirion().setIsAlive(false);
    }
    else {
      System.out.println("You don't have enought attakc to defeat Volfyirion");
    }
  }
}