package edu.wit.comp2000.group25.lists.Enums;

/**
 * Created by beznosm on 11/10/2016.
 */
public enum CardValue {
    Ace(1),
    Two(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6),
    Seven(7),
    Eight(8),
    Nine(9),
    Ten(10),
    Jack(10),
    Queen(10),
    King(10);
    private int value;
    private CardValue(int value){
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
}
