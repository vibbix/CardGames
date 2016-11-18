package edu.wit.comp2000.group25.lists.tests;

import edu.wit.comp2000.group25.lists.PlayerBank;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the player bank
 */
public class PlayerBankTests {
    @Test(expected = IllegalArgumentException.class)
    public void runOutOfMoney() {
        PlayerBank pb = new PlayerBank(100);
        PlayerBank pbr = new PlayerBank(100);
        pb.transferTo(pbr, 101);
    }

    @Test(expected = IllegalArgumentException.class)
    public void transferToSelf() {
        PlayerBank pb = new PlayerBank(100);
        pb.transferTo(pb, 1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void transferNegative() {
        PlayerBank pb = new PlayerBank(100);
        PlayerBank pbr = new PlayerBank(100);
        pb.transferTo(pbr, -1);
    }

    @Test
    public void transferToSuccess() {
        PlayerBank pb = new PlayerBank(100);
        PlayerBank pbr = new PlayerBank(100);
        pb.transferTo(pbr, 95);
        Assert.assertEquals(195, pbr.getMoney());
        Assert.assertEquals(5, pb.getMoney());
    }

    @Test
    public void toStringTest() {
        PlayerBank pb = new PlayerBank(100);
        Assert.assertEquals("PlayerBank{money: 100}", pb.toString());
    }

}
