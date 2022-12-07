package Field.Player.City;

import Using.Card.*;

public class City {
  private String cityName;
  private int defense;
  private Building building;
  private Protector protector;
  private boolean hasVolfyirion;
  private boolean isStanding;
  private String imgSrc;

  // constucteur
  public City(String name, int defense, String img) {
    this.cityName = name;
    this.defense = defense;
    this.building = null;
    this.protector = null;
    this.hasVolfyirion = false;
    this.isStanding = true;
    this.imgSrc = img;
  }

  // les méthodes
  public String getCityName() {
    return this.cityName;
  }
  public String getImgSrc(){
    return this.imgSrc;
  }
  public int getDefense() {
    return this.defense;
  }

  public Building getBuilding() {
    return this.building;
  }

  public Protector getProtector() {
    return this.protector;
  }

  public boolean getHasVolfyirion() {
    return this.hasVolfyirion;
  }

  public void setHasVolfyirion(boolean bl) {
    this.hasVolfyirion = bl;
  }

  public void setBuilding(Building B) {
    this.building = B;
  }

  public void setProtector(Protector p) {
    this.protector = p;
  }

  public boolean getIsStanding() {
    return this.isStanding;
  }

  public void setIsStanding(boolean b) {
    this.isStanding = b;
  }

  // methode pour calculer la défense totale d'une ville
  public int defenceValue() {
    if (this.protector != null) {
      return this.defense + this.protector.getPower();
    } else {
      return this.defense;
    }
  }

  // ajouter un defenseur au ville//
  public void addProtector(Protector prot) {
    this.protector = prot;
  }

  // ajouter un bâtiment dans cette ville
  public void addBuilding(Building build) {
    this.building = build;
  }

  // methode pour savoir si cette ville a déjà un defendeur
  public boolean haveProtector() {
    return (this.protector != null);
  }

  // methode pour savoir si une ville a déjà un bâtiment
  public boolean haveBuilding() {
    return this.building != null;
  }

  public void removeProtector() {
    this.protector = null;
  }

  public void removeBuilding() {
    this.building = null;
  }
}
