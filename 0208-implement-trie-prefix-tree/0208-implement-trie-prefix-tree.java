class Trie {

    private boolean isEnd;
    private Trie[] children;

    public Trie() {
        isEnd = false;
        children = new Trie[26];
        for(int i=0; i<26; i++) children[i] = null;
    }

    public void insert(String word) {
        Trie curr = this;  // will work as root
        for(char ch: word.toCharArray()){
            int idx = ch-'a';
            if(curr.children[idx] == null) curr.children[idx] = new Trie();
            curr = curr.children[idx];
        }  
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Trie curr = this;
        for(char ch: word.toCharArray()){
            int idx = ch-'a';
            if(curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }  
        return curr.isEnd;       
    }

    public boolean startsWith(String prefix) {
         Trie curr = this;
        for(char ch: prefix.toCharArray()){
            int idx = ch-'a';
            if(curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }  
        return true;     
    }
}