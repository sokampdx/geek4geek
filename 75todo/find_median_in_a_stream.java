public class Solution {
    
    public Boolean isSizeEven(int lowerSize, int upperSize) {
        return (lowerSize + upperSize) % 2 == 0;
    }
    
    public Double getCurrentMedian(int value, PriorityQueue<Integer> lower, PriorityQueue<Integer> upper) {
        if (lower.size() == 0 || value <= lower.peek()) lower.add(value);
        if (value > lower.peek()) upper.add(value);
        rebalance(lower, upper);
        if (isSizeEven(lower.size(), upper.size())) {
            return (lower.peek() + upper.peek()) / 2.0;
        } else {
            return lower.peek() * 1.0;
        }
    }
    
    public void rebalance(PriorityQueue<Integer> lower, PriorityQueue<Integer> upper) {
        //System.out.println(lower.peek() + ":" + upper.peek());
        if (lower.size() - upper.size() > 1) {
            upper.add(lower.poll());
        } else if (upper.size() - lower.size() > 0) {
            lower.add(upper.poll());
        }
    }
    
    public ArrayList<Double> getMedian(int[] arr) {
        // code here
        ArrayList<Double> medians = new ArrayList<>();
        int size = arr.length / 2 + 1;
        PriorityQueue<Integer> lower = new PriorityQueue<>(size, Comparator.reverseOrder());
        PriorityQueue<Integer> upper = new PriorityQueue<>(size);
        
        for (int i = 0; i < arr.length; i++) {
            medians.add(getCurrentMedian(arr[i], lower, upper));
        }
        return medians;
    }
    
}
