public class TokenBucket{
     private final long maxBucketSize;
     private final long refillRate;
     private  long currentBucketSize;
     private  long lastRefilTime;
    public TokenBucket(long maxBucketSize, long refillRate) {
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;
        //initially currentbucket size is same as maxBucketsize
        this.currentBucketSize = maxBucketSize;
        this.lastRefilTime = System.nanoTime();
    }
    
    public synchronized boolean allowRequest(long token){
        //refill the bucket first
        refill();
        //check the logic
        if(currentBucketSize >=token){
            currentBucketSize -= token;
            return true;
        }
        return false;
    }

    private void refill(){
        long now = System.nanoTime();
        long durationTillLastRefil = now - lastRefilTime;
        long requiredToken = durationTillLastRefil/refillRate;
        //currentBucket size should never cross maxSize;
        currentBucketSize = Math.min(maxBucketSize, requiredToken);
        lastRefilTime = now;
        
    }
    
}