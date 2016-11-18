package edu.wit.comp2000.group25.lists;

/**
 * An unlimited player bank
 */
public class DealerBank extends PlayerBank {
    private boolean isInfinite;

    /**
     * Creates a new dealer bank with a defined amount of money
     *
     * @param money Amount dealer starts with
     */
    public DealerBank(int money) {
        super(money);
        this.isInfinite = false;
    }

    /**
     * Creates a new dealer bank with infinite money.
     */
    public DealerBank() {
        super(0);
        this.isInfinite = true;
    }

    @Override
    protected void addMoney(int money) {
        if (!this.isInfinite) {
            super.addMoney(money);
        }
    }

    @Override
    protected void removeMoney(int money) {
        if (!this.isInfinite) {
            super.removeMoney(money);
        }
    }

    @Override
    public String toString() {
        if (isInfinite)
            return "DealerBank{money:∞}";
        return "DealerBank{money: " + super.getMoney() + "}";
    }

    /**
     * Checks whether the dealer bank has infinite funds
     * @return True if the bank is infinite; Otherwise false
     */
    public boolean isInfinite(){
        return this.isInfinite;
    }


}
