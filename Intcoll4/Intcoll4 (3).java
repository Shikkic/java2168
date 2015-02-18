import java.util.*;

public class Intcoll4
{
   private int howmany;
   private ListNode c;

   public Intcoll4()
   {
      c = null;
      howmany = 0;
   }

   public Intcoll4(int i)
   {
      c = null;
      howmany = 0;
   }

   public void insert(int i)
   {
      ListNode p=c;
      ListNode pred = null;
      while ((p!=null)&&(p.info!=i))
      {
         pred = p;
         p=p.link;
      }
      if (p==null)
      {
         p=new ListNode();
         p.info=i;
         if (pred!=null)
             pred.link=p;
         else
             c=p;
         howmany++;
      }
   }

   public void omit(int i)
   {
      ListNode p=c; ListNode pred=null;
          while ((p!=null)&&(p.info!=i)) {pred=p; p=p.link;}
          if (p!=null)
          {
              if (pred!=null) pred.link=p.link;
              else c=p.link;
              howmany--;
          }
   }

   public boolean belongs(int i)
   {
      ListNode p=c;
      while ((p!=null)&&(p.info!= i)) p=p.link;
      return (p!=null);
   }

   private class ListNode
   {
         private int info;
         private ListNode link;

         public ListNode()
         {
            info=0; link=null;
         }
   }

}
