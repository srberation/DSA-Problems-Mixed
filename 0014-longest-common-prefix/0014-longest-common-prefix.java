class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int n = strs.length;
        int i;
        if(n == 0) return "";
        else if(n == 1) return strs[0];
        else{
            int minl = Math.min(strs[0].length(),strs[n-1].length());
            for( i = 0; i<minl; i++){
                if(strs[0].charAt(i) == strs[n-1].charAt(i)) continue;
                else break;
            }
        }

        return strs[0].substring(0,i);
        
    }
}
        