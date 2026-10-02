# 04 · Melate Lottery

Generates **7 unique random numbers between 1 and 56** (inspired by Mexico's *Melate* lottery), prints them and saves them to a text file.

## Concepts practiced
- Collections: `ArrayList<Integer>`
- Random number generation with `java.util.Random`
- Avoiding duplicates with `contains()`
- Writing files with `FileWriter` and `PrintWriter`
- Exception handling with `try / catch (IOException)`

## How to run

```bash
cd src
javac Melate.java
java Melate
```

## Example output

```
Melate winning numbers: [54, 32, 23, 17, 52, 38, 27]
Numbers successfully saved to melate_numbers.txt
```

A file named `melate_numbers.txt` is created in the folder where the program runs.

## Possible improvements
- Use a `HashSet` for faster duplicate checks
- Sort the numbers before displaying them
- Use *try-with-resources* to close the file automatically
