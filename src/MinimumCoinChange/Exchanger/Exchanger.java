package MinimumCoinChange.Exchanger;
import MinimumCoinChange.Exchanger.Coins.Coins;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class Exchanger {
    private Coins coins;
    private Map<Integer, Integer[]> storedValues = new HashMap<Integer, Integer[]>();

    public Exchanger(int... coins) throws ExchangeException {
        this.coins = new Coins(coins);
    }

    private boolean hasValidChange(Optional<Integer> sum, int money) {
        if (!sum.isPresent()) {
            return false;
        }

        if (sum.isPresent() && sum.get() != money) {
            return false;
        }

        return true;
    }

    public Integer[] changeMoney(int money) throws ExchangeException {
        if (money < 0) {
            throw ExchangeException.negativeValue(money);
        }

        storedValues.clear();

        Integer[] changeCoins = getPotentialResult(money);

        Optional<Integer> changeSum = sumArray(changeCoins);
        if (!hasValidChange(changeSum, money)) {
            throw ExchangeException.impossibleExchange(money);
        }

        return changeCoins;
    }

    private Integer[] getPotentialResult(int value) throws ExchangeException {
        if (value < 0) {
            return new Integer[0];
        }

        if (storedValues.containsKey(value)) {
            return storedValues.get(value);
        }

        ArrayList<ArrayList<Integer>> potentialResults = new ArrayList<ArrayList<Integer>>();
        for(Iterator<Integer> it = coins.iterator(); it.hasNext();) {
            Integer coin = it.next();

            if (value - coin >= 0) {
                ArrayList<Integer> potentialChange = new ArrayList<Integer>();
                potentialChange.add(coin);

                Integer[] tempResult = getPotentialResult(value - coin);
                for (Integer result : tempResult) {
                    potentialChange.add(result);
                }

                Optional<Integer> potentialSum = sumArray(potentialChange);
                if (potentialSum.isPresent() && potentialSum.get() == value) {
                    potentialResults.add(potentialChange);
                }
            }
        }

        if (potentialResults.size() > 0) {
            potentialResults.sort((left, right) -> {
                return left.size() - right.size();
            });

            Integer[] result = convertToIntegerArray(potentialResults.get(0));
            storedValues.put(value, result);

            return result;
        }

        return new Integer[0];
    }

    private Integer[] convertToIntegerArray(ArrayList<Integer> array) {
        Object[] arr = array.toArray();
        return Arrays.copyOf(arr, arr.length, Integer[].class);
    }

    private Optional<Integer> sumArray(ArrayList<Integer> array) {
        return sumArray(convertToIntegerArray(array));
    }

    private Optional<Integer> sumArray(Integer[] array) {
        Stream<Integer> stream = Arrays.stream(array);
        Optional<Integer> sum = stream.reduce((left, right) -> {
            return left + right;
        });

        return sum;
    }
}
