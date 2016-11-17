package edu.wit.comp2000.group25.lists;

/**
 * The players bank
 */
public class PlayerBank {
    private int bank;

    /**
     * Creates the players bank.
     *
     * @param startmoney Amount to start with
     */
    public PlayerBank(int startmoney) {
        bank = startmoney;
    }

    /**
     * Transfers money from one bank to another.
     *
     * @param pb    A player bank
     * @param money amount to transfer
     */
    public void transferTo(PlayerBank pb, int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money tranferred cannot be below 0");
        }
        if (pb == this) {
            throw new IllegalArgumentException("Cannot transfer money to self");
        }
        this.removeMoney(money);
        pb.addMoney(money);
    }

    /**
     * Returns the money in the bank for the player
     *
     * @return Money in the bank
     */
    public int getMoney() {
        return this.bank;
    }

    /**
     * Adds money to the players account.
     *
     * @param money Amount to add
     */
    protected void addMoney(int money) {
        this.bank += money;
    }

    /**
     * Removes money from the players account.
     *
     * @param money Amount to remove
     * @throws IllegalArgumentException Thrown if player bankrupts
     */
    protected void removeMoney(int money) {
        if (this.bank - money < 0) {
            throw new IllegalArgumentException("Player Bankrupt");
        }
        this.bank -= money;
    }

    @Override
    public String toString() {
        String str = "";
        str += "PlayerBank{money: " + this.bank + "}";
        return str;
    }


}
