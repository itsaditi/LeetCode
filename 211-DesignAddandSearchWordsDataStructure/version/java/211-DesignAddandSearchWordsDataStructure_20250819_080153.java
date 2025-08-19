// Last updated: 8/19/2025, 8:01:53 AM
class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd = false;

    TrieNode() {
        this.children = new HashMap<>();
    }
}


class WordDictionary {
    TrieNode rootNode;

    public WordDictionary() {
        this.rootNode = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode addNode = new TrieNode();
        addNode = rootNode;

        for (Character ch: word.toCharArray()) {
            if (!addNode.children.containsKey(ch)) {
                addNode.children.put(ch, new TrieNode());
            } 
            
            addNode = addNode.children.get(ch);
        }
        addNode.isEnd = true;
        
    }

    public boolean searchInNode(String word, TrieNode node) {

        for (int i = 0 ; i < word.length() ; i++) {
            Character ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                
                if (ch == '.') {
                    // Do something
                    for (Character key : node.children.keySet()) {
                        TrieNode child = node.children.get(key);
                        if (searchInNode(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                }
                return false;

            } else {
                

                node = node.children.get(ch);
            }
        }
        return node.isEnd;
    }
    
    public boolean search(String word) {
        return searchInNode(word, rootNode);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */