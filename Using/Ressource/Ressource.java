package Using.Ressource;

import Field.Player.Player;

public class Ressource {
  private int coin;
  private int attack;
  private int wisdom;

  public Ressource(int coin, int attack, int wisdom) {
    this.attack = attack;
    this.wisdom = wisdom;
    this.coin = coin;
  }

  public int getCoin() {
    return this.coin;
  }

  public int getAttack() {
    return this.attack;
  }

  public int getWisdom() {
    return this.wisdom;
  }

  public void setCoin(int coin) {
    this.coin += coin;
  }

  public void setAttack(int attack) {
    this.attack += attack;
  }

  public void setWisdom(int wisdom) {
    this.wisdom += wisdom;
  }

  public void setRessourcesByInt(int attackHand, int wisdomHand, int coinHand) {
    this.setCoin(coinHand);
    this.setAttack(attackHand);
    this.setWisdom(wisdomHand);
  }

  public void setRessourcesByRessource(Ressource r) {
    this.setCoin(r.getCoin());
    this.setAttack(r.getAttack());
    this.setWisdom(r.getWisdom());
  }

  public void resetAttack(Player p) {
    if (p.getKilledVolfyirion()) {
      this.attack = 4;
    } else {
      this.attack = 0;
    }
  }

  public void resetWisdom() {
    this.wisdom = 0;
  }

  public void resetCoin() {
    this.coin = 0;
  }
}
