public class Main {


    // Helper function
    static int helper(int id, int[] arr, int k, int n, int maxValueTill){
        if(k==0){
            return maxValueTill;
        }
        if(id==0)return Math.max(maxValueTill,arr[0]);
        if(id<0){
            return Integer.MAX_VALUE;
        }
        int curr = arr[id];
        int pick = helper(id-2,arr,k-1, n,Math.max(maxValueTill,curr));
        int notPick = helper(id-1,arr,k,n,maxValueTill);
        System.out.println(id + ", "+k+", "+maxValueTill+","+curr);
        return Math.min(pick,notPick);
    }
    static void helper2(int id,int k, int n,int maxValueForaSeq, int[] arr, int[] absMin){
        if(k==0){
            absMin[0] = Math.min(maxValueForaSeq,absMin[0]);
            return;
        }else if(id<0){
            // if we have exhausted the arr and still k>0 we leave that path
            return;
        }
        int curr = arr[id];
        helper2(id-2,k-1,n,Math.max(maxValueForaSeq,curr),arr,absMin);
        //nt pick
        helper2(id-1,k,n,maxValueForaSeq,arr,absMin);
    }
    // caller function
    static int getMinVul(int[] arr, int k) {
        int n = arr.length;
//        return Math.min(helper(n-1,arr,k,arr.length, Integer.MIN_VALUE),helper(n-2,arr,k,arr.length, Integer.MIN_VALUE));
        int[] absMin = new int[]{Integer.MAX_VALUE};
        helper2(n-1,k,n,Integer.MIN_VALUE,arr,absMin);
        return absMin[0];
    }
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
        /*MyHashMap mp = new MyHashMap();
        mp.put(1,"Sinchan");
        mp.put(1,"Manas");
        mp.put(2, "Rahul");
        mp.put(3, "Soumen");
        System.out.println(mp.get(1));
        System.out.println(mp.get(2));
        mp.get(2);*/
        int[] arr = new int[] {2,3,5,9};
        System.out.println("ans>> "+getMinVul(arr,2));

    }



}