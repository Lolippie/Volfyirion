public class City{
    private String name;
    private int power;
    private Building building;
    private Defender defender;

    public City(String n,int p, Building b, Defender d){
        this.name = n;
        this.power = p;
        this.building = null;
        this.defender = null;
    }
    
    //methodes
  
    String getName(){
        return this.name;
    }
  
    int getPower(){
        return this.power;
    }

    Building getBuilding(){
        return this.building;
    }

    Defender getDefender(){
        return this.defender;
    }

    void setBuilding(Building B){
        this.building = B;  
    }
    
    void setDefender(Defender D){
        this.defender=D;
    }

    //methode pour calculer la défense totale d'une ville
    int defenceValue(){
        return this.power + this.defender.getPower();
    }
}