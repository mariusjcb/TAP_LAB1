package MinimumCoinChange.ExchangeConsole;
import MinimumCoinChange.Config.AppStrings;
import MinimumCoinChange.Utils.CoinsArrayUtils;

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

    public static Integer readMoneySum() throws ExchangeConsoleException {
        System.out.println();
        System.out.println(AppStrings.exchangeSum + ": ");

        Scanner scanner = new Scanner(System.in);
        Integer money = scanner.nextInt();

        if (!hasValidSum(money)) {
            throw ExchangeConsoleException.negativeValue(money);
        }

        return money;
    }

    public static Integer[] readCoins() throws ExchangeConsoleException {
        System.out.println();
        System.out.println(AppStrings.coins + "(separated by ', '): ");

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> integers = new ArrayList<Integer>();

        String[] numbers = scanner.nextLine().split(", ");

        for (String numberStr : numbers) {
            Integer coin = Integer.parseInt(numberStr);
            integers.add(coin);
        }

        if (integers.size() == 0) {
            throw ExchangeConsoleException.noInsertedCoins();
        }

        return CoinsArrayUtils.convertToIntegerArray(integers);
    }

    public static void printResult(Integer[] result) {
        if (result.length == 0) {
            System.out.println(AppStrings.noExchangeResult);
            return;
        }

        System.out.println();
        System.out.println(AppStrings.exchangeResult + ": ");

        CoinsArrayUtils.elementsFrequency(result, (element, frequency) -> {
            String resultInUnits = String.format(AppStrings.exchangeFormat, element, AppStrings.exchangeUnit);
            System.out.printf("%d %s %s\n", frequency, "x", resultInUnits);
        });
    }
}
