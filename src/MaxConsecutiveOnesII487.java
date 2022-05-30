/**
 * Given a binary array, find the maximum number of consecutive 1s in this
 * array if you can flip at most one 0.
 * 
 * Example 1:
 * Input: [1,0,1,1,0]
 * Output: 4
 * Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
 *     After flipping, the maximum number of consecutive 1s is 4.
 * 
 * Note:
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * 
 * Follow up:
 * What if the input numbers come in one by one as an infinite stream? In other
 * words, you can't store all numbers coming from the stream as it's too large
 * to hold in memory. Could you solve it efficiently?
 */

public class MaxConsecutiveOnesII487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = 0;
        int max = 0;
        int zeros = 0;
        while (right < nums.length) {
            if (nums[right] == 1) {
                right++;
                continue;
            } else if (nums[right] == 0 && zeros == 0) {
                right++;
                zeros++;
                continue;
            }
            max = Math.max(max, right - left);
            while (left < nums.length && nums[left] == 1) left++;
            if (left < nums.length && nums[left] == 0) {
                left++;
                zeros--;
            }
        }
        return Math.max(max, right-left);
    }
}
