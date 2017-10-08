package MinimumCoinChange.ExchangeConsole;
import MinimumCoinChange.Utils.CoinArrayUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class ExchangeConsole {
    private ExchangeConsole() { }

    private static boolean hasValidCoins(Integer[] coins) {
        return coins.length > 0;
    }

    private static boolean hasValidSum(int sum) {
        return sum > 0;
    }

    static Integer readMoneySum() throws ExchangeConsoleException {
        Scanner scanner = new Scanner(System.in);
        Integer money = scanner.nextInt();

        if (!hasValidSum(money)) {
            throw ExchangeConsoleException.negativeValue(money);
        }

        return money;
    }

    static Integer[] readCoins() throws  ExchangeConsoleException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> integers = new ArrayList<Integer>();

        while (scanner.hasNextInt()) {
            integers.add(scanner.nextInt());
        }

        return CoinArrayUtils.convertToIntegerArray(integers);
    }
}
