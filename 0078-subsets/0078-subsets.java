class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        // res.add(new ArrayList());

        // for(int num: nums){
        //     int n = res.size();
        //     for(int j = 0; j< n;j++){
        //         List<Integer> temp = new ArrayList(res.get(j));
        //         temp.add(num);
        //         res.add(temp);
        //     }    
        // }
        generatSubset(0,nums,new ArrayList(),res);
        return res;
    }

    public void generatSubset(int index, int[] nums, List<Integer> curr, List<List<Integer>> res){
        res.add(new ArrayList(curr));

        for(int i =index; i<nums.length; i++){
            curr.add(nums[i]);
            generatSubset(i+1,nums,curr,res);
            curr.remove(curr.size()-1);
        }

    }
}