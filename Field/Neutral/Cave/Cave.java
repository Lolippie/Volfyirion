package Field.Neutral.Cave;

import Using.Shuffle.*;
import java.util.ArrayList;
import Using.Card.Wonder;

public class Cave implements Shuffle {
  private boolean isActive;
  private ArrayList<Wonder> cave;
  private ArrayList<Wonder> wonders_pile;

  public Cave(ArrayList<Wonder> pile) {
    this.wonders_pile = pile;
    this.cave = new ArrayList<Wonder>();
    this.isActive = true;
  }

  // modalité cave
  public boolean getIsActive() {
    return this.isActive;
  }

  public ArrayList<Wonder> getCave() {
    return this.cave;
  }

  public ArrayList<Wonder> getWondersPile() {
    return this.wonders_pile;
  }

  public void setWondersPile(ArrayList<Wonder> w) {
    this.wonders_pile = w;
  }

  public void setIsActive(boolean b) {
    this.isActive = b;
  }
  // fonctionnalité faire cave

  public Wonder randomCard() {
    int number = (int) (Math.random() * (this.wonders_pile.size() - 1));
    Wonder pickThisOne = this.wonders_pile.get(number);
    this.wonders_pile.remove(pickThisOne);
    return pickThisOne;
  }

  public void makeCave() {
    while (this.cave.size() < 2) {
      Wonder wonder = randomCard();
      this.cave.add(wonder);
    }
  }

  public void removeWonderCave(Wonder w) {
    this.cave.remove(w);
  }

  public void removeWonderPile(Wonder w) {
    this.wonders_pile.remove(w);
  }
  public void shuffledCard() {
    ArrayList<Wonder> wondersCave = new ArrayList<Wonder>();
    while (this.wonders_pile.size() > 0) {
      int index = (int) (Math.random() * (this.wonders_pile.size() - 1));
      Wonder removedWonder = this.wonders_pile.get(index);
      wondersCave.add(removedWonder);
      removeWonderPile(removedWonder);
     
    }
    this.wonders_pile = wondersCave; 
  }
}
