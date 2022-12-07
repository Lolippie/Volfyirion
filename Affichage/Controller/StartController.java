package Affichage.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import Field.Field_Creation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Scene;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
public class StartController implements Initializable{
    private Field_Creation field;
    private Stage stage ;
    private Scene scene;
    private AnchorPane root;
    @FXML
    public void start(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Uti/fxml/Player1.fxml"));
        root =  loader.load();
        Player1Controller player1Controller = loader.getController();
        player1Controller.setField(field);
        
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public void initialize(URL location, ResourceBundle resources){
        this.field = new Field_Creation();
        System.out.println(this.field.getField().getNeutral().getVolfyirion().getName());
        this.field.getField().getNeutral().getMarket().shuffledCard();
        this.field.getField().getNeutral().getCave().shuffledCard();
        this.field.getField().getNeutral().makeMarket();
        this.field.getField().getNeutral().makeCave();
        System.out.println(this.field.getField().getNeutral().getMarket().getMarket().get(0).getImgSrc());
    }

}
