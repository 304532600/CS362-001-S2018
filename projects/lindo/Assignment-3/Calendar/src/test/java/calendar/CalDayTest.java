/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;
import java.time.Month;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Calendar;

public class CalDayTest{
  Appt InvalidAppt = new Appt(12, 00, 0, 0, 0, "BS", "This a mess", "xyz@gmail.com");
  Appt appt0 = new Appt(12, 30, 22, 4, 2018, "Lunch", "Lunch with my wife", "xyz@gmail.com");
  Appt appt1 = new Appt(14, 00, 22, 6, 2018, "Shopping", "Shopping and buy stuffs", "xyz@gmail.com");
  // Appt appt2 = new Appt(15, 30, 22, 8, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
    CalDay calDays = new CalDay();
    			assertEquals(false, calDays.isValid());
          GregorianCalendar cal = new GregorianCalendar(2018, 3, 22, 15, 30, 00);
          CalDay day0 = new CalDay(cal);
          assertEquals(22, day0.getDay());
          assertEquals(4, day0.getMonth());
          assertEquals(2018, day0.getYear());
          day0.addAppt(appt0);
          assertNotNull(day0.getAppts());
          day0.addAppt(appt1);
          assertNotNull(day0.getAppts());
          day0.addAppt(InvalidAppt);
          assertNotNull(day0.getAppts());
          assertTrue(day0.isValid());
          assertNotNull(day0.getSizeAppts());
          assertNotNull(day0.toString());
          assertNotNull(day0.iterator());
          assertNotNull(day0.getAppts());

  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
    int day=23;
         int month=9;
         int year=2018;
  java.util.LinkedList <calendar.Appt> appts2;
  GregorianCalendar cal = new GregorianCalendar();
  cal.set(2018, 1, 27, 10, 30, 00);

    Appt appt3 = new Appt(13, 30 , 22 , 4 , 2018 , "title", "description", "emailAddress");
    Appt appt4 = new Appt(0, 30 , 22 , 4 , 2018 , "title", "description", "emailAddress");
    CalDay calday = new CalDay(cal);
    CalDay calday1 = new CalDay(cal);
    CalDay calday2 = new CalDay(cal);
    calday.addAppt(appt0);
    assertNotNull(calday.getFullInfomrationApp(calday));
    calday1.addAppt(appt3);
    assertNotNull(calday1.getFullInfomrationApp(calday1));
    calday2.addAppt(appt4);
    assertNotNull(calday2.getFullInfomrationApp(calday2));
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
    Appt InvalidAppt0 = new Appt(12, 00, -2, -3, 20, "", "", "xyz@gmail.com");
     CalDay day0 = new CalDay();
     assertFalse(day0.isValid());
     InvalidAppt0.setValid();
     assertEquals(false, InvalidAppt0.getValid());                   //this is wrong
     assertEquals(null, day0.iterator());
     assertEquals("", day0.toString());
     day0.addAppt(InvalidAppt0);


  }
  @Test
	public void test07() throws Throwable {
    Appt appt0 = new Appt(20, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
  Appt appt2 = new Appt(21, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
  Appt appt3 = new Appt(22, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
  Appt appt4 = new Appt(21, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
  Appt appt5 = new Appt(20, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
  Appt appt6 = new Appt(21, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
 assertTrue(appt0.getValid());
 assertTrue(appt2.getValid());
 assertTrue(appt3.getValid());
 assertTrue(appt4.getValid());
 Calendar current = Calendar.getInstance();
 int thisMonth = current.get(Calendar.MONTH)+1;
 int thisYear = current.get(Calendar.YEAR);
 int thisDay = current.get(Calendar.DAY_OF_MONTH);
 GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
 CalDay calDays = new CalDay(today);
 assertEquals(true, calDays.isValid());
 assertNotNull(calDays.getMonth());
 assertNotNull(calDays.getYear());
 assertNotNull(calDays.getDay());

 calDays.addAppt(appt0);
 calDays.addAppt(appt2);
 calDays.addAppt(appt0);
 calDays.addAppt(appt2);
 calDays.addAppt(appt3);
 calDays.addAppt(appt4);
 calDays.addAppt(appt5);
 calDays.addAppt(appt6);
  assertEquals(appt0, calDays.getAppts().get(0));
  assertEquals(appt0, calDays.getAppts().get(1));
 assertNotNull(calDays.getAppts().get(2));
 assertNotNull(calDays.getAppts().get(3));
 assertNotNull(calDays.getAppts().get(4));
	}
  @Test
	public void test09()  throws Throwable  {

		int day=29;
		int month=1;
		int year=2018;
		GregorianCalendar cal = new GregorianCalendar();


		CalDay calday = new CalDay(cal);

		int startHour=12;
		int startMinute=30;
		int startDay=29;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";

		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description,
        "xyz@gmail.com");
		java.util.LinkedList <calendar.Appt> appts2;


		startHour = 11;
		Appt appt3 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description,
        "xyz@gmail.com");
		startHour = 0;
		Appt appt4 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description,
        "xyz@gmail.com");

		calday.addAppt(appt);
		calday.addAppt(appt3);
		calday.addAppt(appt4);

		appts2= calday.getAppts();
		String convert;

		int size;

		size = calday.getSizeAppts();
    appt.setValid();
		assertTrue(appt.getValid());
    assertEquals(12,appt.getStartHour());
    appt3.setValid();
    assertTrue(appt3.getValid());
    assertEquals(11,appt3.getStartHour());

		assertEquals(3, size);

		cal.set(0, 0, 0);
		calday = new CalDay(cal);
		convert = calday.toString();
	}
  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
    CalDay calDays = new CalDay();
    			assertEquals(false, calDays.isValid());
          GregorianCalendar cal = new GregorianCalendar(2018, 4, 22, 12, 30, 00);
          CalDay day0 = new CalDay(cal);
          assertEquals(22, day0.getDay());
          assertEquals(5, day0.getMonth());
          assertEquals(2018, day0.getYear());
          day0.addAppt(appt0);
          assertNotNull(day0.getAppts());
          day0.addAppt(appt1);
          assertNotNull(day0.getAppts());
          day0.addAppt(InvalidAppt);
          assertNotNull(day0.getAppts());
          assertTrue(day0.isValid());
          assertNotNull(day0.getSizeAppts());
          assertNotNull(day0.toString());
          assertNotNull(day0.iterator());
          assertNotNull(day0.getAppts());
          Calendar current = Calendar.getInstance();
      		int thisMonth = -2;
      		int thisYear = current.get(Calendar.YEAR);
      		int thisDay = current.get(Calendar.DAY_OF_MONTH);
      		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
      		CalDay cal1 = new CalDay(today);
      		assertTrue(cal1.isValid());

  }
}
