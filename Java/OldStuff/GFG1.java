import java.util.*;

public class GFG1 
{
  public static void main(String[] argv) throws Exception
  {
      try {

          // creating object of LinkedList<String>
          LinkedList<String> list = new LinkedList<String>();

          // add some elements to list
          list.add("A");
          list.add("B");
          list.add("C");

          // print the linked list
          System.out.println("LinkedList : " + list);

          // getting the head of list
          // using element() method
          String value = list.element();

          // print the head of list
          System.out.println("Head of list : " + value);
      }

      catch (NullPointerException e) {

          System.out.println("Exception thrown : " + e);
    	  
      }
  }
}