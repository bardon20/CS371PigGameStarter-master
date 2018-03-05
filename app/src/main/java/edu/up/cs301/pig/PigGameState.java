package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by bardon20 on 3/1/2018.
 */

public class PigGameState extends GameState{

    private int playerID;
    private int playerScore1;
    private int playerScore2;
    private int currentTotal;
    private int currentDieNum;

    //no argument constructor
    public PigGameState() {
        playerID = 0;
        playerScore1 = 0;
        playerScore2 = 0;
        currentTotal = 0;
        currentDieNum = 0;

    }

    //copy constructor
    public PigGameState(PigGameState A){
        playerID = A.playerID;
        playerScore1 = A.playerScore1;
        playerScore2 = A.playerScore2;
        currentTotal = A.currentTotal;
        currentDieNum = A.currentDieNum;
    }


    //getters
    public int getPlayerID(){
        return playerID;
    }
    public int getPlayerScore1(){
        return playerScore1;
    }
    public int getPlayerScore2(){
        return playerScore2;
    }
    public int getCurrentTotalNum(){
        return currentTotal;
    }
    public int getCurrentDieNum(){
        return currentDieNum;
    }


    //setters
    public void setPlayerID(int id){
        this.playerID = id;
    }
    public void setPlayerScore1(int score1){
        this.playerScore1 = score1;
    }
    public void setPlayerScore2(int score2){
        this.playerScore2 = score2;
    }
    public void setCurrenttotal(int total){
        this.currentTotal = total;
    }
    public void setCurrentDieNum(int dieNum){
        this.currentDieNum = dieNum;
    }

}
