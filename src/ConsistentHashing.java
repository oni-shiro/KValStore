import java.util.TreeMap;

class ConsistentHashing{

    private final Map<Long,T> ring;
    private int numberOfReplicas;
    private List<String> physicalServers; //originally this should be server object
    private final Object hashFunction; // originally this should be a class consisting of the hash function i.e murmur

    public ConsistentHashing(List<String> servers, int replicas, Object hashFunction){
        this.ring = new TreeMap<>(); //initialze the ring
        this.numberOfReplicas = replicas;
        this.hashFunction =  hashFunction;
        for(String server : servers){
            addserver(server);
        }
    }

    private void addserver(String server){
        for(int i = 0;i<numberOfReplicas;i++){
            long hash = this.hashFunction.hash(server + i);
            ring.put(hash,server);
        }
    } 
    //remove server works same as addserver

    public String getServerName(String key){
        if(ring.isEmpty()){
            return null;
        }
        long hash = this.hashFunction.hash(key);
        long keyHash;
        if(ring.ceilingKey(hash)==null){
            keyHash = ring.firstKey();
        }else{
            keyHash = ring.ceilingKey(hash);
        }
        return ring.get(keyHash);
    }


}