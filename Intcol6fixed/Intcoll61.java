/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intcoll61;
//***********************************************************************
// FILE NAME    : Intcoll6.java
// DESCRIPTION  : This file contains the class Intcoll6.
//************************************************************************

import java.util.*;
import java.io.*;

public class Intcoll61
{
   private int howmany;
   private btNode c;

public static void main(String[] args)
{
    Intcoll61 P=new Intcoll61();
    Intcoll61 Q=new Intcoll61();

    /*int value; Scanner keyboard=new Scanner(System.in);
    System.out.println(
         "Enter a pos integer or neg integer to be inserted or 0 to quit:");
    value=keyboard.nextInt();
    while(value!=0)
    {
       if (value>0) P.insert(value); else Q.insert(-value);
       System.out.println(
         "Enter pos integer or neg integer to be inserted or 0 to quit:");
       value=keyboard.nextInt();
    }
            */
    P.insert(100);
    P.insert(70);
    P.insert(200);
    P.insert(50);
    P.insert(90);
    P.insert(150);
    P.insert(300);
    P.insert(20);
    P.insert(60);
    P.insert(80);
    P.insert(95);
    P.insert(110);
    P.insert(170);
    P.insert(210);
    P.insert(400);
    P.insert(10);
    P.insert(65);
    P.insert(92);
    P.insert(130);
    P.insert(250);

    System.out.println("\nThe values in collection P are:");
    P.print("P.out");P.print(); Q.print("Q.out");
    if (P.equals(Q)) System.out.println("P equals Q");
    else System.out.println("P not equal to Q"); 
    Intcoll61 A=new Intcoll61(); A.copy(P); 
    System.out.println("\nThe values in A are:");
    A.omit(70);
    A.print("A.out"); A.print();
}

   public Intcoll61()
   {
      c = null;
      howmany = 0;
   }

   public Intcoll61(int i)
   {
      c = null;
      howmany = 0;
   }

   private static btNode copytree(btNode t)
   {
      btNode root=null;
      if (t!=null)
      {
         root=new btNode();
         root.info=t.info; 
         root.left=copytree(t.left);
         root.right=copytree(t.right);
      }
      return root;
   }

   public void copy(Intcoll61 obj)
   {
      if (this!=obj)
      {
          howmany=obj.howmany;
          c=copytree(obj.c);  
      }
   }

   public void insert(int i)
   {
      btNode pred=null, p=c;

      while ((p!=null)&&(p.info!=i))
      {
		  pred=p;
		  if (p.info>i) p=p.left;
		  else p=p.right;
      }
      if (p==null)
      {
         howmany++; p=new btNode(i, null, null);
         if (pred!=null)
         {
			 if (pred.info>i) pred.left=p;
			 else pred.right=p;
		 }
		 else c=p;
      }
   }

   public void omit(int i)
   {
    btNode p = c;
    btNode pred = null;
    while((p!=null)&&(p.info!=i)){
        pred = p;
        if(i < p.info){
            p = p.left;
        }else{
            p = p.right;
        }
    }
    if(p == null){
        System.out.println("do nothing");
    }
    else if((p.left!=null)&&(p.right==null)){
        btNode child = p.left;
        btNode parent = p;
        while(child.left!=null){
            parent = child;
            child = child.left;
        }
        p.info = child.info;
        parent.left = child.right;
    }else if((p.left==null)&&(p.right!=null)){
        btNode child = p.right;
        btNode parent = p;
        while(child.left!=null){
            parent = child;
            child = child.left;
        }
        p.info = child.info;
        parent.right = child.right;
    }else if((p.left==null)&&(p.right==null)){
        if(pred == null){
            c = null;
        }
        else if(p.info<pred.info){
            pred.left = null;
        }else{
            pred.right = null;
        }
    }else if((p.left!=null)&&(p.right!=null)){
        btNode child = p.right;
        btNode parent = p;
        btNode pred2 = null;
        if(pred == null){
            while(child.left!=null){
                pred2 = child;
                child = child.left;
            }
            p.info = child.info;
            pred2.left = child.right;
            //parent.left = p.left;
        }else{
            while(child.left!=null){
                parent = child;
                child = child.left;
            }
            if(parent == p){
                p.info = child.info;
                parent.right = null;
            }else{
                p.info = child.info;
                parent.left = child.right;
            }
        }
    }
   }

   public boolean belongs(int i)
   {
      btNode p=c;
      while ((p!=null)&&(p.info!=i)) 
      {
         if (p.info>i) p=p.left;
         else p=p.right;
      }
      return (p!=null); 
   }

   public int get_howmany() {return howmany;}

   public void print(String outname)
   {
      try
      {
	 PrintWriter outs=new PrintWriter(new FileOutputStream(outname));
         outs.println("The number of integers is "+howmany);
         outs.println();
         printtree(c, outs);
         outs.close();
      }
      catch (IOException ex)
      {
      }
   }

   public void print()
   {
      printtree(c);
   }

   public boolean equals(Intcoll61 obj)
   {
      int j = 0; boolean result  = (howmany==obj.howmany);
      if (result)
      { 
         int[] a=new int[howmany]; 
         int[] b=new int[howmany];
         toarray(c, a, 0); toarray(obj.c, b, 0);

         j=0;
         while ((result) && (j<howmany))
         {
            result=(a[j]==b[j]); j++;
         }
      }
      return result;
   }

   private static void printtree(btNode t, PrintWriter outs)
   {   
	   if (t!=null)
	   {
		   printtree(t.left, outs);
		   outs.println(t.info);
		   printtree(t.right, outs);
	   }
   }

   private static void printtree(btNode t)
   {
      if (t!=null)
      {
          printtree(t.left);
          System.out.println(" ");
          System.out.println("Node: "+t.info);
          if(t.left != null){
            System.out.println("Left child: "+t.left.info);
          }else{
            System.out.println("Left child is null!");
          }
          if(t.right != null){
            System.out.println("Right child: "+t.right.info);
          }else{
            System.out.println("Right child is null!");
          }
          printtree(t.right);
      }
   }

   private static int toarray(btNode t, int[] a, int i)
   {
      int num_nodes=0;
      if (t!=null)
      {
         num_nodes=toarray(t.left, a, i);
         a[num_nodes+i]=t.info;   
         num_nodes=num_nodes+1+toarray(t.right, a, num_nodes+i+1);
      }
      return num_nodes;
   } 

   private static class btNode
   {
       int info; btNode left; btNode right;

       private btNode(int s, btNode lt, btNode rt)
       {
          info=s; left=lt; right=rt;  
       }

       private btNode()
       {
          info=0; left=null; right=null;
       }
   }
}

