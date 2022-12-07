package Affichage.Controller;

import Affichage.Main.MyListenerCard;
import Field.Field_Creation;
import Using.Card.Wonder;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class WonderControllerEnnemy {

    @FXML
    private ImageView img;
    private Wonder wonder;
    private MyListenerCard myListenerCard;
    private Field_Creation field;

    @FXML
    void actionEnnemy(MouseEvent event) {

    }

    public void setData(Wonder w, MyListenerCard myListener, Field_Creation f){
        this.wonder = w;
        this.myListenerCard = myListener;
        this.field = f;
        Image image = new Image(getClass().getResourceAsStream(wonder.getImgSrc()));
        img.setImage(image);
    }
}
