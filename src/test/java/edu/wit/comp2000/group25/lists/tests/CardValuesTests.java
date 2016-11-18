package edu.wit.comp2000.group25.lists.tests;

import edu.wit.comp2000.group25.lists.Enums.CardValue;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for CardValues
 */
public class CardValuesTests {
    @Test
    public void getValueAce() {
        CardValue cv = CardValue.Ace;
        Assert.assertEquals(1, cv.getValue());
    }

    @Test
    public void getValueOfAce() {
        CardValue cv = CardValue.valueOf("Ace");
        Assert.assertEquals(CardValue.Ace, cv);
    }

}
