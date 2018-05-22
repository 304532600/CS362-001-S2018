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
}
