/**
 * Use a doubly linked list and hashmap <key, node>
 * TC: get() -> O(1); put() -> O(1)
 * SC: O(capacity)
 */
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LRUCache {
    // maintain a Doubly Linked List
    Node head = new Node();
    Node tail = new Node();
    Map<Integer, Node> nodeMap;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        nodeMap = new HashMap<>(capacity);
    }
    
    public int get(int key) {
        int result = -1;
        Node node = nodeMap.get(key);
        if (node != null) {
            result = node.val;
            removeNode(node);   // remove from wherever it is
            addNode(node);      // add to front as recently accessed
        }
        return result;
    }
    
    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        if (node != null) {
            removeNode(node);
            node.val = value;
            addNode(node);
        } else {
            if (nodeMap.size() == this.capacity) {
                nodeMap.remove(tail.prev.key);
                removeNode(tail.prev);
            }
            node = new Node();
            node.val = value;
            node.key = key;
            addNode(node);
            nodeMap.put(key, node);
        }
    }
    
    // always wanna add a node to front of DLL
    public void addNode(Node node) {
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }
    
    // remove node from any place
    public void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    class Node {
        int key, val;
        Node prev, next;
    }
}
