public class TrieNode {
    private final TrieNode[] children;
    private boolean isWord;
    private boolean hasChild;

    // Creates a new TrieNode
    public TrieNode() {
        this.children = new TrieNode[26];
        this.hasChild = false;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setHasChild() {
        this.hasChild = true;
    }

    public boolean hasChild() {
        return hasChild;
    }

    // Returns the child at the given index, initializing if necessary
    public TrieNode getChild(char index) {
        index = (char)(index - 'a');
        if (children[index] != null) {
            return children[index];
        }
        children[index] = new TrieNode();
        return children[index];
    }

    // Returns child if it exists
    public TrieNode checkChild(char index) {
        if (children[index - 'a'] != null) {
            return children[index - 'a'];
        }
        return null;
    }

    public void setWord() {
        this.isWord = true;
    }

    public void removeWord() {
        this.isWord = false;
    }
}
