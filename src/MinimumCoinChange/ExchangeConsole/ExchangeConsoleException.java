package MinimumCoinChange.ExchangeConsole;

public class ExchangeConsoleException extends RuntimeException {
    public ExchangeConsoleException() { }
    public ExchangeConsoleException(String message) {
        super(message);
    }

    public static ExchangeConsoleException negativeValue(int money) {
        return new ExchangeConsoleException("'" + money + "' is a negative money sum.");
    }

    public static ExchangeConsoleException impossibleExchange(int money) {
        return new ExchangeConsoleException("It's impossible to exchange '" + money + "'.");
    }
}
