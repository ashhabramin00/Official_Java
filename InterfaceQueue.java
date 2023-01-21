import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;

public class InterfaceQueue
{
	public static void main(String[] args)
	{
		Stack<String> stk = new Stack<>();
		
		stk.push("A");
		stk.push("B");
		stk.push("C");
		
		System.out.println(stk);
		System.out.println(stk.peek());
		
		String temp = stk.pop();
		System.out.println(stk);
		
		System.out.println(stk.search("B"));
		
		if (stk.empty())
		{
			System.out.println("Empty");
		}
		else
		{
			System.out.println("Not Empty");
		}
		Queue<String> que = new LinkedList<>();
		
		que.add("A");
		que.add("B");
		que.add("C");
		
		System.out.println(que.peek());
		
		ArrayList<String> arlst = new ArrayList<>();
		
		arlst.add("Benis");
		arlst.add("Venis");
		
		for(String singleElement : arlst)
		{
			arlst.remove("Benis");
		}
		
		System.out.println(arlst);
		
		HashMap<Integer, String> hamburger = new HashMap<>();
		
		hamburger.put(1,"Pickle Rick");
		hamburger.put(2,"Pickle Dick");
		
		System.out.println(hamburger);
		//Create array list with generics
	}

}
