class TrieNode {
    boolean isEnd;
    TrieNode[] children;

    TrieNode() {
        isEnd = false;
        children = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null || !node.children[index].isEnd) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }
}

class Solution {
    public String longestWord(String[] words) {
        // Step 1: Insert all words into a Trie
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        // Step 2: Initialize variables for the longest word
        String longest = "";
        for (String word : words) {
            // Step 3: Check if the current word is a valid candidate
            boolean valid = true;
            for (int i = 1; i < word.length(); i++) {
                if (!trie.search(word.substring(0, i))) {
                    valid = false;
                    break;
                }
            }

            // Step 4: Update the longest word if the current word is valid
            if (valid) {
                if (word.length() > longest.length() || (word.length() == longest.length() && word.compareTo(longest) < 0)) {
                    longest = word;
                }
            }
        }

        return longest;
    }
}
