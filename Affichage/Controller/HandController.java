package Affichage.Controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import Using.Card.*;
import Affichage.Main.MyListenerCard;
import Field.Field_Creation;
public class HandController {

    @FXML
    private ImageView Card;
    private MyListenerCard myListenerCard;
    private Field_Creation field; 
    private Card thisCard;
    @FXML
    void clickHand(MouseEvent event) {
        if (event.isSecondaryButtonDown()){
            myListenerCard.onClickListener(thisCard);
            if (this.field.getField().getPlayer1().getDeckPlayer().isBuilding(thisCard)){
            }
            else if (this.field.getField().getPlayer1().getDeckPlayer().isProtector(thisCard) ){
                this.field.getField().getPlayer1().getDeckPlayer().getProtectorFromCard(thisCard).getBonusByDestruct(this.field.getField().getHisTurn());
                this.field.getField().getHisTurn().getDeckPlayer().removeCardHand(thisCard);
                setData(thisCard, myListenerCard, field);
            }
            else if (this.field.getField().getPlayer1().getDeckPlayer().isNormal(thisCard)){
                this.field.getField().getPlayer1().getDeckPlayer().getNormalFromCard(thisCard).getBonusByDestruct(this.field.getField().getHisTurn());
                this.field.getField().getHisTurn().getDeckPlayer().removeCardHand(thisCard);
                setData(thisCard, myListenerCard, field);
            }
        }
    }

    public void setData(Card c, MyListenerCard myListener, Field_Creation f){
        this.thisCard = c;
        this.field = f;
        this.myListenerCard = myListener;
        Image image = new Image(getClass().getResourceAsStream(c.getImgSrc()));
        Card.setImage(image);
    }
}
