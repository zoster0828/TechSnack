package tidy.first;

import java.util.Optional;

public class Sample3 {


    public float calculateExchangeRate1(Integer currency, float exchangeRate) {
        return currency != null ? currency * exchangeRate : 1 * exchangeRate;
    }

    public float calculateExchangeRate2(Integer currency, float exchangeRate) {
        if(currency != null) {
            return currency * exchangeRate;
        }

        return 1 * exchangeRate;
    }

    public float calculateExchangeRate3(Integer currency, float exchangeRate) {
        return (currency != null ? currency : 1) * exchangeRate;
    }

    public float calculateExchangeRate4(Optional<Integer> currencyOpt, float exchangeRate) {
        return currencyOpt.orElse(1) * exchangeRate;
    }
}
