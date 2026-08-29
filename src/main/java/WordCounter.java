import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {

    public static void countWords(String fileName) {
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("\\s+");

                for (String word : lineWords) {
                    if (wordCount.containsKey(word)) {
                        wordCount.put(word, wordCount.get(word) + 1);
                    } else {
                        wordCount.put(word, 1);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        List<String> words = new ArrayList<>(wordCount.keySet());

        for (int i = 0; i < words.size() - 1; i++) {
            for (int j = i + 1; j < words.size(); j++) {

                if (wordCount.get(words.get(j)) > wordCount.get(words.get(i))) {
                    String temp = words.get(i);
                    words.set(i, words.get(j));
                    words.set(j, temp);
                }
            }
        }

        for (String word : words) {
            System.out.println(word + " " + wordCount.get(word));
        }
    }

public static void main(String[] args) {
    countWords("src/main/resources/task3/words.txt");
}
