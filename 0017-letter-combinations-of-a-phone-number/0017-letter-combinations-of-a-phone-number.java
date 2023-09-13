class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        int ind = 0;
        int n = digits.length();
        if(n == 0) return new ArrayList<>();
        // mapping strings with digits
        String[] map = {"","","abc","def","ghi","jkl","mno", "pqrs", "tuv", "wxyz"};
        solve(digits,0,res,"",map);
        return res;
    }

    public void solve(String digits, int ind, List<String> res, String temp, String[] map){
        if(ind >= digits.length()){
            res.add(temp);
            return;
        }

        String str = map[digits.charAt(ind) - '0'];
        for(int i = 0; i< str.length(); i++){
            solve(digits, ind+1, res, temp + str.charAt(i) ,map);
        }

    }
}