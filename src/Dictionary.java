import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private Node root;

    public Dictionary() {
        this.root = new Node();
    }

    // Time Complexity -> O(word.length)
    public void insert(String word) {
        Node node = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsChar(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    // Time Complexity -> O(word.length)
    public String search(String word) {
        Node node = this.root;
        StringBuilder foundWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsChar(word.charAt(i))) {
                // Word not found, return the list of suggested word
                return this.suggestedWord(node).toString();
            }
            node = node.get(word.charAt(i));
            foundWord.append(word.charAt(i));
        }
        if (node.isEnd()) {
            // Word found, return the entire word
            return foundWord.toString();
        }
        // Word Not found, return the list of suggested word
        return this.suggestedWord(node).toString();
    }

    private void traverse(Node node, StringBuilder prefix, List<String> suggestions) {
        if (node.isEnd()) {
            suggestions.add(prefix.toString());
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (node.containsChar(ch)) {
                prefix.append(ch);
                traverse(node.get(ch), prefix, suggestions);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
    }

    private List<String> suggestedWord(Node node) {
        List<String> suggestedWordList = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();
        traverse(node, prefix, suggestedWordList);
        return suggestedWordList;
    }
}
