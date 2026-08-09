import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {

    public static void countWords(String fileName) {
        Map<String, Integer> wordCount = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {

            while (scanner.hasNext()) {
                String word = scanner.next();

                if (wordCount.containsKey(word)) {
                    wordCount.put(word, wordCount.get(word) + 1);
                } else {
                    wordCount.put(word, 1);
                }
            }

        } catch (FileNotFoundException e) {
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
        countWords("task3/words.txt");
    }
}
