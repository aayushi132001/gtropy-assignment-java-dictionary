------------------------------------------------------------
        GTROPY SD-I ASSIGNMENT SUBMISSION (Aayushi Solanki)
------------------------------------------------------------

📁 Project Name: Java Dictionary Search System

👨‍💻 Developer: Aayushi Solanki  
📧 Email: 13aayushisolanki@gmail.com  
🌐 GitHub: https://github.com/aayushi132001

------------------------------------------------------------
🔍 DESCRIPTION
------------------------------------------------------------

This is a command-line Java application that simulates a dictionary search system. It allows users to:
- Search words from a predefined dictionary (provided in 'dictionary_words.txt').
- Get suggested words when there is a typo or misspelling in the input.
- Handles all corner cases like empty input, case mismatch, and file errors.

------------------------------------------------------------
📦 FILE STRUCTURE
------------------------------------------------------------

| File Name              | Purpose                                      |
|------------------------|----------------------------------------------|
| DictionaryApp.java     | Main class for user interaction              |
| DictionarySearch.java  | Core logic for search and suggestions        |
| dictionary_words.txt   | Wordlist file (converted from list.txt)      |
| run.bat                | Windows batch file to compile and run        |
| README.txt             | Project summary and usage instructions       |

------------------------------------------------------------
🛠 HOW TO RUN
------------------------------------------------------------

Step 1: Make sure Java is installed and added to system PATH.

Step 2: Place all files in the same folder.

Step 3: Double-click `run.bat` or run from terminal:
        > run.bat

Step 4: Enter a word when prompted.

To exit: Type `exit` and press Enter.

------------------------------------------------------------
🧠 TIME AND SPACE COMPLEXITY
------------------------------------------------------------

| Function              | Time Complexity     | Space Complexity    |
|-----------------------|---------------------|---------------------|
| loadWords()           | O(n log n)          | O(n)                |
| searchWord()          | O(log n)            | O(1)                |
| suggestWords()        | O(n * k^2) approx   | O(m) (suggestions)  |
| levenshteinDistance() | O(k1 * k2)          | O(k1 * k2)          |

n = total words in dictionary  
k = average word length  
m = number of close matches

------------------------------------------------------------
✅ FEATURES
------------------------------------------------------------

✔ Efficient dictionary word search using TreeSet  
✔ Handles typos via Levenshtein Distance suggestions  
✔ Case-insensitive input  
✔ Corner case management (empty string, invalid file, not found, etc.)  
✔ Structured, readable code with logical naming  
✔ Ready-to-run on any Windows system  

------------------------------------------------------------
📣 NOTES
------------------------------------------------------------

This project is built purely in Java.
------------------------------------------------------------
