class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();

        Arrays.sort(nums);
        for(int i = 0; i< nums.length - 2; i++){ 
            // skip duplicates
            if( i>0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i+1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    // add new list in ans list
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right -1]) right--;

                    left++;
                    right--;                    
                }
                // if sum is lesser then increase left pointer
                else if(sum < 0)  left++;
                else right--;
            }
        }
        return ans;
    }
}