class CircularQueue {
    //Initialize some variables
    private int length;
    private int start;
    private int end;
    private volatile int arr[];//volatile for thread safety. Multiple threads can run through it and it wont be cached for each thread.
    
    public CircularQueue(int l) {
        //Constructor with length argument
        length = l+1;
        arr = new int[l+1];
        start = 0;
        end = 0;
    }
    public synchronized void initialize() {
        start = 0;
        end = 0;
    }
    public synchronized boolean enqueue(int v) {
        int tmp =  (end+1) % length;
       
        //Queue being full in this case.
        if (tmp == start) return false;
        
        //Otherwise add it at end
        arr[end] = v;
        end = tmp;
        return true;
    }
    public synchronized int dequeue() throws Exception{
        if (start == end) throw new Exception("No More Elements in Queue");
        int tmp = arr[start];
        
        start = (start + 1) % length;
        return tmp;
    }
}

public class CircularQueueMain{
    //Basically a test method with input elements for the queue.
    public static void main(String args[]){
        CircularQueue cq = new CircularQueue(7);
        for(int i=1; i<=18; i+=2){
            boolean result = cq.enqueue(i);
            System.out.println("Added the element "+i+" : "+result);
        }
        System.out.println("Output from the queue : ");
        try{
            while(true){
                System.out.println("Dequed the element "+cq.dequeue());
            } 
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
       
    }
}