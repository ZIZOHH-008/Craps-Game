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
                getClass().getResource("/org/example/craps/welcome-view.fxml")
        );

        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        //Puede usar los métodos de stage directamente
        setTitle("Crap Game - Bienvenido");
        setScene(scene);
        setResizable(false);
    }




    //Patrón singlenton
    public static WelcomeView getInstance() throws IOException{
        if (WelcomeViewHolder.INSTANCE == null){
            WelcomeViewHolder.INSTANCE = new WelcomeView(); //Si es nula la instancia, crea la ventana (instancia)
        }
        return WelcomeViewHolder.INSTANCE;
    }



    //Clase interna estática que NO e instancia y NO cambia su valor durante el programa
    // Holder es porque es una clase auxiliadora
    private static class WelcomeViewHolder{
        private static WelcomeView INSTANCE = null;
    }

}