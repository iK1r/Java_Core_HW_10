import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserToJson {

    public static void createJson(String inputFile, String outputFile) {
        List<User> users = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(inputFile))) {

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split("\\s+");

                String name = data[0];
                int age = Integer.parseInt(data[1]);

                users.add(new User(name, age));
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(users);

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        createJson("task2/file.txt", "task2/user.json");
    }
}
