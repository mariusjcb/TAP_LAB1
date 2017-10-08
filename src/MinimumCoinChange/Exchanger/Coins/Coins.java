package MinimumCoinChange.Exchanger.Coins;

import java.util.*;
import java.util.function.*;

import java.lang.*;

public class Coins {
    private ArrayList<Integer> coins = new ArrayList<Integer>();

    private Coins() { }

    public Coins(int... coins) throws MinimumCoinChange.Exchanger.Coins.CoinGenericException {
        for (int coin : coins) {
            this.add(coin);
        }

        this.sortDesc();
    }

    private boolean hasValidCoin(int coin) {
        return coin <= 0;
    }

    public void get(int index) {
        coins.get(index);
    }

    public void add(int coin) throws MinimumCoinChange.Exchanger.Coins.CoinGenericException {
        if (hasValidCoin(coin)) {
            throw MinimumCoinChange.Exchanger.Coins.CoinGenericException.invalidValue(coin);
        }

        coins.add(coin);
    }

    public void remove(int coin) throws MinimumCoinChange.Exchanger.Coins.CoinGenericException {
        if (!coins.contains(coin)) {
            throw MinimumCoinChange.Exchanger.Coins.CoinGenericException.absentCoin(coin);
        }

        coins.remove(coin);
    }

    public void sortDesc() {
        coins.sort((elem1, elem2) -> {
            return elem1.compareTo(elem2);
        });
    }

    public Iterator<Integer> iterator() {
        return coins.iterator();
    }

    public void forEach(Consumer<Integer> lambda) {
        coins.forEach(lambda);
    }
}
