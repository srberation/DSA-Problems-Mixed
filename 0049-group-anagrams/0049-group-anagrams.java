class Solution {
    public List<List<String>> groupAnagrams(String[] str) {
        Map<String, List<String>> map = new HashMap();

        for(int i = 0; i< str.length; i++){
            String freqPattern = buildFreqPattern(str[i]);
            if(map.containsKey(freqPattern))  map.get(freqPattern).add(str[i]);

            else{
                List<String> list = new ArrayList<>();
                list.add(str[i]);
                map.put(freqPattern,list);
            }
        }
        return new ArrayList<>(map.values());
    }

    private String buildFreqPattern(String str){

        int[] freq = new int[26];
        for(char c: str.toCharArray()){
            freq[c-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        char c = 'a';
        for(int i: freq) {
            sb.append(c);
            sb.append(i);
            c++;
        }
        return sb.toString();
    }
}