package edu.wit.comp2000.group25.lists.Enums;

/**
 * Created by beznosm on 11/10/2016.
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
