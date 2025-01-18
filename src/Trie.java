public class Trie {
    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    // Adds words to the trie
    public void addWord(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            if ((word.charAt(i) > 'a' + 26) || word.charAt(i) < 'a') {
                return;
            }
            node.setHasChild();
            node = node.getChild(word.charAt(i));
        }
        node.setWord();
    }

    public TrieNode getRoot() {
        return this.root;
    }

}
