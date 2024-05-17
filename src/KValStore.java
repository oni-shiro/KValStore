import java.util.HashMap;

public class KValStore<K,V> {
    private K key;
    private V value;
    private static int INITIAL_SIZE = 1000;
    private V[] arr;
    public KValStore(K key, V value, V[] arr) {
        this.key = key;
        this.value = value;
        this.arr = arr;
    }

    public KValStore() {
        this.arr = (V[]) new Object[INITIAL_SIZE];
    }
    /*
    Main functinality
     */

    public void add(K key, V value){
        int actualKey = 0;
        if (key.getClass() == String.class){
            actualKey = hashFunctionForString((String)key);
        }
        arr[actualKey] = value;
    }

    public V get(K key){
        int actualKey = 0;
        if (key.getClass() == String.class){
            actualKey = hashFunctionForString((String)key);
        }
        return arr[actualKey];

    }




   /*
   Hashing function for a string
    */

    private int hashFunctionForString(String key){
        int size = key.length();
        char[] ca = key.toCharArray();
        long mul = 1;
        long sum = 0;

        for(int i = 0;i<size;i++){
           mul = (i==4)?1:mul*256;

           sum += ca[i]*mul;
        }
        return (int) sum%INITIAL_SIZE;
    }


}
