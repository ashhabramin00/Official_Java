
public class TestDebugMode {
	
	public static void main(String[] args)
	{
		
		Duck dck = new Duck();
		
		int i = 15;
		
		while (i<60) {
			i++;
			System.out.println(i/2);
			i = i +2;
			dck.LayEgg();
		}
	}

}
