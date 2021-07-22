package org.example.util;

import org.example.bean.Product;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @author Milan Rathod
 */
public final class PromotionUtil {

    private static final int FRIDAY = 5;

    private static final int SATURDAY = 6;

    private static final int SUNDAY = 7;

    private PromotionUtil() {

    }

    public static void applyDiscount(Product product) {
        LocalDate localDate = LocalDate.now();

        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        float finalPrice;

        if (dayOfWeek.getValue() == FRIDAY || dayOfWeek.getValue() == SATURDAY
                || dayOfWeek.getValue() == SUNDAY) {
            finalPrice = applySetA(product);
        } else {
            finalPrice = applySetB(product);
        }

        if (finalPrice == product.getPrice() && product.getPrice() > 1000) {
            finalPrice = product.getPrice() - product.getPrice() * 0.02f;
        }

        product.setPrice(finalPrice);
    }

    private static float applySetA(Product product) {
        float finalPriceA = 0;
        float finalPriceB = 0;
        float price = product.getPrice();
        if (product.getOrigin().equals("Africa")) {
            finalPriceA = price - price * 0.07f;
        }

        if (product.getRating() == 2) {
            finalPriceB = price - price * 0.04f;
        } else if (product.getRating() < 2) {
            finalPriceB = price - price * 0.08f;
        }

        if (finalPriceA == 0 && finalPriceB == 0) {
            return price;
        }

        return Math.min(finalPriceA, finalPriceB);
    }

    private static float applySetB(Product product) {
        float finalPriceA = 0;
        float finalPriceB = 0;
        float price = product.getPrice();
        if (product.getInventory() > 20) {
            finalPriceA = price - price * 0.12f;
        }

        if (product.getRating() == 0) {
            finalPriceB = price - price * 0.07f;
        }

        if (finalPriceA == 0 && finalPriceB == 0) {
            return price;
        }

        return Math.min(finalPriceA, finalPriceB);
    }

}
