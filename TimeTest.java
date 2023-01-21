import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
* JUnit Time Tests
*/
public class TimeTest {
	
	@Test
	public void testIncrementSeconds1() {
		Time time = new Time(11, 50, 25);
		time.incrementSeconds();
		assertEquals("Seconds ", 26, time.getSeconds());
		assertEquals("Minutes ", 50, time.getMinutes());
		assertEquals("Hours ", 11, time.getHours());
	}

	@Test
	public void testIncrementSeconds2() {
		Time time = new Time(11, 50, 59);
		time.incrementSeconds();
		assertEquals("Seconds ", 0, time.getSeconds());
		assertEquals("Minutes ", 51, time.getMinutes());
		assertEquals("Hours ", 11, time.getHours());
	}

	@Test
	public void testIncrementSeconds3() {
		Time time = new Time(11, 59, 59);
		time.incrementSeconds();
		assertEquals("Seconds ", 0, time.getSeconds());
		assertEquals("Minutes ", 0, time.getMinutes());
		assertEquals("Hours ", 12, time.getHours());
	}

	@Test
	public void testIncrementSeconds4() {
		Time time = new Time(23, 59, 59);
		time.incrementSeconds();
		assertEquals("Seconds ", 0, time.getSeconds());
		assertEquals("Minutes ", 0, time.getMinutes());
		assertEquals("Hours ", 0, time.getHours());
	}
	
	@Test
	public void testIncrementMinutes1() {
		Time time = new Time(11, 50, 25);
		time.incrementMinutes();
		assertEquals("Seconds ", 25, time.getSeconds());
		assertEquals("Minutes ", 51, time.getMinutes());
		assertEquals("Hours ", 11, time.getHours());
	}
	
	@Test
	public void testIncrementMinutes2() {
		Time time = new Time(11, 59, 59);
		time.incrementMinutes();
		assertEquals("Seconds ", 59, time.getSeconds());
		assertEquals("Minutes ", 0, time.getMinutes());
		assertEquals("Hours ", 12, time.getHours());
	}

	@Test
	public void testIncrementMinutes3() {
		Time time = new Time(23, 59, 59);
		time.incrementMinutes();
		assertEquals("Seconds ", 59, time.getSeconds());
		assertEquals("Minutes ", 0, time.getMinutes());
		assertEquals("Hours ", 0, time.getHours());
	}
	
	@Test
	public void testIncrementHours1() {
		Time time = new Time(11, 50, 25);
		time.incrementHours();
		assertEquals("Seconds ", 25, time.getSeconds());
		assertEquals("Minutes ", 50, time.getMinutes());
		assertEquals("Hours ", 12, time.getHours());
	}

	@Test
	public void testIncrementHours2() {
		Time time = new Time(23, 59, 59);
		time.incrementHours();
		assertEquals("Seconds ", 59, time.getSeconds());
		assertEquals("Minutes ", 59, time.getMinutes());
		assertEquals("Hours ", 0, time.getHours());
	}
	
	@Test
	public void testEquals1() {
		Time time1 = new Time(23, 59, 59);
		Time time2 = new Time(23, 59, 59);
		assertTrue("All fields were equal", time1.equals(time2));
		assertTrue("All fields were equal", time2.equals(time1));
	}
	
	@Test
	public void testEquals2() {
		Time time1 = new Time(23, 59, 59);
		assertTrue("Object should equal itself", time1.equals(time1));
	}

	@Test
	public void testEquals3() {
		Time time1 = new Time(23, 59, 59);
		Time time2 = new Time(10, 59, 59);
		assertFalse("Different hours", time1.equals(time2));
		assertFalse("Different hours", time2.equals(time1));
	}
	
	@Test
	public void testEquals4() {
		Time time1 = new Time(23, 10, 0);
		Time time2 = new Time(23, 59, 0);
		assertFalse("Different minutes", time1.equals(time2));
		assertFalse("Different minutes", time2.equals(time1));
	}

	@Test
	public void testEquals5() {
		Time time1 = new Time(23, 10, 20);
		Time time2 = new Time(23, 10, 0);
		assertFalse("Different seconds", time1.equals(time2));
		assertFalse("Different seconds", time2.equals(time1));
	}
	
	@Test
	public void testEquals6() {
		Time time1 = new Time(23, 10, 0);
		Integer i = 23;
		assertFalse("Different types", time1.equals(i));
	}
	
	@Test
	public void testToString() {
		Time time = new Time(12, 25, 30);
		assertTrue("String format problem", time.toString().equals("12:25:30"));
		System.out.println(new Time());
	}
	

}