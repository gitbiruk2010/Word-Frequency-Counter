import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        //normal test cases
        String[] normalTestCases = {
                "Scratch my back and i will scratch yours",
                "Mountain mountain MOUNTAIN",
                "AD ad AD ad AD AD ad AD"
        };

        //edge test cases
        String[] edgeTestCases = {
                "",
                "what   is  your    name",
                "Hello! How are you? Hello."
        };

        //running normal test cases
        System.out.println("=== Normal Test Cases ===");
        for (int i = 0; i < normalTestCases.length; i++) {
            System.out.println("\nTest Case " + (i + 1) + ":");
            System.out.println("Input: \"" + normalTestCases[i] + "\"");

            //calculate word frequencies
            Map<String, Integer> wordFrequencies = calculateWordFrequencies(normalTestCases[i]);

            //display results
            System.out.println("Word Frequencies:");
            for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

        //running edge test cases
        System.out.println("\n=== Edge Test Cases ===");
        for (int i = 0; i < edgeTestCases.length; i++) {
            System.out.println("\nTest Case " + (i + 1) + ":");
            System.out.println("Input: \"" + edgeTestCases[i] + "\"");

            //calculate word frequencies
            Map<String, Integer> wordFrequencies = calculateWordFrequencies(edgeTestCases[i]);

            //print the results
            System.out.println("Word Frequencies:");
            for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    //method to calculate word frequencies
    public static Map<String, Integer> calculateWordFrequencies(String inputText) {
        //split the input text into words
        //the regex "\\s+" splits the text by one or more spaces (handles multiple spaces)
        String[] words = inputText.split("\\s+");

        //create a HashMap to store word frequencies
        //keys: Words (String)
        //frequency counts (Integer)
        HashMap<String, Integer> wordFrequencies = new HashMap<>();

        //process each word
        for (String word : words) {
            //skip empty strings (in case of multiple spaces)
            if (word.isEmpty()) continue;

            //normalizing the word to lowercase for case-insensitive counting
            String normalizedWord = word.toLowerCase();

            //updading the frequency count in the HashMap
            //if the word is already in the map, increment its count
            //if the word is not in the map, add it with a count of 1
            wordFrequencies.put(normalizedWord,
                    wordFrequencies.getOrDefault(normalizedWord, 0) + 1);
        }

        //sorting the results alphabetically using a treeMap
        //it automatically sorts entries by their keys

        //returning sorted results
        return new TreeMap<>(wordFrequencies);
    }
}