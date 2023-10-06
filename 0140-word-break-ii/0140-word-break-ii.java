class Solution {
Map<String,List<String>> dp = new HashMap<>();

public List<String> wordBreak(String s, List<String> wordDict) {
    if (dp.containsKey(s)) return dp.get(s);

    List<String> sentences = new ArrayList<>();
    if (wordDict.contains(s)) {
        sentences.add(s);
    }

    for (int i = 1; i < s.length(); i++) {
        String prefix = s.substring(0, i);
        if (wordDict.contains(prefix)) {
            List<String> suffixSentences = wordBreak(s.substring(i), wordDict);
            for (String suffixSentence : suffixSentences) {
                sentences.add(prefix + " " + suffixSentence);
            }
        }
    }

    dp.put(s, sentences);
    return sentences;
}

}