import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private CharacterSequence root;

    public Dictionary() {
        this.root = new CharacterSequence();
    }

    // Time Complexity -> O(word.length)
    // Space Complexity -> O(number of characters in each word + number of words * avg length of words)
    public void insert(String word) {
        CharacterSequence characterSequence = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (!characterSequence.containsChar(word.charAt(i))) {
                characterSequence.put(word.charAt(i), new CharacterSequence());
            }
            characterSequence = characterSequence.get(word.charAt(i));
        }
        characterSequence.setEnd();
    }

    // Time Complexity -> O(word.length)
    public String search(String word) {
        CharacterSequence characterSequence = this.root;
        StringBuilder foundWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (!characterSequence.containsChar(word.charAt(i))) {
                // Word not found, return the list of suggested word
                return this.suggestedWord(characterSequence).toString();
            }
            characterSequence = characterSequence.get(word.charAt(i));
            foundWord.append(word.charAt(i));
        }
        if (characterSequence.isEnd()) {
            // Word found, return the entire word
            return foundWord.toString();
        }
        // Word Not found, return the list of suggested word
        return this.suggestedWord(characterSequence).toString();
    }

    private void traverse(CharacterSequence characterSequence, StringBuilder prefix, List<String> suggestions) {
        if (characterSequence.isEnd()) {
            suggestions.add(prefix.toString());
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (characterSequence.containsChar(ch)) {
                prefix.append(ch);
                traverse(characterSequence.get(ch), prefix, suggestions);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
    }

    private List<String> suggestedWord(CharacterSequence characterSequence) {
        List<String> suggestedWordList = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();
        traverse(characterSequence, prefix, suggestedWordList);
        return suggestedWordList;
    }
}
