class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        generateSubset(nums,0, new ArrayList(), res);
        return res;
    }
    public void generateSubset(int[] nums, int start, ArrayList<Integer> curr,List<List<Integer>> res ){
        res.add(new ArrayList(curr));
        for(int i = start; i< nums.length; i++){
            if(i > start && nums[i-1] == nums[i] ) continue;
            curr.add(nums[i]);
            generateSubset(nums, i+1, curr,res);
            curr.remove(curr.size()-1);
        }
    }

}