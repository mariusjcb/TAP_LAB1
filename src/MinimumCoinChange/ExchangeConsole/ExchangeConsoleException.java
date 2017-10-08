package MinimumCoinChange.ExchangeConsole;
import MinimumCoinChange.Config.AppStrings;
import MinimumCoinChange.Exchanger.ExchangeException;

public class ExchangeConsoleException extends ExchangeException {
    public static ExchangeException noInsertedCoins() {
        return new ExchangeException(AppStrings.noInsertedCoins);
    }
}
