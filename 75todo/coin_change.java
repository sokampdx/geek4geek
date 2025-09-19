// https://www.geeksforgeeks.org/problems/number-of-coins1824/1
//
class Solution {

    public int minCoins(int coins[], int sum) {
        // code here
        return findMinCoinsI(coins, sum);
    }
    
    public int findMinCoinsI(int[] coins, int sum) {
    int[] count = new int[sum + 1];
    int reminder = 0;
    int currentCount = 0;

    Arrays.fill(count, -1);
    count[0] = 0;
    for (int n = 1; n <= sum; n++) {
      for (int coin : coins) {
        reminder = n - coin;
        if (reminder >= 0 && count[reminder] != -1) {
          currentCount = 1 + count[reminder];
          if (count[n] == -1) {
            count[n] = currentCount;
          } else {
            count[n] = Math.min(count[n], currentCount);
          }
        }
      }
    }
    return count[sum];
    }
}
