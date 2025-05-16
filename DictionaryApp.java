import java.io.*;
import java.util.*;

public class DictionaryApp {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("[USAGE] java DictionaryApp <dictionary_file>");
            return;
        }

        DictionarySearch ds = new DictionarySearch();

        try {
            ds.loadWords(args[0]);
            System.out.println("[INFO] Dictionary loaded successfully.");
        } catch (IOException e) {
            System.out.println("[ERROR] Failed to load dictionary: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\n[INPUT] Enter a word to search (or type 'exit' to quit): ");
            String input = scanner.nextLine().trim();

            // Corner Case: Empty input
            if (input.isEmpty()) {
                System.out.println("[WARNING] Input is empty. Please enter a valid word.");
                continue;
            }

            if (input.equalsIgnoreCase("exit"))
                break;

            // Search word in dictionary
            if (ds.searchWord(input)) {
                System.out.println("[FOUND] Word found in dictionary.");
            } else {
                System.out.println("[NOT FOUND] Word not found.");
                List<String> suggestions = ds.suggestWords(input);
                if (!suggestions.isEmpty()) {
                    System.out.println("[SUGGESTIONS] Did you mean: " + String.join(", ", suggestions));
                } else {
                    System.out.println("[NO SUGGESTIONS] No similar words found.");
                }
            }
        }

        scanner.close();
        System.out.println("[INFO] Program exited.");
    }
}
