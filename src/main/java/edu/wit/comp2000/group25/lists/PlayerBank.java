package edu.wit.comp2000.group25.lists;

/**
 * The players bank
 */
public class PlayerBank {
    private int bank;
    public PlayerBank(int startmoney){
        bank = startmoney;
    }
    public void transferTo(PlayerBank pb, int money){
        this.removeMoney(money);
        pb.addMoney(money);
    }
    private void addMoney(int money){
        this.bank += money;
    }
    private void removeMoney(int money){
        if(this.bank - money < 0){
            throw new IllegalArgumentException("Player Bankrupt");
        }
        this.bank -= money;
    }
    @Override
    public String toString(){
        String str = "";
        str += "PlayerBank{money: "+this.bank+"}";
        return str;
    }
}
