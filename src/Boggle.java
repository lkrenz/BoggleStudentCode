import java.util.ArrayList;
import java.util.Arrays;

public class Boggle {

    public static String[] findWords(char[][] board, String[] dictionary) {

        ArrayList<String> goodWords = new ArrayList<String>();

        // TODO: Complete the function findWords(). Add all words that are found both on the board
        //  and in the dictionary.

        // Convert the dictionary into a Trie
        Trie dict = new Trie();

        for (int i = 0; i < dictionary.length; i++) {
            dict.addWord(dictionary[i]);
        }

        // Use DFS to search through the 2D array
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                depthFirstSearch(board, dict.getRoot(), goodWords, i, j, "");
            }
        }

        // In the DFS keep track of the path taken through and back up once a null value is found on the TST
        // Could maybe use a Trie here, much simpler and wouldn't be massive because of small alphabet
        // Everytime a true value is encountered in the Trie / tst simply remove the word from the TST (set it to false)


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
