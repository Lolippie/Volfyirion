public class Normal extends Card {
    public Normal (String n, int c, Effect_card ef, int coi, int att, int wis) {
        super(n, c, ef, coi, att, wis); 
    }
    public void abstract buyCard(Player p){
        p.setCoin(p.getcoin()-this.coin);
    }

}
//attack_defence(int att , int def){
//  j.setattak(att);
//  j.setDefence(def);}