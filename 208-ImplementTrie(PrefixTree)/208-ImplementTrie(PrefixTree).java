class TrieNode {
    private final int R = 26;

    private TrieNode[] links;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean getEnd() {
        return isEnd;
    }



}
class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();    
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(char ch: word.toCharArray()) {
            if (!node.containsKey(ch)) {
                TrieNode newNode = new TrieNode();
                node.put(ch, newNode);
                node = newNode;
            } else {
                TrieNode foundNode = node.get(ch);
                node = foundNode;
            }
        }
        node.setEnd();

    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(char ch: word.toCharArray()) {
            if (!node.containsKey(ch)) {
                return false;
            } else {
                TrieNode foundNode = node.get(ch);
                node = foundNode;
            }
        }

        if (node.getEnd())
            return true;
        
        return false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char ch: prefix.toCharArray()) {
            if (!node.containsKey(ch)) {
                return false;
            } else {
                TrieNode foundNode = node.get(ch);
                node = foundNode;
            }
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */