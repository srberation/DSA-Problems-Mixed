class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList();
        genSubset(1,new ArrayList(), res, k, n);
        return res;
    }

    public void genSubset(int ind, List<Integer> curr, List<List<Integer>> res, int k , int n){
        if(curr.size() == k){
            res.add(new ArrayList(curr));
            return;
        }
        for(int i = ind ;i<=n;i++){
            curr.add(i);
            genSubset(i+1,curr, res,k,n);
            curr.remove(curr.size() - 1);

        }
    }
}