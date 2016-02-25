package test;

import models.Card;
import models.CreditCard;

/**
 * Created by liuchuang on 25/02/16.
 */
public class ModelsTest {
    public static void main(String[] argv) {
        Card card = new Card();
        System.out.println(card.toString());
        CreditCard cc = new CreditCard();
        System.out.println(cc.toString());
    }
}
