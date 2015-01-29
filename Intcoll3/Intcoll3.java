
package intcoll3;


public class Intcoll3 {
    
    private boolean[] c;
    private int howmany;

    //Constructor that automatically intializes with 500 spaces
    public Intcoll3(){
        c = new boolean[501];
        howmany = 0;
    }

    //Constructor that automatically intializes with however many i
    public Intcoll3(int i){
        c = new boolean[i+1];
        howmany = 0;
    }

    /* if the objects are not equal already, it will copy the all the elements 
    from one obj into another*/
    public void copy(Intcoll3 obj){
      	if (this != obj){
            boolean[] e = new boolean[obj.c.length];
		int j = 0;
		while (j < obj.c.length)
		{
                    e[j] = obj.c[j]; j++;
		}
                this.howmany = obj.get_howmany();
		c = e;
	}
    }
   
    public boolean belongs(int i){
      	return c[i];
    }
    
    public void insert(int i){
        if(i > 0){
            if (i >= c.length){
                //if array too small, make new array double size
                //Then copy all the values of the area into the new area
                boolean array2[] = new boolean[2 * i];
                for(int z = 0;(z < c.length); z++ ){
                    array2[z] = c[z];
                }
                c = array2;  
            }
            if(c[i] == false){
                c[i] = true;
                howmany++;
            }
        }
    }

    public void omit(int i){
	if (i>0)
	{
            if (c[i] == true){
                c[i] = false;
                howmany--;
            }
	}
    }

    public int get_howmany(){
      	return howmany;
    }

    // Prints all the elements in the array
    public void print(){
        int j = 0;
        while((j < c.length)){
            if(c[j] == true){
                System.out.println(j);
            }
            j++;
        }
    }
    
    /*Determines if the objs are equal to each other*/
    public boolean equals(Intcoll3 obj){
      	int j = 0; boolean result = true;
        if(obj.howmany == this.howmany){
            while ((j < c.length)&&result)
            {
                if(c[j] == obj.c[j]){
                result = true; j++;
                }
            }
        }else{
            result = false;
        }
        return result;
    }
        
    public static void main(String[] args){
        Intcoll3 C = new Intcoll3();
        Intcoll3 D = new Intcoll3(2);
        
        C.copy(D);
        System.out.println("\nThe number of elements in a collection D is:\n");
        System.out.println(D.get_howmany());
        
        for (int i=10;i<=100;i+=10)
        {
            D.insert(i);
            C.insert(i);
        }
        for (int i=20;i<=100;i+=20)
        {
            D.omit(i);
        }
        
        System.out.println("\nThe values in the collection D after insertion and omition are:\n");
        D.print();
        
        System.out.println("\nThe values in the collection C after insertion and omition are:\n");
        C.print();
        
        /* Ask Tatyana if this is correct */
        if (!(C.equals(D))) System.out.println("\nC and D are not equal.");
        C.copy(D);
        
        if (C.equals(D)) System.out.println("\nC and D are equal after copy.");
        
        if (C.belongs(100)) System.out.println("\nCollection C includes an integer 100."); 
    }    
}
