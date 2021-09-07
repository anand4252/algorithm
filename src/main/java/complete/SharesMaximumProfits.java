package complete;

import java.util.List;

/**
 * Find the maximum profit one can make by selling from the below stock prices!
 * Ex: buying at 15 and selling at 50 will fetch the highest profit of 35.
 *
 */
public class SharesMaximumProfits {
    public static void main(String[] args) {
        System.out.println("find the maximum profit one can make by selling from the below stock prices! Ex: buying at 15 and selling at 50 will fetch the highest profit of 35");
        List<Integer> stockPrices = List.of(20, 40, 52, 15, 30, 50, 10, 25);
        int diff = 0;
        for (int buyIndex = 0; buyIndex < stockPrices.size() - 1; buyIndex++) {
            for (int sellIndex = buyIndex + 1; sellIndex < stockPrices.size(); sellIndex++) {
                if (diff < stockPrices.get(sellIndex) - stockPrices.get(buyIndex)) {
                    diff = stockPrices.get(sellIndex) - stockPrices.get(buyIndex);
                }
            }
        }
        System.out.println("Max Diff:  " + diff);
    }
}