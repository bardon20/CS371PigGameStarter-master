package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    /**
     * This ctor creates a new game state
     */

    PigGameState localState;
    public PigLocalGame() {
        localState = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if(playerIdx == localState.getPlayerID()) {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if(action instanceof PigHoldAction){
            if(localState.getPlayerID() == 0)
            {
                int player1Score = localState.getPlayerScore1()+localState.getCurrentTotalNum();
                localState.setPlayerScore1(player1Score);

            }
            else if(localState.getPlayerID() == 1)
            {
                int player2Score = localState.getPlayerScore2()+localState.getCurrentTotalNum();
                localState.setPlayerScore2(player2Score);
            }
            localState.setCurrenttotal(0);
            localState.setPlayerID((localState.getPlayerID()+1)%2);
            return true;
        }
        else if(action instanceof PigRollAction) {
            Random r = new Random();
            int die = r.nextInt(5) + 1;
            localState.setCurrentDieNum(die);
                if (die != 1) {
                int curTotal = localState.getCurrentTotalNum() + die;
                localState.setCurrenttotal(curTotal);
                return true;
            } else if (die == 1) {
                localState.setCurrenttotal(0);
                    localState.setPlayerID((localState.getPlayerID()+1)%2);
                return true;
            } else {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState copyState = new PigGameState(localState);
        p.sendInfo(copyState);

    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if(localState.getPlayerScore1() >= 50)
        {
            return "player 1 wins. score: "+localState.getPlayerScore1();
        }
        else if (localState.getPlayerScore2() >=50){
            return "player 2 wins. score: "+localState.getPlayerScore2();
        }
        else
        {
            return null;
        }
    }

}// class PigLocalGame
