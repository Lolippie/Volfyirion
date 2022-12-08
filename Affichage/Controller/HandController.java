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
            if (thisCard.getBonus() == "e_saboteur"){
                System.out.println("You can't destory this card !");
            }
            else {
            if (this.field.getField().getHisTurn().getDeckPlayer().isProtector(thisCard) ){
                this.field.getField().getHisTurn().getDeckPlayer().getProtectorFromCard(thisCard).getBonusByDestruct(this.field.getField().getHisTurn());
                this.field.getField().getHisTurn().getDeckPlayer().removeCardHand(thisCard);
                setData(thisCard, myListenerCard, field);
            }
            else if (this.field.getField().getHisTurn().getDeckPlayer().isNormal(thisCard)){
                this.field.getField().getPlayer1().getDeckPlayer().getNormalFromCard(thisCard).getBonusByDestruct(this.field.getField().getHisTurn());
                this.field.getField().getHisTurn().getDeckPlayer().removeCardHand(thisCard);
                setData(thisCard, myListenerCard, field);
            } else if ( this.field.getField().getHisTurn().getCanDestroyCard()){
                this.field.getField().getHisTurn().getDeckPlayer().removeCardHand(thisCard);
                this.field.getField().getHisTurn().setCanDestroyCard(false);
                setData(thisCard, myListenerCard, field);
            }
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
