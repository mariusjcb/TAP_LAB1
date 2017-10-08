package MinimumCoinChange.Exchanger;
import MinimumCoinChange.Utils.CoinsArrayUtils;
import MinimumCoinChange.Exchanger.Coins.Coins;

import java.util.*;

public class Exchanger {
    private Coins coins;
    private Map<Integer, Integer[]> storedValues = new HashMap<Integer, Integer[]>();

    public Exchanger(Integer[] coins) throws ExchangeException {
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

        Optional<Integer> changeSum = CoinsArrayUtils.sumArray(changeCoins);
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

                Optional<Integer> potentialSum = CoinsArrayUtils.sumArray(potentialChange);
                if (potentialSum.isPresent() && potentialSum.get() == value) {
                    potentialResults.add(potentialChange);
                }
            }
        }

        if (potentialResults.size() > 0) {
            potentialResults.sort((left, right) -> {
                return left.size() - right.size();
            });

            Integer[] result = CoinsArrayUtils.convertToIntegerArray(potentialResults.get(0));
            storedValues.put(value, result);

            return result;
        }

        return new Integer[0];
    }
}
