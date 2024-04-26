import java.util.HashMap;
import java.util.Map;

class Node {
    Map<Character, Node> nodeMap;
    boolean isWordEnd = false;

    public Node() {
        nodeMap = new HashMap<>();
    }

    public boolean containsChar(char ch) {
        return this.nodeMap.containsKey(ch);
    }

    void put(char ch, Node node) {
        nodeMap.put(ch, node);
    }

    Node get(char ch) {
        return nodeMap.get(ch);
    }

    public void setEnd() {
        this.isWordEnd = true;
    }

    public boolean isEnd() {
        return this.isWordEnd;
    }
}
