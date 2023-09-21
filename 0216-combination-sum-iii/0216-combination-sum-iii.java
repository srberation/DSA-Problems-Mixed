import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(k, n, new ArrayList<>(), 1, 9, res);
        return res;
    }

    public void helper(int k, int target, ArrayList<Integer> curr, int ind, int end, List<List<Integer>> res) {
        if (target == 0 && curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = ind; i <= end && curr.size() < k; i++) {
            curr.add(i);
            helper(k, target - i, curr, i + 1, end, res);
            curr.remove(curr.size() - 1);
        }
    }
}
