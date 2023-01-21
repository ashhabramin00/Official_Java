
public class Tiger {
	
	//create a global variable
	public static Tiger instance;
	
	//private class cannot be called in to a main method
	private Tiger()
	{
	}
	
	public static Tiger getInstance()
	{
		if(instance == null)
		{
			instance = new Tiger();
		}
		return instance;
	}
	
	public void roar() 
	{ 
		System.out.println("Roar");
	}
	
	public void bark()
	{
		System.out.println("Bark");
	}
	
	public static void main(String[] args)
	{
		Tiger tg = new Tiger();
		tg.roar();
	}

}
