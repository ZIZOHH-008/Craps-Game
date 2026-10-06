package org.example.craps.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

//Esta clase es una ventana porque hereda de Stage
public class WelcomeView extends Stage {


    public WelcomeView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("com/example/crapsgame262/welcome-view.fxml")
        );

        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        setTitle("Crap Game - Bienvenido");
        setScene(scene);
    }

}