abstract public class Draw_Pile {
    private ArrayList<Card> market_pile;
    private ArrayList<Card> wonders_pile;
  
    public Draw_Pile() {
      this.market_pile = new ArrayList<Card>();
      this.wonders_pile = new Arraylist<Card>();
    }
  
    public Card randomCard(ArrayList<Card> list_c) {
      int pickthisone = (int) (Math.random() * (list_c.size() - 1));
      Card tmp;
      tmp = list_c.get(pickthisone);
      list_c.remove(pickthisone);
      return tmp;
    }
  }