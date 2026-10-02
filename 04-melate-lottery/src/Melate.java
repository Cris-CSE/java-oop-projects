import java.util.ArrayList;   // Collection to store the winner numbers.
import java.util.Random;      // With this class we can generate random numbers.
import java.io.FileWriter;    // To create txt files.
import java.io.PrintWriter;   // Make easier to write formatted text.
import java.io.IOException;   // Exception type class (Will be useful if something goes wrong).

//Public class Melate that defines the application.
public class Melate {

    public static void main(String[] args) {

        //1. This ArrayList contains the 7 winner numbers.
        ArrayList<Integer> numberList = new ArrayList<>();

        //2. Creating the random number generator from the standar Java library.
        Random random = new Random();

        //3. Sets a limit of numbers up to 7.
        while (numberList.size() < 7) {

            // random.nextInt(56) generates numbers between 0 and 55 (Because it counts 0 as a number).
            // To solve this we add 1 to the line.
            int randomNumber = random.nextInt(56) + 1;


            // The contains() method of ArrayList checks if the element already exists.
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }

        //4. Show in the console the generated numbers.
        System.out.println("Melate winning numbers: " + numberList);

        //5. The list is saved in a persistent text file.
        try {
            // FileWriter opens or create a doc called "melate_numbers.txt"
            FileWriter file = new FileWriter("melate_numbers.txt");
            PrintWriter writer = new PrintWriter(file);

            writer.println("Melate winning numbers:");

            for (int number : numberList) {
                writer.println(number);
            }

            // We closed the writer to ensure that the data was saved to disk.
            writer.close();

            System.out.println("Numbers successfully saved to melate_numbers.txt");

        } catch (IOException e) {
            // If an error occurs while creating or writing the file, we capture it here 
            // instead of letting the program stop abruptly.
            System.out.println("An error occurred while writing the file: " + e.getMessage());
        }
    }
}
