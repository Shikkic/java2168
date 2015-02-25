
package stackpractice;

public class StackPractice {
    
    StackNode c = null;
    StackNode link = null;
    int howmany = 0;
    
    public StackPractice(int i){
        push(i);
    }
    
    public StackPractice(){
    }
    
    public void push(int i){
        if(i > 0){
            if(c != null){
                StackNode p = c;
                StackNode pred = null;
                while(p != null){
                    pred = p;
                    p = p.link;
                }
                
                p = new StackNode(i);
                pred.link = p; 
                
            }else{
                c = new StackNode(i);
            }         
        howmany++; 
        }else{
             System.out.println("You've entered a number less than 0! Nothing has"
                + "been added to the stack, try again!");
        }
    }
   
    public int pop(){
        if(c != null){
            StackNode p = c;
            StackNode pred = null;
            //StackNode pred2 = null;
            if(p.link == null){
                c = null;
                howmany--;
                return p.info;
            }
            while(p.link != null){
                //pred2 = pred;
                pred = p;
                p = p.link;
            }
            pred.link = null;
            howmany--;
            return p.info;
        }
        System.out.println("Nothing to pop!");
        return 0;
    }
    
    public void print(){
        if(c != null){
            StackNode p = c;
            while(p != null){
                System.out.println(p.info);
                p = p.link;
            }
        }else{
            System.out.println("The stack is null");
        }    
        System.out.println("Howmany is: "+howmany);
    }
    
    public class StackNode{
        int info;
        StackNode link;
        
        public StackNode(){
            info = 0;
            link = null;
        }
        
        public StackNode(int i){
            info = i;
            link = null;
        }
    }
    
    public static void main(String[] args) {
        //TEST CASE
        //Intializing with no parameters
        StackPractice Stack1 = new StackPractice();
        
        //Pushing 4 elements
        Stack1.push(3);
        Stack1.push(2); 
        Stack1.push(1000);
        Stack1.push(99999);
        System.out.println("");
        
        //Printing all four elements
        System.out.println("There should be four elements!");
        Stack1.print();
        System.out.println("");
         
        //Poping all four
        System.out.println("Now let's pop them all");
        Stack1.pop();
        Stack1.pop();
        Stack1.pop();
        Stack1.pop();
        
        //Print should reveal null stack
        Stack1.print();
        System.out.println("");
        
        //Now we try to pop a null set it should return 0 and error message
        Stack1.pop();
        
        //Now lets push 4 numbers and pop it's value and display it to the user
        System.out.println("Now lets add four numbers and pop the last one");
        Stack1.push(3);
        Stack1.push(2); 
        Stack1.push(1000);
        Stack1.push(99999);
        System.out.println("Before the pop");
        Stack1.print();
        System.out.println("");
        System.out.println("Popping Stack and the value is: "+Stack1.pop());
        
        //Now we push a negative number
        System.out.println("");
        System.out.println("Now lets push a number less than 0");
        Stack1.push(-1);   
    }
    
}
