package edu.wit.comp2000.group25.lists.tests;

import edu.wit.comp2000.group25.lists.PlayerInput;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for the PlayerInput class
 */
public class PlayerInputTests {
    @Test
    public void sumOfAllWagers() {
        PlayerInput pi = new PlayerInput();
        pi.setCurrentWager(100, 1);
        pi.setCurrentWager(150, 2);
        Assert.assertEquals(250, pi.getTotalAmountBet());
    }

    @Test
    public void sumOfNoWagers() {
        PlayerInput pi = new PlayerInput();
        Assert.assertEquals(0, pi.getTotalAmountBet());
    }

    @Test
    public void gotInputWager() {
        PlayerInput pi = new PlayerInput();
        pi.setCurrentWager(100, 0);
        Assert.assertEquals(true, pi.getGotInput());
    }

    @Test
    public void gotInputInsurance() {
        PlayerInput pi = new PlayerInput();
        pi.setCurrentInsurance(100);
        Assert.assertEquals(true, pi.getGotInput());
    }

    @Test
    public void gotInputPlayerTurnDone() {
        PlayerInput pi = new PlayerInput();
        pi.setPlayerTurnDone(true);
        Assert.assertEquals(true, pi.getGotInput());
    }

    @Test
    public void gotInputSetPlayTurn() {
        PlayerInput pi = new PlayerInput();
        pi.setPlayNextMatch(true);
        Assert.assertEquals(true, pi.getGotInput());
    }

    @Test
    public void noInputTest() {
        PlayerInput pi = new PlayerInput();
        Assert.assertEquals(false, pi.getGotInput());
    }

    @Test
    public void setWagerAtIndex() {
        PlayerInput pi = new PlayerInput();
        Assert.assertEquals(-1, pi.getTotalAmountBet(0));
        pi.setCurrentWager(100, 0);
        Assert.assertEquals(100, pi.getTotalAmountBet(0));
    }

    @Test
    public void setCurrentInsurance() {
        PlayerInput pi = new PlayerInput();
        Assert.assertEquals(-1, pi.getCurrentInsurance());
        pi.setCurrentInsurance(10);
        Assert.assertEquals(10, pi.getCurrentInsurance());
    }

    @Test
    public void setPlayNextMatch() {
        PlayerInput pi = new PlayerInput();
        Assert.assertEquals(false, pi.isPlayNextMatch());
        pi.setPlayNextMatch(true);
        Assert.assertEquals(true, pi.isPlayNextMatch());
    }

    @Test
    public void setPlayerTurnDone() {
        PlayerInput pi = new PlayerInput();
        Assert.assertEquals(false, pi.isPlayerTurnDone());
        pi.setPlayerTurnDone(true);
        Assert.assertEquals(true, pi.isPlayerTurnDone());
    }
}
