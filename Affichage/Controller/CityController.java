package Affichage.Controller;


import Affichage.Main.MyListenerCity;
import Field.Field_Creation;
import Field.Player.City.City;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CityController {
    private City thisCity;
    private Field_Creation field;
    private MyListenerCity myListenerCity;
    @FXML
    private ImageView city;
    @FXML
    private ImageView buildingImg;

    @FXML
    private ImageView protectorImg;

    @FXML
    void setBuilding(MouseEvent event) {
        if (event.isPrimaryButtonDown()){
            myListenerCity.onClickListener(thisCity);
            int i =0;
            if (thisCity.getBuilding() == null) {
                while ( i < (this.field.getField().getHisTurn().getDeckPlayer().getHand().size() -1) && !(this.field.getField().getHisTurn().getDeckPlayer().isBuilding(this.field.getField().getHisTurn().getDeckPlayer().getHand().get(i)))) {
                    i++;
                }
                if (this.field.getField().getHisTurn().getDeckPlayer().isBuilding(this.field.getField().getHisTurn().getDeckPlayer().getHand().get(i))){

                    this.field.getField().getHisTurn().addBuildingCity(this.field.getField().getHisTurn().getDeckPlayer().getHand().get(i), thisCity);
                    setData(thisCity, myListenerCity, field);
                }
            }
        }
    }

    @FXML
    void setProtector(MouseEvent event) {
        int i =0;
        if (event.isPrimaryButtonDown()){
            myListenerCity.onClickListener(thisCity);
            if (thisCity.getProtector() == null) {
                while (i < (this.field.getField().getHisTurn().getDeckPlayer().getHand().size()-1)  &&!(this.field.getField().getHisTurn().getDeckPlayer().isProtector(this.field.getField().getHisTurn().getDeckPlayer().getHand().get(i)))  ) {
                    i++;
                }
                if (this.field.getField().getHisTurn().getDeckPlayer().isProtector(this.field.getField().getHisTurn().getDeckPlayer().getHand().get(i))){
                    this.field.getField().getHisTurn().addProtectorCity(this.field.getField().getHisTurn().getDeckPlayer().getHand().get(i), thisCity);
                    setData(thisCity, myListenerCity, field);
                }
                
            }
        }
        else if (event.isSecondaryButtonDown() && thisCity.getProtector() != null){
            myListenerCity.onClickListener(thisCity);
            if (thisCity.getProtector().getName() != "e_mecernary"){
                thisCity.getProtector().getBonusByDestruct(this.field.getField().getHisTurn());
                this.thisCity.removeProtector();
                buildingImg.setImage(null);
                setData(thisCity, myListenerCity, field);
            }
            else {
                System.out.println("You can't destroy this protector !");
            }
        }
    }
    
    public void setData(City c,MyListenerCity myListener, Field_Creation f){
        this.thisCity = c;
        this.field = f;
        this.myListenerCity = myListener;
        Image imageCity = new Image(getClass().getResourceAsStream(c.getImgSrc()));
        city.setImage(imageCity);
        if (thisCity.haveBuilding()){
            Image imagebui = new Image(getClass().getResourceAsStream(thisCity.getBuilding().getImgSrc()));
            buildingImg.setImage(imagebui);
        }
        else {
            buildingImg.setImage(null);
        }
        if (thisCity.haveProtector()){
            Image imageprot = new Image(getClass().getResourceAsStream(thisCity.getProtector().getImgSrc()));
            protectorImg.setImage(imageprot);
        }
        else {
            protectorImg.setImage(null);
        }

    }

}
