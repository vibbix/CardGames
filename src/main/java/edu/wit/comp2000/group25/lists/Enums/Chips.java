package edu.wit.comp2000.group25.lists.Enums;

/**
 * The chips one can play with.
 */
public enum Chips {
    One(1),
    Five(5),
    Ten(10),
    TwentyFive(25),
    Hundred(100),
    Thousand(1000);
    private int chipValue;
    private Chips(int value){
        this.chipValue = value;
    }
    public int getChipValue(){
        return this.chipValue;
    }

}
