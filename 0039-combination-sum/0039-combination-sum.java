class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
        genSubset(0,nums, new ArrayList(), res,target );
        return res;
    }
    public void genSubset(int start,int[] nums, ArrayList<Integer> curr,List<List<Integer>> res, int target ){
        if(target == 0) res.add(new ArrayList(curr));
        if(target < 0) return;

        for(int i = start; i< nums.length; i++){
            curr.add(nums[i]);
            genSubset(i,nums,curr,res,target-nums[i]);
            curr.remove(curr.size()-1);
        }
    }

}