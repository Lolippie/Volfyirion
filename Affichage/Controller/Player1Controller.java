package Affichage.Controller;


import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.*;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import Using.Card.*;

import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import Field.Field_Creation;
import Using.Card.Wonder;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import Affichage.Main.MyListenerCard;
import Affichage.Main.MyListenerCity;
import Field.Player.City.*;
    
public class Player1Controller {
    private Field_Creation field;
    private MyListenerCard myListenerCard;
    private MyListenerCity myListenerCity;
    @FXML
    private Text Attack;

    @FXML
    private Text Coin;

    @FXML
    private GridPane HandJD;

    @FXML
    private GridPane HandJG;

    @FXML
    private GridPane Market;

    @FXML
    private GridPane MuseumJD;

    @FXML
    private GridPane MuseumJG;

    @FXML
    private Text Wisdom;

    @FXML
    private GridPane cave;

    @FXML
    private GridPane cityJD;

    @FXML
    private GridPane cityJG;

    @FXML
    private Text indication;

    @FXML
    private ImageView initialPlaceVolfy;

    @FXML
    private Button stop;

    @FXML
    private ImageView volfyOnCity10JD;

    @FXML
    private ImageView volfyOnCity10JG;

    @FXML
    private ImageView volfyOnCity8JD;

    @FXML
    private ImageView volfyOnCity8JG;

    @FXML
    private ImageView volfyOnCity9JD;

    @FXML
    private ImageView volfyOnCity9JG;

    @FXML
    void OnCity10JD(ActionEvent event) {

    }

    @FXML
    void OnCity10JG(ActionEvent event) {

    }

    @FXML
    void OnCity8JD(ActionEvent event) {

    }

    @FXML
    void OnCity8JG(ActionEvent event) {

    }

    @FXML
    void OnCity9JD(ActionEvent event) {

    }

    @FXML
    void OnCity9JG(ActionEvent event) {

    }

    @FXML
    void attackVolfyirion(MouseEvent event) {
        this.field.getField().attackVolfyirion(this.field.getField().getHisTurn());
    }

    @FXML
    void stopTurn(ActionEvent event) {
        this.field.getField().endTurn();
        if (this.field.getField().getHisTurn() == this.field.getField().getPlayer1()){
            HandJG.getChildren().clear();
        } else {
            HandJD.getChildren().clear();
        }
        cityJD.getChildren().clear();
        cityJG.getChildren().clear();
        setField(this.field);
    }
   
    @FXML
    void refreshRessources(ActionEvent event) {
        Wisdom.setText(Integer.toString(field.getField().getHisTurn().getWisdom()));
        Attack.setText(Integer.toString(field.getField().getHisTurn().getAttack()));
        Coin.setText(Integer.toString(field.getField().getHisTurn().getCoin()));
    }

    public void setField(Field_Creation f){
        this.field = f;
        this.field.getField().getHisTurn().startTurn();
        Wisdom.setText(Integer.toString(field.getField().getHisTurn().getWisdom()));
        Attack.setText(Integer.toString(field.getField().getHisTurn().getAttack()));
        Coin.setText(Integer.toString(field.getField().getHisTurn().getCoin()));
        this.field.getField().getNeutral().getMarket().makeMarket();
        this.field.getField().getNeutral().getCave().makeCave();
        myListenerCard = new MyListenerCard(){
            public void onClickListener(Card c){
                Wisdom.setText(Integer.toString(field.getField().getHisTurn().getWisdom()));
                Attack.setText(Integer.toString(field.getField().getHisTurn().getAttack()));
                Coin.setText(Integer.toString(field.getField().getHisTurn().getCoin()));
            }
        };
        myListenerCity = new MyListenerCity(){
            public void onClickListener(City c){
                Wisdom.setText(Integer.toString(field.getField().getHisTurn().getWisdom()));
                Attack.setText(Integer.toString(field.getField().getHisTurn().getAttack()));
                Coin.setText(Integer.toString(field.getField().getHisTurn().getCoin()));
            }
        };
        int columnHand = 0;
        int rowHand = 1;
        try {

            for (int i = 0 ; i < this.field.getField().getHisTurn().getDeckPlayer().getHand().size();i++){
                FXMLLoader fxmlLoaderHand = new FXMLLoader();
                fxmlLoaderHand.setLocation(getClass().getResource("../Uti/fxml/cardHand.fxml"));
                AnchorPane anchorPaneHand = fxmlLoaderHand.load();
                HandController handController = fxmlLoaderHand.getController();
                handController.setData(this.field.getField().getHisTurn().getDeckPlayer().getHand().get(i), myListenerCard, this.field);
                if (columnHand == 5){
                    columnHand = 0;
                    rowHand +=1;
                }
                if (this.field.getField().getHisTurn() == this.field.getField().getPlayer1()){
                    HandJD.add(anchorPaneHand, columnHand++, rowHand);
                }
                else {
                HandJG.add(anchorPaneHand, columnHand++, rowHand);
                }
                GridPane.setMargin(anchorPaneHand, new Insets(10));
            };
        } catch (IOException e){
            e.printStackTrace();
        };
            int columnMarket = 0;
            int rowMarket = 1;
        try {
            for (int i = 0 ; i < this.field.getField().getNeutral().getMarket().getMarket().size();i++){
                FXMLLoader fxmlLoaderMarket = new FXMLLoader();
                fxmlLoaderMarket.setLocation(getClass().getResource("../Uti/fxml/cardMarket.fxml"));
                AnchorPane anchorPaneMarket = fxmlLoaderMarket.load();
                MarketController marketController = fxmlLoaderMarket.getController();
                marketController.setData(this.field.getField().getNeutral().getMarket().getMarket().get(i), myListenerCard, this.field);
                Market.add(anchorPaneMarket, columnMarket++, rowMarket);
                GridPane.setMargin(anchorPaneMarket, new Insets(10));
            }
        } catch (IOException e){
            e.printStackTrace();
        };

        try {
            int columnCave = 0;
            int rowCave = 1;
            for (int i = 0 ; i < this.field.getField().getNeutral().getCave().getCave().size();i++){
                FXMLLoader fxmlLoaderCave = new FXMLLoader();
                fxmlLoaderCave.setLocation(getClass().getResource("../Uti/fxml/cardCave.fxml"));
                AnchorPane anchorPaneCave = fxmlLoaderCave.load();
                CaveController caveController = fxmlLoaderCave.getController();
                caveController.setData(this.field.getField().getNeutral().getCave().getCave().get(i), myListenerCard, this.field);
                cave.add(anchorPaneCave, columnCave++, rowCave);
                GridPane.setMargin(anchorPaneCave, new Insets(10));
            }
    } catch (IOException e){
        e.printStackTrace();
    };

    try {
        int columnCity = 0;
        int rowCity = 1;
        for (int i = 0 ; i < this.field.getField().getHisTurn().getCities().size();i++){
            FXMLLoader fxmlLoaderCity = new FXMLLoader();
            fxmlLoaderCity.setLocation(getClass().getResource("../Uti/fxml/City.fxml"));
            AnchorPane anchorPaneCity = fxmlLoaderCity.load();
            CityController CityController = fxmlLoaderCity.getController();
            CityController.setData(this.field.getField().getHisTurn().getCities().get(i), myListenerCity, this.field);
           
           if (this.field.getField().getHisTurn() == this.field.getField().getPlayer1()){
            cityJD.add(anchorPaneCity, columnCity++, rowCity);
           }
           else {
            cityJG.add(anchorPaneCity, columnCity++, rowCity);
           }
            GridPane.setMargin(anchorPaneCity, new Insets(5));
        }

        int columnCityE = 0;
        int rowCityE = 1;
        if (this.field.getField().getHisTurn() == this.field.getField().getPlayer1()){
            for (int i = 0 ; i < this.field.getField().getPlayer2().getCities().size();i++){
                FXMLLoader fxmlLoaderCityE = new FXMLLoader();
                fxmlLoaderCityE.setLocation(getClass().getResource("../Uti/fxml/CityEnnemy.fxml"));
                AnchorPane anchorPaneCityE = fxmlLoaderCityE.load();
                CityEnnemyController cityControllerE = fxmlLoaderCityE.getController();
                cityControllerE.setData(this.field.getField().getPlayer2().getCities().get(i), myListenerCity, this.field);
                cityJG.add(anchorPaneCityE, columnCityE++, rowCityE);
                GridPane.setMargin(anchorPaneCityE, new Insets(5));
            }
        } else {
            for (int i = 0 ; i < this.field.getField().getPlayer1().getCities().size();i++){
                FXMLLoader fxmlLoaderCityE = new FXMLLoader();
                fxmlLoaderCityE.setLocation(getClass().getResource("../Uti/fxml/CityEnnemy.fxml"));
                AnchorPane anchorPaneCityE = fxmlLoaderCityE.load();
                CityEnnemyController cityControllerE = fxmlLoaderCityE.getController();
                cityControllerE.setData(this.field.getField().getPlayer1().getCities().get(i), myListenerCity, this.field);
                cityJD.add(anchorPaneCityE, columnCityE++, rowCityE);
                GridPane.setMargin(anchorPaneCityE, new Insets(5));
            }
        }
        
        for (int i = 0 ; i < this.field.getField().getHisTurn().getMuseum().size();i++){
            FXMLLoader fxmlLoaderMuseum = new FXMLLoader();
            fxmlLoaderMuseum.setLocation(getClass().getResource("../Uti/fxml/wonderMuseum.fxml"));
            AnchorPane anchorPaneMuseum = fxmlLoaderMuseum.load();
            WonderController museumController = fxmlLoaderMuseum.getController();
            museumController.setData(this.field.getField().getHisTurn().getMuseum().get(i), myListenerCity, this.field);
            if (columnHand == 5){
                columnHand = 0;
                rowHand +=1;
            }
           if (this.field.getField().getHisTurn() == this.field.getField().getPlayer1()){
            MuseumJD.add(anchorPaneMuseum, columnCity++, rowCity);
           }
           else {
            MuseumJG.add(anchorPaneMuseum, columnCity++, rowCity);
           }
            GridPane.setMargin(anchorPaneMuseum, new Insets(5));
        }
        if (this.field.getField().getHisTurn() == this.field.getField().getPlayer1()){
            for (int i = 0 ; i < this.field.getField().getPlayer2().getMuseum().size();i++){
                FXMLLoader fxmlLoaderMuseumE = new FXMLLoader();
                fxmlLoaderMuseumE.setLocation(getClass().getResource("../Uti/fxml/wonderMuseumEnnemy.fxml"));
                AnchorPane anchorPaneCityE = fxmlLoaderMuseumE.load();
                WonderControllerEnnemy cityControllerE = fxmlLoaderMuseumE.getController();
                cityControllerE.setData(this.field.getField().getPlayer2().getCities().get(i), myListenerCity, this.field);
                cityJG.add(anchorPaneCityE, columnCityE++, rowCityE);
                GridPane.setMargin(anchorPaneCityE, new Insets(5));
            }
        } else {
            for (int i = 0 ; i < this.field.getField().getPlayer1().getCities().size();i++){
                FXMLLoader fxmlLoaderCityE = new FXMLLoader();
                fxmlLoaderCityE.setLocation(getClass().getResource("../Uti/fxml/CityEnnemy.fxml"));
                AnchorPane anchorPaneCityE = fxmlLoaderCityE.load();
                CityEnnemyController cityControllerE = fxmlLoaderCityE.getController();
                cityControllerE.setData(this.field.getField().getPlayer1().getCities().get(i), myListenerCity, this.field);
                cityJD.add(anchorPaneCityE, columnCityE++, rowCityE);
                GridPane.setMargin(anchorPaneCityE, new Insets(5));
            }
        }

        
} catch (IOException e){
    e.printStackTrace();
};
    }
}
