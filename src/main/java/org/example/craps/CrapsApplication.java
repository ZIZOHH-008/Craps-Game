package org.example.craps;

import org.example.craps.views.WelcomeView;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CrapsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Craps");

        /*
        //Version manual
        stage.setTitle("Craps Game");

        VBox root = new VBox();
        Label lblHello = new Label ("Hello");
        Button btnHello = new Button("Click");



        //Recordar que EventHandler es una interfaz que hereda de EventListener
        //El "new" lleva a una Instancia anonima del evento



        //=============METODOS CON INSTANCIA ANONIMA QUE REACCIONAN A DOS EVENTOS ===============
        btnHello.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Hello");
                System.out.println(event.getSource());
                System.out.println(event.getTarget());
                System.out.println(event.getEventType());
            }
        });


        lblHello.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("World");
                System.out.println(event.getSource());
                System.out.println(event.getTarget());
                System.out.println(event.getEventType());
            }
        });


        root.getChildren().add(lblHello);
        root.getChildren().add(btnHello);

        Scene scene = new Scene(root, 200, 200);

        stage.setScene(scene);
        stage.show();
        */

        // Un stage solo puedo tener UNA ESCENA; esta a su vez tiene un contenedor principal.
        //En este caso, GridBox


        /*
        //Version con Scene builder
        stage.setTitle("Craps Game");

        FXMLLoader fxmlLoader = new FXMLLoader(CrapsApplication.class.getResource("/org/example/craps/welcome-view.fxml"));

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

        //En las diapositivas ponen acciones diferentes
         */




        WelcomeView welcomeView = WelcomeView.getInstance(); //Obtiene una instancia
        welcomeView.show();
        //Necesitamos que SIEMPRE sea la misma ventana; por eso debemos aplicar el patrón de diseño simple
        //Lo anterior es por si tenemos datos que siempre debemos mantener
    }
}




