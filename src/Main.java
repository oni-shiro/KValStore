public class Main {
    public static void main(String[] args) {
        KValStore<String,String> kv = new KValStore<>();
        kv.add("name","Sinchan");

        kv.add("age","25");
        kv.add("gender","Male");
        kv.add("prof","Engineer");


        System.out.println(kv.get("gender"));
        System.out.println(kv.get("age"));
        System.out.println(kv.get("name"));
        System.out.println("Hello world!");
    }



}