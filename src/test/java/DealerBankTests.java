import edu.wit.comp2000.group25.lists.DealerBank;
import edu.wit.comp2000.group25.lists.PlayerBank;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class DealerBankTests {
    @Test
    public void unlimitedTransfer() {
        DealerBank db = new DealerBank();
        PlayerBank pb = new PlayerBank(0);
        db.transferTo(pb, 5000);
        Assert.assertEquals(5000, pb.getMoney());
    }

    @Test
    public void getMoneyLimited() {
        DealerBank db = new DealerBank(5000);
        Assert.assertEquals(5000, db.getMoney());
    }

    @Test
    public void getMoneyUnlimited() {
        DealerBank db = new DealerBank();
        Assert.assertEquals(0, db.getMoney());
    }

    @Test
    public void limitedTransfer() {
        DealerBank db = new DealerBank(5000);
        PlayerBank pb = new PlayerBank(0);
        db.transferTo(pb, 5000);
        Assert.assertEquals(5000, pb.getMoney());
        Assert.assertEquals(0, db.getMoney());
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalLimitedTransfer() {
        DealerBank db = new DealerBank(100);
        PlayerBank pb = new PlayerBank(0);
        db.transferTo(pb, 150);
    }

    @Test
    public void recoverIllegalLimitedTransfer() {
        DealerBank db = new DealerBank(100);
        PlayerBank pb = new PlayerBank(0);
        try {
            db.transferTo(pb, 150);
        } catch (IllegalArgumentException iae) {
        }
        Assert.assertEquals(100, db.getMoney());
        Assert.assertEquals(0, pb.getMoney());
    }

    @Test
    public void unlimitedToString() {
        DealerBank db = new DealerBank();
        Assert.assertEquals("DealerBank{money:∞}", db.toString());
    }

    @Test
    public void limitedToString() {
        DealerBank db = new DealerBank(5000);
        Assert.assertEquals("DealerBank{money: 5000}", db.toString());
    }

    @Test
    public void addMoneyToUnlimited() {
        DealerBank db1 = new DealerBank(100);
        DealerBank db2 = new DealerBank();
        db1.transferTo(db2, 100);
        Assert.assertEquals(0, db1.getMoney());
        Assert.assertEquals(0, db2.getMoney());
    }

    @Test
    public void addMoneyToLimited() {
        DealerBank db1 = new DealerBank(100);
        DealerBank db2 = new DealerBank(0);
        db1.transferTo(db2, 100);
        Assert.assertEquals(0, db1.getMoney());
        Assert.assertEquals(100, db2.getMoney());
    }
    @Test
    public void isInfinite(){
        DealerBank db = new DealerBank();
        Assert.assertEquals(true, db.isInfinite());
    }
    @Test
    public void isNotInfinite(){
        DealerBank db = new DealerBank(0);
        Assert.assertEquals(false, db.isInfinite());
    }

}
