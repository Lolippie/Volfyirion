package Using.Bonus;
import Field.Player.*;
import java.util.ArrayList;
import Using.Color.*;
public interface Bonus{
    public void getBonusByCombo(Player p);
    public boolean canActivate(int c, int r, int m);
    public boolean comboIsActive(ArrayList<Color> colors);
  }