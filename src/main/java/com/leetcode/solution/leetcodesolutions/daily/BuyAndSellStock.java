package com.leetcode.solution.leetcodesolutions.daily;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 23/07/25, Wednesday
 **/

@Slf4j
public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // Initialize to maximum value
        int maxProfit = 0; // Initialize to zero

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i]; // Update minimum price
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice; // Update maximum profit
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BuyAndSellStock stock = new BuyAndSellStock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = stock.maxProfit(prices);
        log.info("Maximum profit: {}", result); // Expected output: 5
    }
}
