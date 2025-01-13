import java.util.ArrayList;
import java.util.Arrays;

public class Boggle {

    public static String[] findWords(char[][] board, String[] dictionary) {

        ArrayList<String> goodWords = new ArrayList<String>();

        // Convert the dictionary into a Trie
        Trie dict = new Trie();

        for (String s : dictionary) {
            dict.addWord(s);
        }

        // Use DFS to search through the 2D array
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                // Initiate depth first recursive search at every letter
                depthFirstSearch(board, dict.getRoot(), goodWords, i, j, "");
            }
        }

        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }

    // Uses depth first search to search through inputted 2D array
    public static void depthFirstSearch(char[][] board, TrieNode place, ArrayList<String> goodWords, int row, int col, String path) {

        // Base cases are outside of bounds
        if (row >= board.length || row < 0 || col < 0 || col >= board[row].length) {
            return;
        }

        // Place has been visited
        if (board[row][col] == '-') {
            return;
        }

        // Update node
        place = place.checkChild(board[row][col]);

        // null value in the trie
        if (place == null) {
            return;
        }

        // Set this value to visited (dash) and save the letter
        char letter = board[row][col];
        board[row][col] = '-';

        String newPath = path += letter;

        // Check if there's a word
        if (place.isWord()) {
            goodWords.add(newPath);

            // Everytime a true value is encountered in the Trie / tst simply set the node to false
            place.removeWord();
        }

        // Recurse through the different options
        depthFirstSearch(board, place, goodWords, row, col + 1, newPath);
        depthFirstSearch(board, place, goodWords, row + 1, col, newPath);
        depthFirstSearch(board, place, goodWords, row, col - 1, newPath);
        depthFirstSearch(board, place, goodWords, row - 1, col, newPath);

        // Set this character back to the original character
        board[row][col] = letter;
    }
}
