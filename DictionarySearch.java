import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DictionarySearch {
    private Set<String> dictionary;

    // Constructor to initialize TreeSet for dictionary
    public DictionarySearch() {
        dictionary = new TreeSet<>();  // TreeSet: sorted, no duplicates
    }

    /**
     * Loads words from the given file into the dictionary.
     * @param filename - path of the dictionary file
     * @throws IOException if file not found or cannot be read
     *
     * Time Complexity: O(n log n), where n is number of words (due to TreeSet insert)
     * Space Complexity: O(n), to store all n words in memory
     */
    public void loadWords(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            dictionary.add(line.trim().toLowerCase()); // convert to lowercase to avoid case mismatch
        }
        reader.close();
    }

    /**
     * Searches if a word exists in the dictionary.
     * @param word - word to search
     * @return true if word found, false otherwise
     *
     * Time Complexity: O(log n), TreeSet provides log n search
     * Space Complexity: O(1)
     */
    public boolean searchWord(String word) {
        return dictionary.contains(word.toLowerCase());
    }

    /**
     * Suggests similar words using Levenshtein Distance
     * @param input - incorrect word
     * @return list of closest matches (up to 5)
     *
     * Time Complexity: O(n * k^2) approx, where:
     *      n = number of words in dictionary,
     *      k = average word length (for distance calc)
     * Space Complexity: O(m), where m = number of suggestions returned
     */
    public List<String> suggestWords(String input) {
        List<String> suggestions = new ArrayList<>();
        int maxDistance = 2;  // max edit distance allowed

        for (String word : dictionary) {
            if (levenshteinDistance(input.toLowerCase(), word) <= maxDistance) {
                suggestions.add(word);
            }
        }

        return suggestions.stream().limit(5).collect(Collectors.toList());
    }

    /**
     * Calculates Levenshtein distance between two strings
     * @param a - first string
     * @param b - second string
     * @return int - edit distance
     *
     * Time Complexity: O(k1 * k2), where k1 and k2 are lengths of the input strings
     * Space Complexity: O(k1 * k2), for DP table
     */
    private int levenshteinDistance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(Math.min(
                            dp[i - 1][j],     // Remove
                            dp[i][j - 1]),    // Insert
                            dp[i - 1][j - 1]  // Replace
                    );
            }
        }

        return dp[a.length()][b.length()];
    }
}
