
package intcoll2;


public class Intcoll2 {
    
    private int[] c;
    private int howmany;

    //Constructor that automatically intializes with 500 spaces
    public Intcoll2(){
        c = new int[500];
        howmany = 0;
    }

    //Constructor that automatically intializes with however many i
    public Intcoll2(int i){
        c = new int[i];
        howmany = 0;
    }

    /* if the objects are not equal already, it will copy the all the elements 
    from one obj into another*/
    public void copy(Intcoll2 obj){
      	if (this != obj){
            int[] e = new int[obj.c.length];
		int j = 0;
		while (j < howmany)
		{
			e[j] = obj.c[j]; j++;
		}
                this.howmany = obj.get_howmany();
		c = e;
	}
    }
   
    // 
    public boolean belongs(int i){
      	int j = 0;
      	while((j < howmany)&&(c[j]!=i))j++;
      	return ((i>0)&&(c[j] == i));
    }
    
    public void insert(int i){
        if(i > 0){
            int j = 0;
            while ((j < howmany ) && (c[j] != i)) j++;
                if( j == howmany){
                    if (j == c.length - 1){
                        //if array too small, make new array double size
                        //Then copy all the values of the area into the new area
                        int array2[] = new int[2 * c.length];
                        for(int z = 0;(z < c.length); z++ ){
                            array2[z] = c[z];
                        }
                        c = array2;
                    }
                 c[j] = i;
                 howmany++;
                }   
        }
    }

    
    public void omit(int i){
	if (i>0)
	{
            int j = 0;
            while ((j < howmany)&&(c[j] != i)) j++;
            if (c[j] == i)
            {
                int k = j+1;
                while (k < howmany) k++;
                c[j] = c[k-1];
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
        while((j < howmany)){
            System.out.println(c[j]);
            j++;
        }
    }
    
    //Determines if the objs are equal to each other
    public boolean equals(Intcoll2 obj){
      	int j = 0; boolean result = true;
        if(obj.howmany == this.howmany){
            while ((j < howmany)&&result)
            {
                    result = obj.belongs(c[j]); j++;
            }
        }else{
            result = false;
        }
        return result;
    }
    
   
        
    public static void main(String[] args){
        Intcoll2 C = new Intcoll2();
        Intcoll2 D = new Intcoll2(2);
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
        if (C.equals(D)) System.out.println("\nC and D are not equal.");
        C.copy(D);
        if (C.equals(D)) System.out.println("\nC and D are equal after copy.");
        if (C.belongs(100)) System.out.println("\nCollection C includes an integer 100."); 
    }
    
}
