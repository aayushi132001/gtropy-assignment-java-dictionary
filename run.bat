@echo off
echo [✔] Compiling Java files...
javac DictionaryApp.java DictionarySearch.java

if %ERRORLEVEL% == 0 (
    echo [🚀] Running Java Dictionary App...
    java DictionaryApp dictionary_words.txt
) else (
    echo [❌] Compilation failed.
)
pause
