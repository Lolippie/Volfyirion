package Affichage.Controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;
import Affichage.Main.MyListener;
import Using.Card.Building;

public class BuildingController {
    private MyListener myListener;
    @FXML
    private ImageView Building;
    private Building buildingCard;
    @FXML
    void destroyBuilding(MouseEvent event) {
        if (event.getButton() == MouseButton.SECONDARY){
            myListener.onClickListener(buildingCard);
            buildingCard.getCity().removeBuilding();
            buildingCard.setCity(null);
            Building.setImage(null);
        }
        
    }
    
    public void setDataBuilding(Building card, MyListener thisListener){
        this.buildingCard = card;
        this.myListener = thisListener;
        Image image = new Image(getClass().getResourceAsStream(card.getImgSrc()));
        Building.setImage(image);
    }
}
