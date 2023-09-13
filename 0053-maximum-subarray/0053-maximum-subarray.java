class Solution {
    public int maxSubArray(int[] nums) {
        /**
        maxsum , when max sum is < 0
        start counting again
         */
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i = 0; i< nums.length; i++){
            currSum = currSum + nums[i];
            if(maxSum < currSum) maxSum = currSum;
            if(currSum < 0) currSum = 0;            
        }
        return maxSum;

    }
}