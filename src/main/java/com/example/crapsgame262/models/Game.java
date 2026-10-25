package com.example.crapsgame262.models;

/**
 * Represents the game logic for Craps.
 * Handles come-out rolls, point phase, win/loss tracking, and game messages.
 * 
 * @author Juan Manuel Parra
 * @author Brian Rodriguez
 * @author Nicolas Martinez
 * @version 1.0
 */
public class Game {

    private int shot;
    private int point;
    private int gamesWon;
    private int gamesLost;
    private String message;

    /**
     * Creates a new Game instance and resets its state.
     */
    public Game() {
        initializeGame();
    }

    /**
     * Initializes the game state to default values.
     */
    private void initializeGame() {
        shot = 0;
        point = 0;
        gamesWon = 0;
        gamesLost = 0;
        message = "Welcome to Craps! Roll the dice to start.";
    }

    /**
     * Checks if a point is currently established.
     * 
     * @return true if a point is set, false if in come-out roll
     */
    public boolean isPointOn() {
        return point > 0;
    }

    /**
     * Processes a roll of two dice according to Craps rules.
     * 
     * <p>Come-out roll (point == 0):</p>
     * <ul>
     *   <li>7 or 11 -> Natural win</li>
     *   <li>2, 3, or 12 -> Craps lose</li>
     *   <li>4, 5, 6, 8, 9, 10 -> Point is established</li>
     * </ul>
     * 
     * <p>Point phase (point > 0):</p>
     * <ul>
     *   <li>Roll equals point -> Win and reset point</li>
     *   <li>Roll == 7 -> Seven out, lose and reset point</li>
     *   <li>Other values -> Continue rolling</li>
     * </ul>
     * 
     * @param diceOne value of first dice
     * @param diceTwo value of second dice
     */
    public void play(int diceOne, int diceTwo) {
        shot = diceOne + diceTwo;

        if (point == 0) {
            // Come-out roll
            if (shot == 7 || shot == 11) {
                gamesWon++;
                message = "Natural " + shot + "! You win! Roll again to start a new round.";
            } else if (shot == 2 || shot == 3 || shot == 12) {
                gamesLost++;
                message = "Craps " + shot + "! You lose! Roll again to start a new round.";
            } else {
                point = shot;
                message = "Point is set to " + point + ". Roll again to hit the point before rolling a 7.";
            }
        } else {
            // Point is established
            if (shot == point) {
                gamesWon++;
                message = "You made the point " + point + "! You win! Roll again to start a new round.";
                point = 0;
            } else if (shot == 7) {
                gamesLost++;
                message = "Seven out! You lose! Roll again to start a new round.";
                point = 0;
            } else {
                message = "Roll " + shot + ". Keep rolling until you hit " + point + " or roll a 7.";
            }
        }
    }

    /**
     * Gets the sum of the last roll.
     * 
     * @return shot value
     */
    public int getShot() {
        return shot;
    }

    /**
     * Sets the shot value.
     * 
     * @param shot sum of dice
     */
    public void setShot(int shot) {
        this.shot = shot;
    }

    /**
     * Gets the current point value.
     * Returns 0 if no point is established (come-out roll).
     * 
     * @return point value, or 0 if not set
     */
    public int getPoint() {
        return point;
    }

    /**
     * Sets the point value.
     * 
     * @param point point value to set
     */
    public void setPoint(int point) {
        this.point = point;
    }

    /**
     * Gets the number of games won.
     * 
     * @return number of wins
     */
    public int getGamesWon() {
        return gamesWon;
    }

    /**
     * Sets the number of games won.
     * 
     * @param gamesWon number of wins
     */
    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    /**
     * Gets the number of games lost.
     * 
     * @return number of losses
     */
    public int getGamesLost() {
        return gamesLost;
    }

    /**
     * Sets the number of games lost.
     * 
     * @param gamesLost number of losses
     */
    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    /**
     * Gets the current game message.
     * 
     * @return message describing game state/result
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the game message.
     * 
     * @param message message to display
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
