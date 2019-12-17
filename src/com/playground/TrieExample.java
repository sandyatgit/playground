package com.playground;

class TrieExample {

    char value;
    TrieExample[] childs = new TrieExample[26];
    boolean isLeaf;

    /** Initialize your data structure here. */
    public TrieExample() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieExample curr = this;
        for(int i=0; i < word.length(); i++){
            TrieExample node = curr.childs[word.charAt(i) - 'a'];
            if(node == null){
                node = new TrieExample();
                curr.childs[word.charAt(i) - 'a'] = node;
            }
            node.value=word.charAt(i);
            curr = node;
        }
        curr.isLeaf = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieExample curr = this;
        for(int i=0; i < word.length(); i++){
            TrieExample node = curr.childs[word.charAt(i) - 'a'];
            if( node != null){
                curr = node;
                continue;
            }
            return false;
        }
        return curr.isLeaf;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieExample curr = this;
        for(int i=0; i < prefix.length(); i++){
            TrieExample node = curr.childs[prefix.charAt(i) - 'a'];
            if( node != null){
                curr = node;
                continue;
            }
            return false;
        }
        return true;
    }
    public static void main(String... s){
        TrieExample t = new TrieExample();

    }
}



/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
