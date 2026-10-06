package org.example.craps.controllers;

import org.example.craps.models.AlertBox;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CrapsController {

    @FXML
    private TextField textFieldNickname;

    @FXML
    void onMouseClickedBtnStart(MouseEvent event) {
        String nickname = textFieldNickname.getText();
        AlertBox alertBox = new AlertBox();
        boolean response = alertBox.showConfirmBox(
                "Iniciar Juego?",
                "Hola!",
                nickname + ", deseas iniciar una partida?");

        if (response) {
            System.out.println("Nueva partida de " + nickname);
        //Planta fdf
        }
    }

}
