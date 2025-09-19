// User function Template for Java
import java.util.*;

class Solution {
    public List<Integer> twoSum(int arr[], int target) {
        // Your code here
        ArrayList<Integer> answer = new ArrayList<Integer>();
        HashMap<Integer, Integer> kv = new HashMap<Integer, Integer>();
        for (int i : arr) {
            if (kv.containsKey(i)) {
                answer.add(i);
                answer.add(kv.get(i));
                break;
            } else {
                kv.put(target - i, i);
            }
        }
        return answer;
    }
}
