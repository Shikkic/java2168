
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
            c = new int[obj.c.length];
		int j = 0;
		while (j != c.length -1)
		{
			c[j] = obj.c[j]; j++;
		}
		//c[j] = 0;
	}
    }
   
    // 
    public boolean belongs(int i){
      	int j = 0;
      	while ((c[j] != 0)&&(c[j] != i)) j++;
      	return ((i>0)&&(c[j] == i));
    }
    
    public void insert(int i){
        if(i < 0){
            int j = 0;
            while ((c[j] > 0) && (c[j] != i)) j++;
            if (c[j] == 0){
                if (j == c.length - 1){
                    //if array too small, make new array double size
                    //Then copy all the values of the area into the new area
                    int array2[] = new int[2 * c.length];
                    for(int z = 0;(z < c.length); z++ ){
                        array2[z] = c[z];
                    }
                    c = array2;
                }
            c[j] = i; c[j + 1] = 0;
            }
        }
    }

    
    public void omit(int i){
	if (i>0)
	{
            int j = 0;
            while ((c[j] != 0)&&(c[j] != i)) j++;
            if (c[j] == i)
            {
                int k = j+1;
                while (c[k] != 0) k++;
                c[j] = c[k-1]; c[k-1]=0;
            }
	}
    }
    
    public int get_howmany(){
      	int j=0, howmany=0;

      	//while (j != c.length -1) {howmany++; j++;}
      	return howmany;
   }

    // Prints all the elements in the array
    public void print(){
        int j = 0;
        while((j != c.length -1)){
            System.out.println(c[j]);
            j++;
        }
    }
    
    //Determines if the objs are equal to each other
    public boolean equals(Intcoll2 obj){
      	int j = 0; boolean result = true;
      	while ((c[j] != 0)&&result)
      	{
         	result = obj.belongs(c[j]); j++;
      	}
      	j = 0;
      	/*while ((obj.c[j] != 0)&&result)
      	{
         	result = belongs(obj.c[j]); j++;
      	}*/
      	return result;
    }
    
    /*public static void main(String[] args){
        
        
    }*/
}
