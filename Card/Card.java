//import /Ressources/Ressources.java;
public abstract class Card{
	protected String name;
	protected int cost;
    protected Activation_Card activation;
	protected Card_Effect effect; // effet a faire
	protected Ressources ressource;
	public enum Color {red, magenta, cyan, grey};
	protected Color color;
    
    // essayer de garder attack/wisdom/coin dans le même ordre pour simplifier
	public Card(String n, int c, Card_Effect ef, int coi, int att, int wis, Color col){
		this.name = n;
		this.cost = c;
		this.effect = ef;
		this.ressource = new Ressources(coi, att, wis);
		this.color = col;
	}
    
	// methodes
	public String getName(){
		return this.name;
	}
    
	public int getCost(){
		return this.cost;
	}
    
	public Effect_card getEffect(){
		return this.effect;
	}
    
	public int getAttack(){
		return this.ressource.getAttack();
	}
    
  public int getCoin(){
		return this.ressource.coin();
	}
    
  public int getWisdom(){
		return this.ressource.getAttack();
	}
    
  public Color getColor(){
        return this.color;
  }

  public void abstract buyCard(Player p){}
}
