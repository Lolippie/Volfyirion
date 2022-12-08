package Affichage.Controller;

import Affichage.Main.MyListenerCity;
import Field.Field_Creation;
import Field.Player.City.City;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CityEnnemyController {

    @FXML
    private ImageView buildingCity;

    @FXML
    private ImageView city;

    private MyListenerCity myListenerCity;
    @FXML
    private ImageView protectorCity;

    private City thisCity;

    private Field_Creation field;

    @FXML
    void attack(ActionEvent event) {
        myListenerCity.onClickListener(thisCity);
        this.field.getField().getHisTurn().attackCity(thisCity);
    }

    @FXML
    void attackBuilding(MouseEvent event) {
        if (event.isSecondaryButtonDown()){
            myListenerCity.onClickListener(thisCity);
            if(this.field.getField().getHisTurn().getCanDestroyBuilding()){
                thisCity.removeBuilding();
                this.field.getField().getHisTurn().setCanDestroyBuilding(false);
                setData(thisCity, myListenerCity, field);
            } else {
                System.out.println("You can't do anything");
            }
            
        }
    }

    @FXML
    void attackProtector(MouseEvent event) {
        if (thisCity.getIsStanding()){
            if (event.isSecondaryButtonDown()){
                myListenerCity.onClickListener(thisCity);
                if(this.field.getField().getHisTurn().getCanDestroyProtector()){
                    thisCity.removeProtector();
                    this.field.getField().getHisTurn().setCanDestroyProtector(false);
                    setData(thisCity, myListenerCity, field);
                } 
                else {                
                    System.out.println("You can't do anything");
                }
            }
        }
        else {
            System.out.println("This city is already defeated");
        }
    }

    public void setData(City c, MyListenerCity myListener, Field_Creation f){
        this.thisCity = c;
        this.field = f;
        this.myListenerCity = myListener;
        Image image = new Image(getClass().getResourceAsStream(thisCity.getImgSrc()));
        city.setImage(image);
        if (thisCity.haveBuilding()){
            Image imagebui = new Image(getClass().getResourceAsStream(thisCity.getBuilding().getImgSrc()));
            buildingCity.setImage(imagebui);
        }
        else {
            buildingCity.setImage(null);
        }
        if (thisCity.haveProtector()){
            Image imageprot = new Image(getClass().getResourceAsStream(thisCity.getProtector().getImgSrc()));
            protectorCity.setImage(imageprot);
        }
        else {
            protectorCity.setImage(null);
        }
    }

}
