package MinimumCoinChange.Exchanger.Coins;
import MinimumCoinChange.Config.*;

public class CoinGenericException extends RuntimeException {
    public CoinGenericException() { }
    public CoinGenericException(String message) {
        super(message);
    }

    public static CoinGenericException invalidValue(int coin) {
        return new CoinGenericException(String.format(AppStrings.invalidCoin, coin));
    }

    public static CoinGenericException absentCoin(int coin) {
        return new CoinGenericException(String.format(AppStrings.coinNotFound, coin));
    }
}
