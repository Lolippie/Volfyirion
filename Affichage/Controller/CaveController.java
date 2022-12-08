package Affichage.Controller;

import Affichage.Main.MyListenerCard;
import Field.Field_Creation;
import Using.Card.Wonder;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CaveController {

    @FXML
    private ImageView caveImg;
    private Wonder thisWonder;
    private Field_Creation field;
    private MyListenerCard myListenerCard;

    @FXML
    void buyCard(MouseEvent event) {
        if(this.field.getField().getNeutral().getVolfyirion().getIsAlive()){
            boolean alreadyBought = false;
            myListenerCard.onClickListener(thisWonder);

            if (!alreadyBought){
                if (this.field.getField().getHisTurn().getAttack() >= thisWonder.getCost()){
                    this.field.getField().buyWonder(thisWonder, this.field.getField().getHisTurn());
                    caveImg.setImage(null);
                    alreadyBought= true;
                }
            }
            else {
                System.out.println("You can't bought this card 2 times in a row");
            }
        }
        
        else {
            System.out.println("Volfyirion is dead !");
        }
    }

    public void setData(Wonder w, MyListenerCard myListener, Field_Creation f){
        this.thisWonder = w;
        this.field = f;
        this.myListenerCard = myListener;
        if (thisWonder== null){
            caveImg.setImage(null);
        }
        Image image = new Image(getClass().getResourceAsStream(w.getImgSrc()));
        caveImg.setImage(image);
    }
}
