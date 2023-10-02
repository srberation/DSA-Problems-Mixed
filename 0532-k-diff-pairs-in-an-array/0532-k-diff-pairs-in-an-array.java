// class Solution {
//     public int findPairs(int[] nums, int k) {
//         int count = 0;
//         Arrays.sort(nums);
//         int l=0,r=1;
//         while(l< nums.length && r < nums.length ){
//             if(nums[r]-nums[l] == k ){
//                 count++;
//                 l++;
//                 r++;
//                 while(r<nums.length && nums[r]==nums[r-1]) r++;
//             }
//             else if(nums[r]-nums[l] > k) {
//                 l++;
//                 if(r-l == 0) r++;
//             }
//             else r++;
//         }
//         return count;
//     }
// }
 // O(n) Time Solution

 class Solution {
 		public int findPairs(int[] nums, int k) {
 			Map<Integer, Integer> map = new HashMap();
 			for (int num : nums)
 				map.put(num, map.getOrDefault(num, 0) + 1);

 			int result = 0;
 			for (int i : map.keySet())
 				if (k > 0 && map.containsKey(i + k) || k == 0 && map.get(i) > 1)
 					result++;
 			return result;
 		}
 	}