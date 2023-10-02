class Solution {
    public int findPairs(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        int l=0,r=1;
        while(l< nums.length && r < nums.length ){
            if(nums[r]-nums[l] == k ){
                count++;
                l++;
                r++;
                while(r<nums.length && nums[r]==nums[r-1]) r++;
            }
            else if(nums[r]-nums[l] > k) {
                l++;
                if(r-l == 0) r++;
            }
            else r++;
        }
        return count;
    }
}