package MinimumCoinChange;
import MinimumCoinChange.ExchangeConsole.ExchangeConsole;
import MinimumCoinChange.Exchanger.*;
import MinimumCoinChange.Exchanger.Coins.*;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            exchangeUserMoney();
        } catch(RuntimeException error) {
            errorHandler(error);
        }
    }

    private static void exchangeUserMoney() {
        System.out.println();

        Integer[] coins = ExchangeConsole.readCoins();
        Integer totalSum = ExchangeConsole.readMoneySum();

        Integer[] exchangeResult = new Exchanger(coins).changeMoney(totalSum);
        ExchangeConsole.printResult(exchangeResult);
    }

    private static void errorHandler(RuntimeException error) {
        System.out.println();
        System.out.print(error.getMessage());

        exchangeUserMoney();
    }
}
