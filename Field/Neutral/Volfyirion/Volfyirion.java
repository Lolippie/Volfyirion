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
  public boolean moveToCityFromHisPlace(City c, Player p) {
    if (this.isAlive) {
      if (c.getIsStanding()){
        if (p.getWisdom() >= 8 || p.getCanMoveVolfyirion()) {
          if (p.getCanMoveVolfyirion()){
            p.setCanMoveVolfyirion(false);
          } else {
          p.setWisdom(-8);
          }
          c.setHasVolfyirion(true);
          this.city = c;
          return true;
        } else {
          System.out.println("You can't move volfyirion, you don't have enought ressources");
          return false;
        }
      } else {
        System.out.println("This city has already fallen");
        return false;
      }
    }
    else {
      System.out.println("Volfyirion is dead, you can't move it");
      return false;
    }
  }

  public boolean moveToHisPlaceFromCity(City c, Player p) {
    if (p.getWisdom() >= 8 || p.getCanMoveVolfyirion()) {
      c.setHasVolfyirion(false);
      this.city = null;
      if (p.getCanMoveVolfyirion()){
        p.setCanMoveVolfyirion(false);
      } else {
        p.setWisdom(-8);
      }
      return true;
    } else {
      System.out.println("You can't move volfyirion, you don't have enought ressources");
      return false;
    }
  }
  // ---------------------------------------------------------
  public void returnToHisPlace(City c) {
    this.city = null;
    city.setHasVolfyirion(false);
  }
    
    

  // ------------------------------------------------------------
  public void destructCity(Player p) {
    for (City c : p.getCities()) {
      if (c.getHasVolfyirion() == true) {
        System.out.println("Your City " + c.getCityName() + " has follen :");
        c.setIsStanding(false);
        c.removeBuilding();
        c.removeProtector();
        this.city = null;
      }
    }
  }

  // ------------------------------------------------------------
  public boolean moveToCityEnnemie(Player p, City c) {
    return moveToHisPlaceFromCity(this.city, p) && moveToCityFromHisPlace(c, p);
  }
}
