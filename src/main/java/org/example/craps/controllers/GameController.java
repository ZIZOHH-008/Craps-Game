package org.example.craps.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.craps.models.Player;


public class GameController {

    @FXML private Label nicknameLabel;
    private Player currentPlayer;


    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer){
        this.currentPlayer = currentPlayer;
        nicknameLabel.setText(this.getCurrentPlayer().getNickname());
    }

}
