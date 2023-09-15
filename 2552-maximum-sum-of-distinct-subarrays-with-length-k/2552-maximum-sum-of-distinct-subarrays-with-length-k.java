class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> d = new HashMap<>();
        int left = 0 , right = 0 ,N = nums.length ;
        long best = 0, cur = 0;
        while( right < N ){
            cur += nums[right];
            d.put( nums[right] , d.getOrDefault( nums[right] , 0 ) + 1 );
            
            if( right - left + 1 == k ){            // Needed Window Achieved
                if( d.size() == k )
                    best = Math.max(best,cur);
                cur -= nums[left];
                d.put( nums[left] , d.get(nums[left]) -1 );
                if( d.get(nums[left]) == 0 )
                    d.remove(nums[left]);
                left++;
            }
            right++;
        }
        return best;
    }
}