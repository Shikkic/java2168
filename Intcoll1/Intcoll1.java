import java.util.*;

public class Intcoll1
{
   private int[] c;

   public Intcoll1()
   {
        c = new int[500+1];
        c[0] = 0;
   }

   public Intcoll1(int i)
   {
        c = new int[i+1];
        c[0] = 0;
   }

public void insert(int i)
   {
        if (i > 0)
    {
        int j = 0;
            while ((c[j] != 0) && (c[j] != i)) j++;
        if (c[j] == 0)
            {
            if (j == c.length - 1)
            {
                //if array too small, make new array double size
                //Then copy all the values of the area into the new area
                int array2[] = new int[2 * c.length];
                for(int z = 0;(z < c.length); z++ ){
                    array2[z] = c[z];
                    System.out.println(array2[z]);
                }
                c = array2;
            }
            c[j] = i; c[j + 1] = 0;
        }
    }
   }
   
}