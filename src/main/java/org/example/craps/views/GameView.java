package org.example.craps.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.craps.controllers.GameController;

import java.io.IOException;

//Esta clase es una ventana porque hereda de Stage
public class GameView extends Stage {



    private GameController controller;



    public GameView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/org/example/craps/game-view.fxml")
        );

        //Carga el controlador del view
        Parent root = fxmlLoader.load();
        controller = fxmlLoader.getController(); //Obtener controlador desde el fxml

        Scene scene = new Scene(root);

        //Puede usar los métodos de stage directamente
        setTitle("Crap Game");
        setScene(scene);
        setResizable(false);
    }


    public GameController getController() {
        return controller; //Un getter
    }

    public static GameView getInstance() throws IOException{
        if (GameViewHolder.INSTANCE == null){
            GameViewHolder.INSTANCE = new GameView(); //Si es nula la instancia, crea la ventana (instancia)
        }
        return GameViewHolder.INSTANCE;
    }


    //Clase interna estática que NO e instancia y NO cambia su valor durante el programa
    // Holder es porque es una clase auxiliadora
    private static class GameViewHolder{
        private static GameView INSTANCE = null;
    }

}