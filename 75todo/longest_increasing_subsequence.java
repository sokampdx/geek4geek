// https://www.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1
//
class Solution {
    static int lis(int nums[]) {
        List<Integer> sub = new ArrayList<>();
        for (int num : nums) {
            int i = Collections.binarySearch(sub, num);
            if (i < 0) i = -(i + 1);
            if (i == sub.size()) sub.add(num);
            else sub.set(i, num);
        }
        return sub.size();
    }
}
