import java.util.HashMap;
import java.util.Map;

public class CharacterSequence {
    Map<Character, CharacterSequence> charMap;
    boolean isWordEnd = false;

    public CharacterSequence() {
        charMap = new HashMap<>();
    }

    public boolean containsChar(char ch) {
        return this.charMap.containsKey(ch);
    }

    void put(char ch, CharacterSequence node) {
        charMap.put(ch, node);
    }

    CharacterSequence get(char ch) {
        return charMap.get(ch);
    }

    public void setEnd() {
        this.isWordEnd = true;
    }

    public boolean isEnd() {
        return this.isWordEnd;
    }
}
