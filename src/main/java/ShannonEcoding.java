import java.util.HashMap;
import java.util.Map;

public class ShannonEcoding {

    static Map<String, Long> findWords(final String text, int wordLength) throws IllegalArgumentException {
        Map<String, Long> words = new HashMap<>();

        if (wordLength < 1) {
            throw new IllegalArgumentException("Word length must be greater than zero");
        }

        for (int i = 0; i <= text.length() - wordLength; i++) {
            String word = text.substring(i, i + wordLength);

            word = word.replaceAll("[-,?!;:]", ".").toLowerCase();
            if (words.keySet().contains(word)) {
                words.put(word, words.get(word) + 1L);
            } else {
                words.put(word, 1L);
            }
        }

        return words;
    }

    static Map<String, Double> calcProbs(Map<String, Long> words) {
        Map<String, Double> probs = new HashMap<>();

        if (words == null || words.size() == 0) {
            throw new IllegalArgumentException("Words is an empty set");
        }

        words.forEach((key, val) -> {
            Double prob = (double) val / (double) words.size();
            probs.put(key, prob);
        });

        return probs;
    }
}
