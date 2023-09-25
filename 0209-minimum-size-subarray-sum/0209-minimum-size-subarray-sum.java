class Solution {
    public int minSubArrayLen(int k, int[] nums) {
        int n = nums.length;
        int left = 0, right = 0, currSum = 0, ans = Integer.MAX_VALUE;

        while (right < n) {
            currSum += nums[right];

            while (currSum >= k) {
                ans = Math.min(ans, right - left + 1);
                currSum -= nums[left];
                left++;
            }

            right++;
        }

        if (ans != Integer.MAX_VALUE)
            return ans;
        else return 0;

    }
}