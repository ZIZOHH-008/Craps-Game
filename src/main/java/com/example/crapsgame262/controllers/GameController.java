package com.example.crapsgame262.controllers;

import com.example.crapsgame262.models.Dice;
import com.example.crapsgame262.models.Game;
import com.example.crapsgame262.models.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GameController {

    private Player currentPlayer;

    private Game currentGame;

    private final Alert info = new Alert(Alert.AlertType.INFORMATION);

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

    public void instructions() {
        info.setHeaderText("Instrucciones");
        info.setContentText(
                "1. El juego inicia cuando hace su lanzamiento o tiro de salida.\n" +
                "2. Si sacas un 7 u 11, ganas automáticamente.\n" +
                "3. Si sacas un 2,3 o 12, es un \"craps\" y pierdes.\n" +
                "4. Cualquier otro número(4,5,6,8,9,10) establece el \"punto\".\n" +
                "5. Si logras sacar el \"punto\" antes de sacar un 7, ganas. Si sacas un 7 antes del punto, pierdes."
        );
        info.show();
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
        if (!currentGame.isPointOn()) {
            pointLabel.setText("-");
        } else {
            pointLabel.setText(String.valueOf(currentGame.getPoint()));
        }
        summaryTextArea.setText(
                currentGame.getMessage() + "\n\n" +
                "Games won: " + currentGame.getGamesWon() + "\n" +
                "Games lost: " + currentGame.getGamesLost()
        );
    }
}
