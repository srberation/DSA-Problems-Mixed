class Solution {
    public List<List<Integer>> combine(int n, int k) {
         List<List<Integer>> res= new ArrayList();
         generateSubset(1,new ArrayList(), res,k,n);
         return res;
    }

    public void generateSubset(int ind, List<Integer> curr, List<List<Integer>> res, int k , int n){
        if(curr.size() == k){
            res.add(new ArrayList(curr));
            return;
        }

        for(int i = ind; i<=n;i++){
            curr.add(i);
            generateSubset(i+1,curr, res,k,n);
            curr.remove(curr.size()-1);

        }
    }
}