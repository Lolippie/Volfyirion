package Field.Neutral;
import Field.Neutral.Market.*;
import Field.Neutral.Cave.*;
import Field.Neutral.Volfyirion.*;
import java.util.ArrayList;
import Using.Card.*;
import Field.Player.*;


public class Neutral {
    private Market market;
    private Cave cave;
    private Volfyirion volfyirion;
  
    // construire avant les pioches et donner les pioches
    public Neutral(ArrayList<Card> market_pile, ArrayList<Wonder> wonders_pile) {
      this.market = new Market(market_pile);
      this.cave = new Cave(wonders_pile);
      this.volfyirion = new Volfyirion();
    }
    // modalité
    public Volfyirion getVolfyirion(){
      return this.volfyirion;
    }
  
    public Market getMarket(){
      return this.market;
    }
  
    public Cave getCave(){
      return this.cave;
    }
    // Volfyirion
    public void volfyirionDead(Player p) {
      ArrayList<Wonder> wonders;
      wonders = this.cave.getCave();
      for (int i = 0; i < wonders.size(); i++) {
        p.addWonder(wonders.get(i));
      }
      this.volfyirion.getCity().setHasVolfyirion(false);
      this.volfyirion.setCity(null);
      this.volfyirion.setIsAlive(false);
      this.cave.setIsActive(false);
      p.setAttack(-16);
      p.setKilledVolfyirion(true);
  
    }
  
    // fonction pour marché
    public void makeMarket() {
      this.market.makeMarket();
    }
  
    public void removeCardMarket(Card c) {
      this.market.getMarket().remove(c);
    }
  
    // fonction cave
    public void removeCardCave(Wonder w) {
      this.cave.removeWonderCave(w);
    }
  
    public void makeCave() {
      this.cave.makeCave();
    }
  }
  
