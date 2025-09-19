// https://www.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1
class Solution {
    // HashMap<Integer, Integer> visited = new HashMap<>();
    
    int countWays(int n) {
        int[] visited = new int[n + 1];
        // your code here
        if (n < 0) return 0;
        if (n <= 1) return 1;
        
        visited[0] = 0;
        visited[1] = 1;
        visited[2] = 2;
        for (int i = 3; i <= n; i++) {
            visited[i] = visited[i - 1] + visited[i - 2];
        }        
        
        return visited[n];
    }
    /*
    int countWays(int n, int key) {
        if (visited.containsKey(key)) return visited.get(key);
        if (n == 0) return 1;
        if (n < 0) return 0;
        
        int ways = countWays(n - 1, key * 10 + 1) + countWays(n - 2, key * 10 + 2);
        visited.put(key, ways);
        return ways;
    }
    */
}
