package Affichage.Controller;

import Affichage.Main.MyListenerCard;
import Field.Field_Creation;
import Using.Card.Wonder;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class WonderController {

    @FXML
    private ImageView Card;
    private Wonder wonder;
    private MyListenerCard myListenerCard;
    private Field_Creation field;

    @FXML
    void action(MouseEvent event) {
        if (event.isPrimaryButtonDown()){
            myListenerCard.onClickListener(wonder);
            if(wonder.getIsLock()){
                wonder.setLock(false, this.field.getField().getHisTurn());
                Card.setRotate(0);
            }
            else {
                System.out.println("this wonder is already unlock");
            }
        }
        else if (event.isSecondaryButtonDown()){
            myListenerCard.onClickListener(wonder);
            this.field.getField().getHisTurn().destroyWonder(wonder);
        }
    }
    public void setData(Wonder w, MyListenerCard myListener, Field_Creation f){
        this.wonder = w;
        this.myListenerCard = myListener;
        this.field = f;
        Image image = new Image(getClass().getResourceAsStream(w.getImgSrc()));
        Card.setImage(image);
        if(wonder.getIsLock()){
            Card.setRotate(90);
        }
    }

}
