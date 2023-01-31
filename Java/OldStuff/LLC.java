import java.util.LinkedList;

public class LLC {
	public static void main(String[] args)
	{
		LinkedList<Integer> test = new LinkedList<>();
		
		test.add(1);
		test.add(2);
		test.add(1,3);
		
		System.out.println(test);
		
		if (test.contains(4))
		{
			System.out.println("I have a 4");
		}
		else 
		{
			System.out.println("I don't have a 4");
		}
		for(int singleElement : test)
		{
			System.out.println(singleElement * 2);
		}
		
		test.size ();
		
		
		}
	}

}
