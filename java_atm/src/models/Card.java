package models;

import java.util.Random;

/**
 * Created by liuchuang on 25/02/16.
 */
public class Card {
    private int id;
    private String cardNum;
    private String owner;
    private String personID;
    private String phoneNum;
    private String password;
    private double deposit;

    private void init(){
        String cardnumber = "";
        String pwd = "";
        for(int i = 0; i < 19; i ++) {
            cardnumber += new Random().nextInt(10);
        }
        cardnumber += "\0";
        for(int j = 0; j < 6; j++) {
            pwd += new Random().nextInt(10);
        }
        pwd += "\0";
        this.setCardNum(cardnumber);
        this.setPassword(pwd);
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Card(){
        this.deposit = 0.0;
        init();
    }

    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardNum='" + cardNum + '\'' +
                ", owner='" + owner + '\'' +
                ", personID='" + personID + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", password='" + password + '\'' +
                ", deposit=" + deposit +
                '}';
    }
}
