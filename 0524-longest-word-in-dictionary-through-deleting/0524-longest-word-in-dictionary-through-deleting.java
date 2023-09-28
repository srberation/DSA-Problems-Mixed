class Solution {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        /**
         with sorting : O(NlogN + N)
         sort dictionary : if length of strings are equal sort lexicographical  (a.compareTo(b)) otherwise sort accd to length desc order
        */
        // d.sort((String a, String b) -> a.length() == b.length() ? a.compareTo(b): b.length() - a.length() );

        /**
        * w/o sorting: O(N)
        */
        for(String str : d){
            if(isSubstring(s,str)) {
                // length, str > result || length is equal but str is lexicographically small
                if(str.length() > result.length() || (str.length() == result.length() && str.compareTo(result) < 1) ) result = str;
            }
        }
        return result;
    }

    public boolean isSubstring(String S, String D){
        if(D.length()> S.length()) return false;
        int i=0, j=0;
        while(i < S.length() && j < D.length()){
            if(S.charAt(i) == D.charAt(j)) j++;
            i++;
        }
        return j == D.length();
    }
}