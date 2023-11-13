class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        genSubset(0,nums,new ArrayList(), res, target);
        return res;
    }

    public void genSubset(int start, int[] nums, List<Integer> curr, List<List<Integer>> res, int target  ){
        if(target==0)
            res.add(new ArrayList(curr));
        if(target<0) return;

        for(int i =start; i< nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            genSubset(i+1,nums,curr,res,target-nums[i]);
            curr.remove(curr.size() -1);
        }
    }
}
