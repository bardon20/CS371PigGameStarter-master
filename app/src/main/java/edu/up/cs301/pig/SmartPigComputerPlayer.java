package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.infoMsg.GameInfo;

/**
 * Created by bardon20 on 3/1/2018.
 */

public class SmartPigComputerPlayer extends GameComputerPlayer {

    public SmartPigComputerPlayer(String name) {
        super(name);
    }


    protected void receiveInfo(GameInfo info) {

        PigGameState computerState = (PigGameState)info;
        int num = computerState.getCurrentTotalNum();
        if(computerState.getPlayerID() == this.playerNum)
        {
            if(num <= 10){
                PigRollAction myAction = new PigRollAction(this);
                game.sendAction(myAction);
            }
            else
            {
                PigHoldAction myAction = new PigHoldAction(this);
                game.sendAction(myAction);
            }
        }
        else
        {
            return;
        }

    }
}
