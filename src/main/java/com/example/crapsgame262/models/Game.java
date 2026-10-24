package com.example.crapsgame262.models;

public class Game {

    private int shot;
    private int point;
    private int gamesWon;
    private int gamesLost;

    public Game() {
        reset();
    }

    public void reset() {
        shot = 0;
        point = 0;
        gamesWon = 0;
        gamesLost = 0;
    }

    public void play(int diceOne, int diceTwo) {
        shot = diceOne + diceTwo;

        if (point == 0) {
            // Come-out roll
            if (shot == 7 || shot == 11) {
                gamesWon++;
            } else if (shot == 2 || shot == 3 || shot == 12) {
                gamesLost++;
            } else {
                point = shot;
            }
        } else {
            // Point is established
            if (shot == point) {
                gamesWon++;
                point = 0;
            } else if (shot == 7) {
                gamesLost++;
                point = 0;
            }
        }
    }

    public int getShot() {
        return shot;
    }

    public void setShot(int shot) {
        this.shot = shot;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }
}
