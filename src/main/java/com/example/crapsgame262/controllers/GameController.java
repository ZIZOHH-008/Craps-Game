package com.example.crapsgame262.controllers;

import com.example.crapsgame262.models.Dice;
import com.example.crapsgame262.models.Game;
import com.example.crapsgame262.models.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GameController {

    private Player currentPlayer;

    private Game currentGame;

    @FXML
    private ImageView dice1ImageView;

    @FXML
    private ImageView dice2ImageView;

    @FXML
    private Label nicknameLabel;

    @FXML
    private Label dropLabel;

    @FXML
    private Label pointLabel;

    @FXML
    private TextArea summaryTextArea;

    @FXML
    public void initialize() {
        currentGame = new Game();
        updateGameView();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        nicknameLabel.setText(this.currentPlayer.getNickname());

        currentGame = new Game();
        updateGameView();
    }

    @FXML
    void onMouseClickedDropButton(MouseEvent event) {
        Dice dice1 = new Dice();
        int dice1Value = dice1.roll();

        dice1ImageView.setImage(
                new Image(
                        getClass().getResourceAsStream(
                                dice1.getImagePath()
                        )
                )
        );

        Dice dice2 = new Dice();
        int dice2Value = dice2.roll();

        dice2ImageView.setImage(
                new Image(
                        getClass().getResourceAsStream(
                                dice2.getImagePath()
                        )
                )
        );

        currentGame.play(dice1Value, dice2Value);
        updateGameView();
    }

    private void updateGameView() {
        dropLabel.setText(String.valueOf(currentGame.getShot()));
        pointLabel.setText(String.valueOf(currentGame.getPoint()));
        summaryTextArea.setText(
                "Games won: " + currentGame.getGamesWon() + "\n" +
                "Games lost: " + currentGame.getGamesLost()
        );
    }
}
