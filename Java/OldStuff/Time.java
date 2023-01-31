import java.util.GregorianCalendar;

/**
 * @author Charles Pastori and Ashhab Amin
 * 
 * The Time Class contains the elements for military time, with appropriate fields such as
 * minutes, hours, and seconds to represent the time as the output. This class also hold methods 
 * that increment the time appropriate to a conventional clock, with minutes and seconds rolling 
 * over back to 0 if over the value of 59, and the same with hours, rolling over after 23.
 * 
 * 
 */
 
public class Time 
{
    private int hours;
    private int minutes;
    private int seconds;

    /**
    *
    *Creates a Time object with the current hour, current minute, and current second as the value for hours, minutes, and seconds respectively.
    */
    public Time()
    {
        GregorianCalendar currentTimeCalender = new GregorianCalendar();
        
        hours = currentTimeCalender.get(currentTimeCalender.HOUR);
        minutes = currentTimeCalender.get(currentTimeCalender.MINUTE);
        seconds = currentTimeCalender.get(currentTimeCalender.SECOND);
    }
    
    /**
    *
    *Creates a Time object with a specified hour, minute, and second.
    */
    public Time(int hours, int minutes, int seconds)
    {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    
    /**
    *
    * Returns the current hour stored in the Time object.
    */
    public int getHours()
    {
        return hours;
    }
    
    /**
    *
    * Returns the current minute stored in the Time object.
    */
    public int getMinutes()
    {
        return minutes;
    }
    
    /**
    *
    * Returns the current second stored in the Time object.
    */
    public int getSeconds()
    {
        return seconds;
    }
    
    /**
    *
    * A toString method for the Time object. Prints out the stored hour, minute, and second in a standard format.
    */
    public String toString()
    {
        return hours + ":" + minutes + ":" + seconds;
    }
    
    /**
    *
    * Increments the hour stored in the Time object. If the hour is incremented when the hour is 23, the value for hours is reset to 0.
    */
    public void incrementHours()
    {
        if (hours >= 23)
        {
            hours = 0;
        }
        else
        {
            hours++;
        }
    }

    /**
    *
    * Increments the minute stored in the Time object. If the minute is incremented when the minute is 59, 
    * the value of minutes is reset to 0 and incrementHours() is called.
    */
    public void incrementMinutes()
    {
        if (minutes >= 59)
        {
            minutes = 0;
            incrementHours();
        }
        else
        {
            minutes++;
        }
    }

    /**
    *
    * Increments the second stored in the Time object. If the second is incremented when the second is 59, 
    * the value of seconds is reset to 0 and incrementMinutes() is called.
    */
    public void incrementSeconds()
    {
        if (seconds >= 59)
        {
            seconds = 0;
            incrementMinutes();
        }
        else
        {
            seconds++;
        }
    }
    
    /**
    *
    * Overrides the equals method found in the Object class. Checks for equality in Time objects. 
    * Uses the Time class's toString() method and the String class's equals method as a helper methods to determine if 
    * two Time objects are equal. If the hours, minutes, and seconds of two time objects are equal, returns true. 
    * Otherwise returns false.
    */
    public boolean equals (Object object)
    {
    	if(object instanceof Time)
    	{
    		return toString().equals(((Time)object).toString());
    	}
    	else
    	{
    		return false;
    	}
    	
    }
	
}
