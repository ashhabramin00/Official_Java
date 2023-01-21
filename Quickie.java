
public class Quickie 
{
	private GPS gps;
	private int wheels;
	public Quickie() {
		wheels = 3;
		gps = new GPS();
		
	}
	
	public class GPS
	
	{
		private double latitude, longitude;
		Cell battery;
		public GPS()
		
		{
			battery = new Cell();
		}
		
		public Cell getCell()
		{
			return battery;
		}
		
		public class Cell
		{
			private double remainingCharge;
			public Cell() {
				remainingCharge = 100.0;
			}
			public double remainingCharge()
			{
				return remainingCharge;
			}
		}
	}
}

