package Affichage.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class MainAff extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        try{
        Parent root = FXMLLoader.load(getClass().getResource("../Uti/fxml/start.fxml"));
        stage.setTitle("Volfyirion");
        stage.setScene(new Scene(root));
        stage.show();
    }catch(Exception e){
        e.printStackTrace();
    }
}
    public static void main(String[] args) {
        launch(args);
    }
 }
