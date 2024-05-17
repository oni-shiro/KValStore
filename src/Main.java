public class Main {
    public static void main(String[] args) {
/*
        KValStore<String,String> kv = new KValStore<>();
        kv.add("name","Sinchan");

        kv.add("age","25");
        kv.add("gender","Male");
        kv.add("prof","Engineer");


        System.out.println(kv.get("sdkfjd"));
        System.out.println(kv.get("age"));
        System.out.println(kv.get("name"));
        System.out.println("Hello world!");
*/


        //CustomHashMap
        MyHashMap mp = new MyHashMap();
        mp.put(1,"Sinchan");
        mp.put(1,"Manas");
        mp.put(2, "Rahul");
        mp.put(3, "Soumen");
        System.out.println(mp.get(1));
        System.out.println(mp.get(2));
        mp.get(2);
    }



}