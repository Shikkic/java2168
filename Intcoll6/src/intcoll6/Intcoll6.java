
package Intcoll6;


public class Intcoll6 {
    private int howmany;
    private BtNode c;
    
    public Intcoll6() {
        c = null;
        howmany = 0;
    }
    
    public Intcoll6(int i) {
        c = null;
        howmany = 0;
    }    

    public void copy(BtNode j) {
            
    }
    
    public boolean belongs(int i){
        BtNode p = c;
        while ((p!=null)&&(p.info!=i)){
            if(i > p.info){
                p = p.right;
            }else{
                p = p.left;
            }
        }
        return (p!=null);
    }
    
    public static BtNode copyTree(BtNode t){
        BtNode root = null;
        if(t!=null){
            root = new BtNode();
            root.info = t.info;
            root.left = copyTree(t.left);
            root.right = copyTree(t.right);
        }
        return root;
    }
    
    public void copy(Intcoll6 obj){
        if(this != obj){
            howmany = obj.howmany;
            c = copyTree(obj.c);
        }
    }
    
    public static boolean traverse(BtNode t, Intcoll6 obj){
        if(t!=null){
            if(traverse(t.left, obj) == false){
                return false;
            }
            if(!obj.belongs(t.info)){
                return false;
            }
            if(traverse(t.right, obj) ==false){
                return false;
            }
        }
        return true;
    }
    
    public boolean equals(Intcoll6 obj){
        BtNode p = c;
        if(this.howmany != obj.howmany){
            return false;
        }
        return traverse(p, obj);
    }
    
    public void omit(int i){
        BtNode p = c;
        BtNode pred = null;
        while(( p != null)&&(p.info !=i)){
            pred = p;
            if( i > p.info){
                p = p.right;
            }else{
                p = p.left;
            }    
        }
        if(p != null){
            if(p.left != null){           
                BtNode node = p.left;
                node.right = p.right;
                if(node.info > pred.info){
                    pred.right = node;
                }else{
                    pred.left = node;
                }
            }else if(p.right != null){
                BtNode node = p.right;
                if(node.info > pred.info){
                    pred.right = node;
                }else{
                    pred.left = node;
                }
            }else{
                if(p.info > pred.info){
                    pred.right = null;
                }else{
                    pred.left = null;
                }
            }
        howmany--;
        }
    }
   
    public void insert(int i) {
        BtNode p = c;
        BtNode pred = null;
        while((p != null) && (p.info != i)) {
            pred = p;
            if (i > p.info)
                p = p.right;
            else
                p = p.left;
        }
        if (p == null) {
            p = new BtNode();
            p.info = i;
            howmany++;
            }
        if (pred != null) {
            if(pred.info > i) 
                pred.left = p;
            else 
                pred.right = p;
        } else {
            c = p;
        }
    }

    public void print() {
        printtree(c);
    }
    
    public static void printtree(BtNode t) {
        if(t != null) {
            printtree(t.left);
            System.out.println(t.info);
            printtree(t.right);
        }
    }
    
    public int get_howmany(){
       return howmany;
    }
    
    public static void main(String[] args){
        Intcoll6 Sri = new Intcoll6();
        Sri.insert(600);
        Sri.insert(10);
        Sri.insert(100);
        Sri.insert(99999);
        Sri.insert(1);
        Sri.insert(2);
        Sri.insert(6);
        
        Intcoll6 Dan = new Intcoll6();
        Dan.insert(6);
        Dan.insert(10);
        Dan.insert(11);
        Dan.insert(99);
        Dan.insert(4);
        Dan.insert(7);
        Dan.insert(69);
        
        Dan.copy(Sri);
        if(Dan.equals(Sri)){
            System.out.println("CODY MAZING DOG,man");
        }
        if(Sri.belongs(3)){
            System.out.println("It worked man!");
        }
        
        Sri.print();
        Dan.print();
    }
    
    static class BtNode {
        int info;
        BtNode left;
        BtNode right;
    
        private BtNode() {
            info = 0;
            left = null;
            right = null;
        }
    
        private BtNode(int i, BtNode Lt, BtNode Rt) {
            info = i;
            left = Lt;
            right = Rt;
        }
    }
    
}