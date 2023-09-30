class Trie {
    private boolean isEnd;
    private Trie[] children;

    public Trie() {
        // Trie structure will have a flag for finding end of the word and children array of 26 size 
        isEnd = false;
        children = new Trie[26];
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }

    public void insert(String word) {
        // By assigning this to the curr variable, you are creating a reference to the current Trie node. This is commonly done to traverse or manipulate the Trie data structure from the current node
        Trie curr = this;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';  // get index of the curr character
            if (curr.children[index] == null) {
                curr.children[index] = new Trie();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Trie curr = this;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie curr = this;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }
}
