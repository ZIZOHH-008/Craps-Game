package org.example.craps.controllers;

import org.example.craps.models.AlertBox;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.craps.models.Player;
import org.example.craps.views.GameView;

import java.io.IOException;


// Controla los componentes de la vista, PERO NO LA VENTANA COMO TAL
public class WelcomeController {

    @FXML
    private TextField textFieldNickname;


    @FXML
    void onMouseClickedBtnStart(MouseEvent event) {
        String nickname = textFieldNickname.getText();


        if (nickname==""){
            AlertBox alertBox = new AlertBox();
            boolean response = alertBox.showConfirmBox(
                    "Craps Game - Nombre de usuario",
                    "Nombre de usuario",
                    "Debes diligenciar tu nombre de usuario");
        }
        /*
        //Esto era para mostrar una confirmación de juego (otro ejemplo de ventana de que da mensaje
        AlertBox alertBox = new AlertBox();
        boolean response = alertBox.showConfirmBox(
                "Iniciar Juego?",
                "Hola!",
                nickname + ", deseas iniciar una partida?");

        if (response) {
            System.out.println("Nueva partida de " + nickname);
        }
        */

        else{
            GameView gameView = null; //Así como se creó la otra ventana
            try {
                gameView = GameView.getInstance();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Player player = new Player();
            player.setNickname(nickname);

            GameController gameController = gameView.getController();
            gameController.setCurrentPlayer(player);

            gameView.show();

            textFieldNickname.getScene().getWindow().hide(); //En que escena estas? la pasa y la esconde
        }





    }
}
