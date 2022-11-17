public class Wonders extends Card {
    public Wonders(String n, int c, Effect_card ef, int coi, int att, int wis) {
        super(n, c, ef, coi, att, wis);
    }

    public void buyCard(Player p){
        p.setAtt(p.getAtt()-this.att);
    }
}
