import java.util.Arrays;

class Node{
    Object key;
    Object val;
    Node next;
    public Node(Object key, Object val){
        this.key = key;
        this.val = val;
    }

    public Node() {

    }
}
public class MyHashMap {
    int size = 10001;
    Node[] arr;

    public MyHashMap(){
        this.arr = new Node[size];
        Arrays.fill(arr, new Node());
    }
    public void put(Object key, Object val){
        int hashKey = key.hashCode();
        int actualKey = hashKey%size;
        Node head = arr[actualKey];
        //we are always inserting after head
        Node lastInserted = null;
        if(head.next!=null){
            lastInserted = head.next;
        }
        head.next = new Node(key,val);
        if(lastInserted!=null){
            head.next.next = lastInserted;
        }
    }
     public Object get(Object key){

        int requiredHasKey = (key.hashCode())%size;
        Node head = arr[requiredHasKey];
        Node temp = head.next;
        while(temp.key !=key && temp!=null){
            temp = temp.next;
        }
        return temp.val!=null?temp.val:-1;
     }
     public void remove(Object key){
         int requiredHasKey = (key.hashCode())%size;
         Node head = arr[requiredHasKey];
         Node temp = head.next;

         while(temp.key !=key && temp!=null){
             temp = temp.next;
         }
         // overwriting the value;
         temp.key = temp.next.key;
         //removing the previous value
         temp.val = temp.next.val;
         temp.next = temp.next.next;
     }
}
