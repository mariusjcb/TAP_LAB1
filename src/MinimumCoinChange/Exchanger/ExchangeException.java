package MinimumCoinChange.Exchanger;
import MinimumCoinChange.Config.*;

public class ExchangeException extends RuntimeException {
    public ExchangeException() { }
    public ExchangeException(String message) {
        super(message);
    }

    public static ExchangeException negativeValue(int money) {
        return new ExchangeException(String.format(AppStrings.negativeExchangeSum, money));
    }

    public static ExchangeException impossibleExchange(int money) {
        return new ExchangeException(String.format(AppStrings.noExchangeResult, money));
    }
}
