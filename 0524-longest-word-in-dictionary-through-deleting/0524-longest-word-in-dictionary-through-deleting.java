class Solution {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        // sort dictionary : if length of strings are equal sort lexicographical otherwise sort accd to length desc order
        d.sort((String a, String b) -> a.length() == b.length() ? a.compareTo(b): b.length() - a.length() );
        for(String str : d){
            if(isSubstring(s,str)) return result = str;
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