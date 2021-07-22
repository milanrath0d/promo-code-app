package org.example.util;

/**
 * @author Milan Rathod
 */
public final class CurrencyConversionUtil {

    private CurrencyConversionUtil() {

    }

    public static float convert(String currency, float price) {
        switch (currency) {
            case "JPY":
                return price * 100;
            case "USD":
                return price * 75;
            case "ZAR":
                return price * 50;
            default:
                return price;
        }
    }
}
