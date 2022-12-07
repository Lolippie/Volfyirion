package Affichage.Controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import Using.Card.Wonder;
import javafx.scene.image.*;

public class WonderController {

    @FXML
    private ImageView Card;

    private Wonder wonder;

    public void setData(Wonder w){
        this.wonder = w;
        Image image = new Image(getClass().getResourceAsStream(wonder.getImgSrc()));
        Card.setImage(image);
    }

}
