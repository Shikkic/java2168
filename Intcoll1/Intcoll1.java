import java.util.*;

public class Intcoll1
{
    private int[] c;

    // Initializes an empty collection with size 501
    public Intcoll1(){
        c = new int[500+1];
        c[0] = 0;
    }

    // Initializes an empty collection with size i+1
    public Intcoll1(int i){
        c = new int[i+1];
        c[0] = 0;
    }

    // Copies all the values from c into obj's array
    public void copy(Intcoll1 obj){
        if (this != obj)
        {
        c = new int[obj.c.length];
        int j = 0;
        while (obj.c[j] != 0)
        {
            c[j] = obj.c[j]; j++;
        }
        c[j] = 0;
        }
    }

    // Checks to see if the int i is in the collection  
     public boolean belongs(int i){
        int j = 0;
        while ((c[j] != 0)&&(c[j] != i)) j++;
        return ((i>0)&&(c[j] == i));
    }

    //  Inserts i int the collecion, if it's too big it creates a bigger array and copies everything over
    public void insert(int i){
        if (i > 0){
        int j = 0;
        while ((c[j] != 0) && (c[j] != i)) j++;
            if (c[j] == 0){
                if (j == c.length - 1){
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

    // Prints the entire array, element by element
    public void print(){
        int j = 0;
        while(c[j]!=0){
            System.out.println(c[j]);
            j++;
        }
    }

    // Removes int i from the collection, if it exists in the collection, then moves the last non-zero element to that location
    public void omit(int i){
        if (i>0){
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

    // Returns the private number howmany
    public int get_howmany()
    {
        int j=0, howmany=0;

        while (c[j]!=0) {howmany++; j++;}
        return howmany;
    }

    // Returns true if two arrays have equal number of similar elements
    public boolean equals(Intcoll1 obj){
        int j = 0; boolean result = true;
        while ((c[j] != 0)&&result){
            result = obj.belongs(c[j]); j++;
        }
        j = 0;
        while ((obj.c[j] != 0)&&result){
            result = belongs(obj.c[j]); j++;
        }
        return result;
    }
    
    public static void main(String[] args){ 
    }

}