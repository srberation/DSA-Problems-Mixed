class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i = 0; i< nums.length; i++){
            currSum = Math.max(currSum + nums[i], nums[i]);
            // if(maxSum < currSum) maxSum = currSum;
            // if(currSum < 0) currSum = 0;   
            maxSum = Math.max(maxSum, currSum);         
        }
        return maxSum;

    }
}