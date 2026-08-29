package com.example.hw10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserToJson {

    public static void createJson(String inputFile, String outputFile) {
        List<User> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            reader.readLine();

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\s+");

                String name = data[0];
                int age = Integer.parseInt(data[1]);

                users.add(new User(name, age));
            }

        } catch (IOException e) {
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
    createJson(
            "src/main/resources/task2/file.txt",
            "src/main/resources/task2/user.json"
    );
    }
}
