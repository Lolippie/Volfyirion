package Field.Neutral.Volfyirion;

import Field.Player.City.*;
import Field.Player.*;

public class Volfyirion {
  private String name;
  private boolean isAlive;
  private City city;

  public Volfyirion() {
    this.name = "volfyrion";
    isAlive = true;
    this.city = null;
  }

  // ------------------------------------------------------------
  public String getName() {
    return this.name;
  }

  public boolean getIsAlive() {
    return this.isAlive;
  }

  public City getCity() {
    return this.city;
  }

  public void setCity(City city) {
    this.city = city;
  }

  public void setIsAlive(boolean b) {
    this.isAlive = b;

  }

  // ----------------------------------------------------------
  public void moveToCityFromHisPlace(City c, Player p) {
    if (this.isAlive && c.getIsStanding()) {
      if (p.getWisdom() >= 8) {
        c.setHasVolfyirion(true);
        this.city = c;
        p.setWisdom(-8);
      } else {
        System.out.println("vous pouvez pas le deplacer, vos ressources sont insuffisantes.");
      }
    }
  }

  public void moveToCity(City c, Player p) {
    if (this.isAlive) {
      if (p.getWisdom() >= 8) {
        p.setWisdom(-8);
        c.setHasVolfyirion(true);
        this.city = c;
      } else {
        System.out.println("vous pouvez pas le deplacer vos ressources sont insuffisantes");
      }
    } else {
      System.out.println("Volfyirion is dead, you can't move it");
    }

  }

  // ---------------------------------------------------------
  public void returnToHisPlace(Player p, City c) {
    if (c.getHasVolfyirion()){
      if (p.getWisdom() >= 8) {
        c.setHasVolfyirion(false);
        p.setWisdom(-8);
        this.city = null;
      }
    }
    }
    

  // ------------------------------------------------------------
  public void destructCity(Player p) {
    for (City c : p.getCities()) {
      if (c.getHasVolfyirion() == true) {
        System.out.println("Your City " + c.getCityName() + " has follen :");
        p.getCities().remove(c);
      }
    }
  }

  // ------------------------------------------------------------
  public void moveToCityEnnemie(Player p, City c) {
    this.returnToHisPlace(p, c);
    this.moveToCityFromHisPlace(c, p);
  }
}
