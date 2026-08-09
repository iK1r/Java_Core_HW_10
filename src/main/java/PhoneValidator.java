import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhoneValidator {

    public static void printValidPhones(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {

            while (scanner.hasNextLine()) {
                String phone = scanner.nextLine();

                if (phone.matches("\\d{3}-\\d{3}-\\d{4}")
                        || phone.matches("\\(\\d{3}\\) \\d{3}-\\d{4}")) {

                    System.out.println(phone);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        printValidPhones("task1/file.txt");
    }
}
