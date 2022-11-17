public class Building extends Card {
    public Building(String n, int c, Effect_card ef, int coi, int att, int wis) {
        super(n, c, ef, coi, att, wis); 
    }
  public void abstract buyCard(Player p){
        p.setCoin(p.getcoin())-this.coin);
    }
  
}