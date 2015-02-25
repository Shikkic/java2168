/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intcoll5;

import java.util.*;

public class Intcoll5 {
    private LinkedList<Integer> c;
    private int howmany;
    
    public Intcoll5(){
        c = new LinkedList<Integer>();
        howmany = 0;
    }
    
    public Intcoll5(int i){
        c = new LinkedList<Integer>();
        howmany =0;
    }
 
    public void insert(int i){
        if(i > 0){
            Integer I = new Integer(i);
            if (!c.contains(I)){  
                c.add(I);
            }
            howmany++;
        }
    }   
    
    public boolean belongs(int i){
        Integer I=new Integer(i);
        return c.contains(I);
    }
    
    public void omit(int i){
        Integer I=new Integer(i);
        c.remove(I);
        howmany--;
    }
    
    public int get_howmany(){
        return howmany;
    }
    
    public void print(){
        ListIterator<Integer> p = c.listIterator();
        while(p.hasNext()){
            System.out.println(p.next());
        }
    }
    
    public boolean equals(Intcoll5 obj){
        ListIterator<Integer> p = c.listIterator();
        boolean result = (howmany == obj.howmany);
        while(p.hasNext()&&result){
            result = obj.belongs(p.next());
        }
        return result;
        //return c.equals(obj.c);
    }
    
    public void copy(Intcoll5 obj){
        if(this != obj){
            ListIterator<Integer> d = obj.c.listIterator();
            c = new LinkedList<Integer>();
            this.howmany = obj.howmany;
            while(d.hasNext()){
                this.c.add(d.next());
            }
        }
        //Clone method
       // c = (LinkedList<Integer>) obj.c.clone();
       // this.howmany = obj.howmany;
    }
    public static void main(String[] args) {
        Intcoll5 C = new Intcoll5(5);
        Intcoll5 D = new Intcoll5(2);
        // first test
        C.copy(D);
        System.out.println("\n After Copy the number of elements in a collection C is:\n");
        System.out.print(C.get_howmany());
        System.out.println("\nThe values in the collection C are:\n");
        C.print();

        // second test
        C = new Intcoll5(5);
        D.insert(235);
        C.copy(D);
        System.out.println("\n After Copy the number of elements in a collection C is:\n");
        System.out.print(C.get_howmany());
        System.out.println("\nThe values in the collection C are:\n");
        C.print();

        // third test
        C = new Intcoll5(5);
        D = new Intcoll5(2);
        for (int i=1;i<10;i++)
        {
            D.insert(i);
        }
        if (C.equals(D)) System.out.println("\nC and D should not be equal but they are.");
        C.copy(D);
        System.out.println("\n After clearing the objects and copy the number of elements in a collection C is:\n");
        System.out.print(C.get_howmany());
        System.out.println("\nThe values in the collection C are:\n");
        C.print();

        if (C.equals(D)) System.out.println("\nC and D are equal.");
    }
    
}
