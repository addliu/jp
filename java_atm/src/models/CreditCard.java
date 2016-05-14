package models;

/**
 * Created by liuchuang on 25/02/16.
 */
public class CreditCard extends Card {
    private int creditLimit;

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public CreditCard() {
        super();
        this.creditLimit = 10000;
    }

    public String toString() {
        return "CreditCard{" +
                "id=" + this.getId() +
                ", cardNum='" + this.getCardNum() + '\'' +
                ", owner='" + this.getOwner() + '\'' +
                ", personID='" + this.getPersonID() + '\'' +
                ", phoneNum='" + this.getPhoneNum() + '\'' +
                ", password='" + this.getPassword() + '\'' +
                ", deposit=" + this.getDeposit() +
                ", creditLimit=" + this.getCreditLimit() +
                '}';
    }
}
