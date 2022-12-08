package Field.Player;

import Using.Ressource.*;

import java.util.ArrayList;
import java.util.Arrays;

import Field.Player.Deck.*;
import Field.Player.City.*;
import Using.Card.Wonder;
import Using.Card.Protector;
import Using.Card.Building;
import Using.Card.Normal;
import Using.Card.*;
import Field.Neutral.Volfyirion.*;
import Using.Color.*;
import Using.IdPlayer.*;

public class Player {

  private IdPlayer idPlayer;
  private boolean hisTurn;
  private String namePlayer;
  private Ressource ressources;
  private Deck deckPlayer;
  private boolean killedVolfyirion;
  private ArrayList<City> cities;
  private boolean canDestroyBuilding, canDestroyProtector, canDestroyCard, canMoveVolfyirion;
  private ArrayList<Wonder> museum; // le musée : les merveilles que le joueur possède (actives ou non)

  public Player(IdPlayer idPlayer, Boolean bool, String name, City city8, City city9, City city10, ArrayList<Protector> protectors,
      ArrayList<Normal> normals, ArrayList<Building> buildings) {
    this.idPlayer = idPlayer;
    this.namePlayer = name;
    this.hisTurn = bool;
    this.ressources = new Ressource(0, 0, 0);
    this.deckPlayer = new Deck(protectors, normals, buildings);
    this.killedVolfyirion = false;
    this.cities = new ArrayList<City>(Arrays.asList(city8,city9, city10 ));
    this.museum = new ArrayList<Wonder>();
    this.canDestroyBuilding = false;
    this.canDestroyProtector = false;
    this.canDestroyCard = false; 
    this.canMoveVolfyirion = false;
  }
  public boolean getCanDestroyBuilding(){
    return this.canDestroyBuilding;
  }
  public boolean getCanDestroyProtector(){
    return this.canDestroyProtector;

  }
  public boolean getCanDestroyCard(){
    return this.canDestroyCard;

  }
  public boolean getCanMoveVolfyirion(){
    return this.canMoveVolfyirion;

  }
  public void setCanDestroyBuilding(boolean b){
    this.canDestroyBuilding = b;
  }
  public void setCanDestroyProtector(boolean b){
    this.canDestroyProtector = b;
  }

  public void setCanDestroyCard(boolean b){
    this.canDestroyCard = b;

  }
  public void setCanMoveVolfyirion(boolean b){
    this.canMoveVolfyirion = b ;
  }
  public ArrayList<Wonder> getMuseum(){
    return this.museum;
  }
  // Modalités joueur
  public boolean getHisTurn(){
    return this.hisTurn;
  }
public void setHisTurn(boolean b){
  this.hisTurn = b;
}
  public IdPlayer getIdPlayer() {
    return this.idPlayer;
  }

  public String getName() {
    return this.namePlayer;
  }

  public Deck getDeckPlayer() {
    return this.deckPlayer;
  }

  public void resetAttack() {
    this.ressources.resetAttack(this);
  }

  public void resetWisdom() {
    this.ressources.resetWisdom();
  }

  public void resetCoin() {
    this.ressources.resetCoin();
  }

  // tour
  public void startTurn() {
    this.makeHand();
    this.ressources.setRessourcesByInt(this.deckPlayer.getAttackHand(), this.deckPlayer.getWisdomHand(),
        this.deckPlayer.getCoinHand());
    for (Wonder w : this.museum) {
      if (w.getIsLock() == false) {
        setAttack(w.getAttack());
        setWisdom(w.getWisdom());
        setCoin(w.getCoin());
      }
    }
    this.getComboOfBuildings(this);
    this.getComboOfNormals(this);
  }

  public void endTurnRessources() {
    this.unmakeHand();
    this.ressources.resetAttack(this);
    this.ressources.resetWisdom();
    this.ressources.resetCoin();
  }
  public void endTurnBonus(){
    this.canDestroyBuilding = false;
    this.canDestroyProtector = false;
    this.canDestroyCard = false;
    this.canMoveVolfyirion = false;

  }
  public void attackCity(City c){
    if (c.getProtector() != null && getAttack() >= c.defenceValue()){
      if (c.getProtector().getBonus() == "e_mercenary" && c.getBuilding() != null){
          c.removeBuilding();
      }
      this.ressources.setAttack(-c.defenceValue());
      c.removeProtector();
    } 
    else if(getAttack() >= c.defenceValue()) {
      this.ressources.setAttack(-c.defenceValue());
      if (c.getBuilding() != null){
        c.removeBuilding();
      }
        c.setIsStanding(false);
    }
  }
  public int getAttack() {
    return this.ressources.getAttack();
  }
  public int getWisdom() {
    return this.ressources.getWisdom();
  }

  public int getCoin() {
    return this.ressources.getCoin();
  }

  public boolean getKilledVolfyirion() {
    return this.killedVolfyirion;
  }

  public void setAttack(int att) {
    this.ressources.setAttack(att);
  }

  public void setWisdom(int wis) {
    this.ressources.setWisdom(wis);
  }

  public void setCoin(int coi) {
    this.ressources.setCoin(coi);
  }

  // Cartes joueurs
  public void makeHand() {
    Card card;
    this.deckPlayer.shuffledCard();
    while ((this.deckPlayer.getHand()).size() < 5) {
      card = this.deckPlayer.pickCardRest();
      this.deckPlayer.addCardHand(card);
    }

  }

  public void unmakeHand() {
    while (this.deckPlayer.getHand().size() > 0) {
      this.deckPlayer.addCardRest(this.deckPlayer.getHand().get(0));
      this.deckPlayer.removeCardHand(this.deckPlayer.getHand().get(0));
    }
  }

  public boolean buyCard(Card c) {
    if (this.getCoin() >= c.getCost()) {
      this.setCoin(-c.getCost());
      this.deckPlayer.addCardRest(c);
      return true;
    } else {
      System.out.println("You don't have enought coin to buy this card");
      return false;
    }
  }
  // !!! le retrait de la carte dans le marché se fait dans le terrain

  public void destructCard(Card c) {
    if (this.deckPlayer.isNormal(c)){
      if (this.deckPlayer.getNormalFromCard(c).getComboNor().equals(Normal.ComboNor.saboteur)){
        System.out.println("You can't delete this card !");
      }
    }else {
      this.deckPlayer.removeCardHand(c);
    }
  }

  // Merveilles joueurs
  public boolean buyWonder(Wonder w) {
    if (w.buyCard(this)) {
      this.museum.add(w);
      return true;
    } else {
      return false;
    }
  }

  public void addWonder(Wonder w) {
    this.museum.add(w);
  } // !! enlever la merveille de la cave avant/apres

  public void unlockWonder(Wonder w) { // precondition : pas deja activée + assez de sagesse
    w.setLock(false, this);
  }

  public void lockWonder(Wonder w) { // precondition : pas déjà desactivée + assez de sagesse
    w.setLock(true, this);

  }

  public void destroyWonder(Wonder w) { // possible?
    w.getBonusByDestroyWonder(this);
    this.museum.remove(w);
  }

  // Villes joueurs
  public ArrayList<City> getCities() {
    return this.cities;
  }

  public void killCity(City city) {
    this.cities.remove(city);
  }

  // Protecteurs villes
  public void addProtectorCity(Card c, City city) {
    if (this.deckPlayer.isProtector(c)) {
      if (city.haveProtector() == false) {
        Protector p = this.deckPlayer.getProtectorFromCard(c);
        this.cities.get(this.cities.indexOf(city)).addProtector(p);
        this.deckPlayer.removeCardHand(c);
        
      } else {
        System.out.println("You already have a protector on your city");
      }
    } else {
      System.out.println("This card is not a protector, you can't add it to the city");
    }
  }

  public void removeProtectorCity(City city) {
    city.removeProtector();
  }

  // Batiments villes
  public void addBuildingCity(Card c, City city) {
    if (this.deckPlayer.isBuilding(c)) {
      if (city.haveBuilding() == false) {
        this.deckPlayer.removeCardHand(c);
        Building b = this.deckPlayer.getBuildingFromCard(c);
        this.cities.get(this.cities.indexOf(city)).addBuilding(b);
      } else {
        System.out.println("You already have a building on your city !");
      }
    } else {
      System.out.println("This card is not a building, you can't add it to the city");
    }
  }

  public void removeBuidling(City city) {
    city.removeBuilding();
  }

  public void killVolfyirion(Volfyirion v) {
    if (v.getIsAlive() && this.getAttack() >= 16) {
      this.setAttack(-16);
      v.setIsAlive(false);
      this.setAttack(4);
      this.killedVolfyirion = true;
    }
  }

  // combo des cartes
  public void getComboOfBuildings(Player p) {
    ArrayList<Building> buildings = this.deckPlayer.getBuildings();
    ArrayList<Color> colors = this.foundColor();
    for (Building bui : buildings) {
      if (bui.comboIsActive(colors)) {
        bui.getBonusByCombo(this);
      }
    }
  }

  public void getComboOfNormals(Player p) {
    ArrayList<Normal> normals = this.deckPlayer.getNormals();
    ArrayList<Color> colors = this.foundColor();
    for (Normal nor : normals) {
      if (nor.comboIsActive(colors)) {
        nor.getBonusByCombo(this);
      }
    }
  }

  public ArrayList<Color> foundColor() {
    ArrayList<Color> colors = new ArrayList<Color>();
    for (Card c : this.deckPlayer.getHand()) {
      colors.add(c.getColor());
    }
    for (City c : this.cities) {
      if (c.haveProtector() == true) {
        colors.add(c.getProtector().getColor());
      }
    }
    for (City c : this.cities) {
      if (c.haveBuilding() == true) {
        colors.add(c.getBuilding().getColor());
      }
    }
    return colors;
  }

  // Gagnant
  public void printWinner() {
    System.out.println(this.namePlayer + " is the winner!");
  }

  public boolean gameIsFinished() {
    int ind = 0;
    for (int i = 1 ; i <= cities.size() ; i++){
      if (cities.get(i-1).getIsStanding() != true){
        ind += 1;
      }
    }
    return ind==cities.size();
}
}
