package frequencyCharacters;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FrequencyCharacters {
    double frequency = 0;
    char character = ' ';
    Map<Character, Double> unSortedMap = new HashMap<Character, Double>();

    char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'y', 'z'};

    public Map<Character, Double> frequency(String text) {
        int textLength = text.length();
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isLetter(text.charAt(i))) {
                textLength--;
            }

        }
        for (int i = 0; i < alphabet.length; i++) {
            frequency = 0;
            for (int j = 0; j < text.length(); j++) {
                character = text.toLowerCase().charAt(j);
                if (character == alphabet[i]) {
                    frequency++;
                }
            }
            frequency = (frequency / textLength) * 100;
            unSortedMap.put(alphabet[i], frequency);
        }
        LinkedHashMap<Character, Double> reverseSortedMap = new LinkedHashMap<>();
        unSortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        return reverseSortedMap;
    }
}