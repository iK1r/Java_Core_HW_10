import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PhoneValidator {

    public static void printValidPhones(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String phone;

            while ((phone = reader.readLine()) != null) {
                if (phone.matches("\\d{3}-\\d{3}-\\d{4}")
                        || phone.matches("\\(\\d{3}\\) \\d{3}-\\d{4}")) {

                    System.out.println(phone);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        printValidPhones("task1/file.txt");
    }
}
