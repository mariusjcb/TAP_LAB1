package MinimumCoinChange;
import MinimumCoinChange.Exchanger.*;
import MinimumCoinChange.Exchanger.Coins.*;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            Exchanger exchanger = new Exchanger(1, 2, 20, 10, 15);
            Integer[] change = exchanger.changeMoney(41);
            System.out.print(change);
        } catch(ExchangeException error) {
            System.out.print(error.getMessage());
        }
    }
}
