package MinimumCoinChange.Exchanger;

public class ExchangeException extends RuntimeException {
    public ExchangeException() { }
    public ExchangeException(String message) {
        super(message);
    }

    public static ExchangeException negativeValue(int money) {
        return new ExchangeException("'" + money + "' is a negative money sum.");
    }

    public static ExchangeException impossibleExchange(int money) {
        return new ExchangeException("It's impossible to change '" + money + "' with inserted coin types.");
    }
}
