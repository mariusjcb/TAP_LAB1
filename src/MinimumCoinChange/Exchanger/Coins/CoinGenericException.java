package MinimumCoinChange.Exchanger.Coins;

public class CoinGenericException extends RuntimeException {
    public CoinGenericException() { }
    public CoinGenericException(String message) {
        super(message);
    }

    public static CoinGenericException invalidValue(int coin) {
        return new CoinGenericException("Invalid coin value '" + coin + "'.");
    }

    public static CoinGenericException absentCoin(int coin) {
        return new CoinGenericException("Coin " + coin + " was not found.");
    }
}
