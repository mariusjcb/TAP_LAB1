package MinimumCoinChange;
import MinimumCoinChange.Coins.*;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Coins coins;

        // bad
        try {
            coins = new Coins(1, -2, 3);

            for (Iterator<Integer> it = coins.iterator(); it.hasNext();) {
                Integer coin = it.next();
                System.out.print(coin);
            }
        } catch(CoinGenericException e) {
            System.out.print(e.getMessage());
        }

        //good
        try {
            coins = new Coins(4, 5, 6);

            for (Iterator<Integer> it = coins.iterator(); it.hasNext();) {
                Integer coin = it.next();
                System.out.print(coin);
            }
        } catch(CoinGenericException e) {
            System.out.print(e.getMessage());
        }
    }
}
