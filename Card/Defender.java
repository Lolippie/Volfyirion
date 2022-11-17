public class Defender extends Card{
    private int power;
    
    public Defender(String n, int c, Effect_card ef, int coi, int att, int wis, Color col, int p){
        super(n, c, ef, 0, 0, 0, col); // vérifier qu'on peut set à 0 directement ou si il faut forcement set après
        this.power = p;
    }
    
    //methodes
        public int getPower(){
            return this.power;
        }
      public void abstract buyCard(Player p){
            p.setCoin(p.getcoin()-this.coin);
        }
    } 