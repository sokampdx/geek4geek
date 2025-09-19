// https://www.geeksforgeeks.org/problems/buy-stock-2/1
// User function Template for Java

class Solution {
    public int maximumProfit(int prices[]) {
        // Code here
        int min = prices[0];
        int maxDiff = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            if (prices[i] > min) maxDiff = Math.max(maxDiff, prices[i] - min);
            
        }
        return maxDiff;

    }
}
