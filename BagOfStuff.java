
public class BagOfStuff<E> {
	
	private E thing;
	public BagOfStuff()
	{
		thing = (E) new Object();
	}
	public E getThing() {
		return thing;
	}
	public void setThing(E userInputThing)
	{
		thing = userInputThing;
	}
	
	public E handle()
	{
		// What we had to do
		if (thing instanceof java.lang.String) //if its' an integer, triple the value
		{
			
		} else if(thing instanceof java.lang.int) //if it's a String, add "able" to the end
		{
			return thingto()
				
		} else 
		{
			return thing.toString();
			
		}
		thing.toString();
		
	}
	public static void main(String[] args)
	{
		BagOfStuff<String> test = new BagOfStuff<>();
		test.setThing("Hello World");
		System.out.println(test.getThing());
		
		BagOfStuff<Integer> = new BagOfStuff<>();
		test.setThing(16);
		System.out.println(testInt.getThing());
	}

}
