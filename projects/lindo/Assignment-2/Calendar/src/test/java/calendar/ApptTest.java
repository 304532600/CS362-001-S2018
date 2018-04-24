/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      appt0.setValid();
      assertFalse(appt0.getValid());
      Appt appt1 = new Appt(50, 50, 50, 5, -100, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt1.setValid();
      assertFalse(appt1.getValid());
      Appt appt2 = new Appt(25, 60, 14, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt2.setValid();
      assertFalse(appt2.getValid());
      Appt appt3 = new Appt(1, 60, 32, 5, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt3.setValid();
      assertFalse(appt3.getValid());
      Appt appt4 = new Appt(1, 14, 32, 5, -1, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt4.setValid();
      assertFalse(appt4.getValid());
      Appt appt5 = new Appt(1, 14, 32, 5, 2010, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt5.setValid();
      assertFalse(appt5.getValid());
      Appt appt6 = new Appt(50, 50, 50, 0, -100, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt6.setValid();
      assertFalse(appt6.getValid());
      Appt appt7 = new Appt(-10, 60, 14, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt7.setValid();
      assertFalse(appt7.getValid());
      Appt appt8 = new Appt(1, -10, 32, 5, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt8.setValid();
      assertFalse(appt8.getValid());
      Appt appt9 = new Appt(1, 14, 0, 5, 2010, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt9.setValid();
      assertFalse(appt9.getValid());

  }
@Test(timeout = 4000)
 public void test01()  throws Throwable  {
   int startHour=21;
   		 int startMinute=30;
   		 int startDay=15;
   		 int startMonth=01;
   		 int startYear=2018;
   		 String title="Birthday Party";
   		 String description="This is my birthday party.";
       String emailAddress="ABC@gmail.com";
   		 //Construct a new Appointment object with the initial data
   		 Appt appt = new Appt(startHour,
   		          startMinute ,
   		          startDay ,
   		          startMonth ,
   		          startYear ,
   		          title,
   		         description,
               emailAddress);
   		 appt.toString();

   	// assertions
      assertTrue(appt.hasTimeSet());
      assertNull(appt.getXmlElement());
      assertNotNull(appt.getRecurDays());
      assertFalse(appt.isRecurring());
      assertNotNull(appt.isRecurring());
      assertTrue(appt.isOn(15,01,2018));
   		 assertTrue(appt.getValid());
       assertNotNull(appt.getTitle());
   		 assertEquals(21, appt.getStartHour());
   		 assertEquals(30, appt.getStartMinute());
   		 assertEquals(15, appt.getStartDay());
   		 assertEquals(01, appt.getStartMonth());
   		 assertEquals(2018, appt.getStartYear());
   		 assertEquals("Birthday Party", appt.getTitle());
   		 assertEquals("This is my birthday party.", appt.getDescription());
       assertEquals("ABC@gmail.com",appt.getEmailAddress());

       int recurdays[] = null;
		int recurby = 1;
		int recurinc = 1;
		int recurnnum= 1;
		appt.setRecurrence(recurdays, recurby, recurinc, recurnnum);
		appt.isRecurring();

		// assertions
    appt.setValid();
		assertTrue(appt.getValid());
}

@Test(timeout = 4000)
 public void test02()  throws Throwable  {
   int startHour=25;
   		 int startMinute=61;
   		 int startDay=32;
   		 int startMonth=15;
   		 int startYear=-1;
   		 String title=null;
   		 String description=null;
       String emailAddress=null;
   		 //Construct a new Appointment object with the initial data
   		 Appt appt = new Appt(startHour,
   		          startMinute ,
   		          startDay ,
   		          startMonth ,
   		          startYear ,
   		          title,
   		         description,
               emailAddress);
   		 appt.toString();

   	// // assertions
    //   assertFalse(appt.hasTimeSet());
    //   assertNull(appt.getXmlElement());
    //   assertNotNull(appt.getRecurDays());
    //   assertFalse(appt.isRecurring());
    //   assertNotNull(appt.isRecurring());
    //   assertFalse(appt.isOn(15,01,2018));
   	// 	 assertFalse(appt.getValid());
        assertEquals("",appt.getTitle());
        assertEquals("",appt.getDescription());
        assertEquals("",appt.getEmailAddress());
   	// 	 assertEquals(21, appt.getStartHour());
   	// 	 assertEquals(30, appt.getStartMinute());
   	// 	 assertEquals(15, appt.getStartDay());
   	// 	 assertEquals(01, appt.getStartMonth());
   	// 	 assertEquals(2018, appt.getStartYear());
   	// 	 assertEquals("Birthday Party", appt.getTitle());
   	// 	 assertEquals("This is my birthday party.", appt.getDescription());
    //    assertEquals("ABC@gmail.com",appt.getEmailAddress());
    //
    //    int recurdays[] = null;
		// int recurby = 1;
		// int recurinc = 1;
		// int recurnnum= 1;
		// appt.setRecurrence(recurdays, recurby, recurinc, recurnnum);
		// appt.isRecurring();

		//assertions
    appt.setValid();
		assertFalse(appt.getValid());
    // appt.setTitle();
    // assertEquals("",appt.getTitle());
    // appt.setDescription();
    // assertEquals("",appt.getDescription());
    // appt.setEmailAddress();
    // assertEquals("",appt.getEmailAddress());
}
 }
