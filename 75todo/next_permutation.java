// https://www.geeksforgeeks.org/problems/next-permutation5226/1
import java.util.Arrays;

class Solution {
    int[] createResult(int[] arr, int firstIndex, int swapIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[swapIndex];
        arr[swapIndex] = temp;
        Arrays.sort(arr, firstIndex + 1, arr.length);

        return arr;
    }

    int findFirstIndex(int[] arr) {
        Boolean foundFirstIndex = false;
        int firstIndex = -1;
        
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                firstIndex = i - 1;
                foundFirstIndex = true;
                break;
            }
        }
        
        return foundFirstIndex ? firstIndex : -1;
    }
    
    int findSwapIndex(int[] arr, int firstIndex) {
        int currentDiff = 0;
        int minDiff = Integer.MAX_VALUE;
        int minDiffIndex = -1;
        for (int i = firstIndex + 1; i < arr.length; i++) {
            currentDiff = arr[i] - arr[firstIndex];
            if (currentDiff > 0 && currentDiff < minDiff) {
                minDiffIndex = i;
            }
        }
        
        return minDiffIndex;
    }
    
    void nextPermutation(int[] arr) {
        int firstIndex = -1;
        int swapIndex = -1;
        
        firstIndex = findFirstIndex(arr);
        if (firstIndex >= 0) swapIndex = findSwapIndex(arr, firstIndex);
        if (firstIndex >= 0 && swapIndex >= 0) {
            arr = createResult(arr, firstIndex, swapIndex);
        } else {
            Arrays.sort(arr);
        }
    }
}
