import java.util.Stack;
public class PopObject 
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
	}

}
