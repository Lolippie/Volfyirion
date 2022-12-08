package Affichage.Controller;

import Affichage.Main.MyListenerCard;
import Field.Field_Creation;
import Using.Card.Card;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MarketController {
    private Card thisCard;
    private Field_Creation field;
    private MyListenerCard myListenerCard;
    private boolean alreadyBought = false;
    @FXML
    private ImageView img;

    @FXML
    void clickMarket(MouseEvent event) {

        if (event.isPrimaryButtonDown()){
            myListenerCard.onClickListener(thisCard);
            if (!alreadyBought){
                if (thisCard.getName() == "Saboteur"){
                    if (this.field.getField().getHisTurn() == this.field.getField().getPlayer1()){
                        if (this.field.getField().getHisTurn().getCoin()>=thisCard.getCoin()){
                            this.field.getField().getHisTurn().setCoin(-thisCard.getCoin());
                            this.field.getField().getPlayer2().getDeckPlayer().addCardRest(thisCard);
                            this.field.getField().getNeutral().getMarket().removeCardMarket(thisCard);
                        }
                    }
                    else {
                        if (this.field.getField().getHisTurn().getCoin() >= thisCard.getCoin()){
                            this.field.getField().getHisTurn().setCoin(-thisCard.getCoin());
                            this.field.getField().getPlayer1().getDeckPlayer().addCardRest(thisCard);
                            this.field.getField().getNeutral().getMarket().removeCardMarket(thisCard);
                        }
                    }
                }
                else {
                        this.field.getField().buyCard(thisCard, this.field.getField().getHisTurn());   
                }
                alreadyBought= true;
            }
            else {
                System.out.println("You can't bought this card 2 times in a row");
            }
        }
        if (event.isSecondaryButtonDown()){
            myListenerCard.onClickListener(thisCard);
            if (!alreadyBought){
                if (this.field.getField().getHisTurn().getWisdom() >= 2){
                    this.field.getField().getHisTurn().setWisdom(-2);
                    this.field.getField().getNeutral().getMarket().removeCardMarket(thisCard);
                    thisCard = this.field.getField().getNeutral().getMarket().randomCard();
                    this.field.getField().getNeutral().getMarket().addCardMarket(thisCard);
                    setData(thisCard, myListenerCard, field);
                }
            }
            else{
                System.out.println("You can't remove a card that you bought");
            }
        }
    }
    
    public void setData(Card c, MyListenerCard myListener, Field_Creation f){
        this.thisCard = c;
        this.field = f;
        this.myListenerCard = myListener;
        Image image = new Image(getClass().getResourceAsStream(c.getImgSrc()));
        img.setImage(image);
    }
}
