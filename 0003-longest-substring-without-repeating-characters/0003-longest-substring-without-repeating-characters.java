class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen=0;
        Map<Character,Integer> map = new HashMap<>();
        int j = 0; 
        for(int i =0; i< n; i++){
            if(! map.containsKey(s.charAt(i)) || map.get(s.charAt(i)) < j){
                map.put(s.charAt(i), i);
                maxLen = Math.max(maxLen, i-j+1);
            }
            else{
                j = map.get(s.charAt(i)) + 1;
                map.put(s.charAt(i),i);
            }
        }

        return maxLen;
    }
}