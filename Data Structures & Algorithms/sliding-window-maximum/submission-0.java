class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0){
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n- k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i=0; i<n; i++){
            // remove indices that are out of the current window
            while (!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            // remove indices whose corresponding values are < nums[i]
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            // add current index to deque
            deque.offer(i);

            // add max element of current window to result
            if (i >= k -1){
                result[i - k + 1] = nums[deque.peek()];
            }
        }
        return result;
    }
}
