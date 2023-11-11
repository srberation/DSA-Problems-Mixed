class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList();
        genSubset(1,9,new ArrayList(), res, k, n);
        return res;
    }

    public void genSubset(int start, int end, List<Integer> curr, List<List<Integer>> res, int k , int n){
        if(curr.size() == k && n==0 ){
            res.add(new ArrayList(curr));
            return;
        }
        for(int i = start ;i<=end;i++){
            curr.add(i);
            genSubset(i+1,end,curr, res,k,n-i);
            curr.remove(curr.size() - 1);

        }
    }
}


