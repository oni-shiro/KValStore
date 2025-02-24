
class Node{
    int key;
    int val;
    Node next;
    Node prev;

    public Node(){

    }
    public Node(int key,int val){
        this.val = val;
        this.key = key;
    }
    
}
class LRUCache {

    Map<Integer,Node> mp;
    int maxCapacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        mp = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.maxCapacity = capacity;
    }

    private void add(Node node){
        mp.put(node.key,node);
        Node currRecent = head.next;
        node.next = currRecent;
        node.prev = head;
        head.next = node;
        currRecent.prev = node;
    }
    private void remove(Node node){
        if(!mp.containsKey(node.key)){
            return;
        }
        mp.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public int get(int key) {
        if(!mp.containsKey(key)) return -1;
        Node node = mp.get(key);
        remove(node);
        add(node);
        return node.val;
    }
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            remove(mp.get(key));
        }
        if(mp.size() == maxCapacity){
            remove(tail.prev);
        }
        add(new Node(key,value));
    }
}