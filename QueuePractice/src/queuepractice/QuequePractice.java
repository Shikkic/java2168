package queuepractice;

public class QuequePractice {
    quequeNode c;
    
    public QuequePractice(){
        c = null;
    }
    
    public QuequePractice(int i){
        enque(i);
    }
    
    public void enque(int i){
        if(i>0){
            quequeNode p = c;
            c = new quequeNode(i);
            c.link = p;
        }else{
            System.out.println("You've entered a negative number! Try again");
        }
    }
    
    public int deque(){
        if(c != null){
            quequeNode p = c;
            quequeNode pred = null;
            if(p.link == null){
                c = null;
                return p.info;
            }
            while(p.link != null){
                pred = p;
                p = p.link;
            }
            pred.link = null;
            return p.info;
        }else{
            System.out.println("The queue is null! There is nothing to deque!");
            return 0;
        }     
    }
    
    public int peek(){
        if(c != null){
            quequeNode p = c;
            while(p.link != null){
                p = p.link;
            }
            return p.info;
        }else{
            System.out.println("queue is null! Nothing to return");
        }
        return 0;
    }
    
    public void print(){
        if(c != null){
            quequeNode p = c;
            while(p != null){
                System.out.println(p.info);
                p = p.link;
            }
        }else{
            System.out.println("Queue is empty, nothing to print!");
        }
    }
    
    class quequeNode{
        int info;
        quequeNode link;
        
        public quequeNode(){
            info = 0;
            link = null;
        }
        
        public quequeNode(int i){
            info = i;
            link = null;
        }
    }
    
    public static void main(String[] args) {
        //TEST CASE
        //Intializing with no parameters
        QuequePractice Queue = new QuequePractice();
        
        //engueing 4 elements
        Queue.enque(3);
        Queue.enque(2);
        Queue.enque(1000);
        Queue.enque(99999);
        System.out.println("");
        
        //Printing all four elements
        System.out.println("There should be four elements!");
        Queue.print();
        System.out.println("");
         
        //Dequeing all four
        System.out.println("Now let's pop them all");
        Queue.deque();
        Queue.deque();
        Queue.deque();
        Queue.deque();
        
        //Print should reveal null stack
        Queue.print();
        System.out.println("");
        
        //Now we try to deque a null set it should return 0 and error message
        Queue.deque();
        
        //Now lets push 4 numbers and pop it's value and display it to the user
        System.out.println("Now lets add four numbers and deque the last one");
        Queue.enque(3);
        Queue.enque(2);
        Queue.enque(1000);
        Queue.enque(99999);
        
        System.out.println("Before the enque");
        Queue.print();
        System.out.println("");
        System.out.println("Deque and the value is: "+Queue.deque());
        
        //Now we push a negative number
        System.out.println("");
        System.out.println("Now lets enque a number less than 0");
        Queue.enque(-1);    
    }  
}
