// https://www.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
class Solution {
    int maxSubarraySum(int[] arr) {
        // Code here
        int max = arr[0];
        int current_max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            current_max = Math.max(arr[i], arr[i] + current_max);
            max = Math.max(max, current_max);
        }
        
        return max;
    }
}
