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
      Appt appt10 = new Appt(11,30,15,1,2018, "Birthday Party", "This is my birthday party", "ABC@gmail.com");
      appt10.setStartDay(-1);
      assertEquals(true, appt10.getValid());
      Appt appt11 = new Appt(-1, 14, 0, 13, 2010, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt11.setValid();
      assertFalse(appt11.getValid());

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

        assertEquals("",appt.getTitle());
        assertEquals("",appt.getDescription());
        assertEquals("",appt.getEmailAddress());
    appt.setValid();
		assertFalse(appt.getValid());

}


 @Test
 	  public void test03()  throws Throwable  {
 		 int startHour=21;
 		 int startMinute=30;
 		 int startDay=15;
 		 int startMonth=01;
 		 int startYear=2018;
 		 String title="Birthday Party";
 		 String description="This is my birthday party.";
 		 //Construct a new Appointment object with the initial data
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
 						 Appt appt2 = new Appt(startHour,
 						          startMinute ,
 						          startDay ,
 						          startMonth ,
 						          startYear ,
 						          title,
 						         description,
                     emailAddress);
 	// assertions
 		 assertTrue(appt.getValid());
 		 assertTrue(appt2.getValid());
 		 assertEquals(21, appt.getStartHour());
 		 assertEquals(30, appt.getStartMinute());
 		 assertEquals(15, appt.getStartDay());
 		 assertEquals(01, appt.getStartMonth());
 		 assertEquals(2018, appt.getStartYear());
 		 assertEquals("Birthday Party", appt.getTitle());
 		 assertEquals("This is my birthday party.", appt.getDescription());
 		 assertEquals("	1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n", appt.toString());
 		 assertEquals(false, appt.isRecurring());
 		 assertEquals(0, appt.getRecurIncrement());
 		 assertEquals(0, appt.getRecurNumber());
 		 assertEquals(2, appt.getRecurBy());
 		 assertNotNull(appt.getRecurDays());
 		 //assertNotNull(appt.compareTo(calendar.appt2));
 	 }/*End test01 function*/

   @Test
 	  public void test20()  throws Throwable  {
 		 int startHour=21;
  		 int startMinute=30;
  		 int startDay=15;
  		 int startMonth=01;
  		 int startYear=2018;
 		 String title="Birthday Party";
 		 String description="This is my birthday party.";
  		 //Construct a new Appointment object with the initial data
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
  	// assertions
 	assertEquals(true, appt.getValid());
 	assertEquals(false, appt.isRecurring());
 	assertEquals(0, appt.getRecurIncrement());
 	assertEquals(0, appt.getRecurNumber());
 	assertEquals(2, appt.getRecurBy());
 	assertNotNull(appt.getRecurDays());
 		appt.setStartHour(21);
 assertEquals("	1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n", appt.toString());
 		appt.setStartMinute(30);
 assertEquals("	1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n", appt.toString());
 		appt.setStartDay(15);
 assertEquals("	1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n", appt.toString());
 		appt.setStartMonth(01);
 assertEquals("	1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n", appt.toString());
 		appt.setStartYear(2018);
 assertEquals("	1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n", appt.toString());
 		appt.setTitle("");
 assertEquals("	1/15/2018 at 9:30pm ,, This is my birthday party.\n", appt.toString());
 		appt.setDescription("");
 assertEquals("	1/15/2018 at 9:30pm ,, \n", appt.toString());
}

@Test
 public void test05()  throws Throwable  {
	 int startHour=0;
	 int startMinute=30;
	 int startDay=15;
	 int startMonth=01;
	 int startYear=2018;
	 String title=null;
	 String description=null;
	 int[] recurringDays = null;

  String emailAddress="ABC@gmail.com";

  Appt appt = new Appt(startHour,
           startMinute ,
           startDay ,
           startMonth ,
           startYear ,
           title,
          description,
          emailAddress);
// assertions
assertEquals(true, appt.getValid());
appt.setRecurrence(recurringDays, 2, 0, 0);
assertEquals(2, appt.getRecurBy());
assertEquals(0, appt.getRecurIncrement());
assertEquals(0, appt.getRecurNumber());
assertNotNull(appt.getRecurDays());
}

@Test
 public void test06()  throws Throwable  {
	 int startHour=21;
	int startMinute=-5;
	int startDay=15;
	int startMonth=01;
	int startYear=2018;
	String title="";
	String description="";

  String emailAddress="ABC@gmail.com";

  Appt appt = new Appt(startHour,
           startMinute ,
           startDay ,
           startMonth ,
           startYear ,
           title,
          description,
          emailAddress);

	assertEquals(true, appt.getValid());
}

@Test
 public void test08()  throws Throwable  {
	 int startHour=21;
	 int startMinute=60;
	 int startDay=15;
	 int startMonth=01;
	 int startYear=2018;
	 String title="Birthday Party";
	 String description="This is my birthday party.";

  String emailAddress="ABC@gmail.com";

  Appt appt = new Appt(startHour,
           startMinute ,
           startDay ,
           startMonth ,
           startYear ,
           title,
          description,
          emailAddress);

	assertEquals(true, appt.getValid());
}

@Test
 public void test09()  throws Throwable  {
	 int startHour=21;
	 int startMinute=30;
	 int startDay=0;
	 int startMonth=01;
	 int startYear=2018;
	 String title="Birthday Party";
	 String description="This is my birthday party.";

  String emailAddress="ABC@gmail.com";

  Appt appt = new Appt(startHour,
           startMinute ,
           startDay ,
           startMonth ,
           startYear ,
           title,
          description,
          emailAddress);

	assertEquals(true, appt.getValid());
}

@Test
 public void test11()  throws Throwable  {
	 int startHour=3;
	 int startMinute=30;
	 int startDay=15;
	 int startMonth=01;
	 int startYear=2018;
	 String title="Birthday Party";
	 String description="This is my birthday party.";

  String emailAddress="ABC@gmail.com";

  Appt appt = new Appt(startHour,
           startMinute ,
           startDay ,
           startMonth ,
           startYear ,
           title,
          description,
          emailAddress);

	assertTrue(appt.getValid());
assertEquals("	1/15/2018 at 3:30am ,Birthday Party, This is my birthday party.\n", appt.toString());
}

@Test
 public void test12()  throws Throwable  {
	 int startHour=3;
	 int startMinute=0;
	 int startDay=15;
	 int startMonth=01;
	 int startYear=2018;
	 String title="Birthday Party";
	 String description="This is my birthday party.";

  String emailAddress="ABC@gmail.com";

  Appt appt = new Appt(startHour,
           startMinute ,
           startDay ,
           startMonth ,
           startYear ,
           title,
          description,
          emailAddress);


		int startMinute2=59;
		Appt appt2 = new Appt(startHour,
			 				startMinute2 ,
			 				startDay ,
			 				startMonth ,
			 			  startYear ,
			 				title,
			 				description,
              emailAddress);

    int startMinute3=15;
		int startDay2=1;

		Appt appt3 = new Appt(startHour,
					 					 startMinute3 ,
					 					 startDay2 ,
					 					 startMonth ,
					 					 startYear ,
					 					 title,
					 					description,
                    emailAddress);


		int startDay3=CalendarUtil.NumDaysInMonth(startYear,startMonth-1);

		Appt appt4 = new Appt(startHour,
							 startMinute3 ,
							 startDay3 ,
							 startMonth ,
							 startYear ,
							 title,
							description,
              emailAddress);

 	int startMonth2=12;

	Appt appt5 = new Appt(startHour,
					 	startMinute3 ,
					  startDay ,
					  startMonth2 ,
					 	startYear ,
					 	title,
					 description,
           emailAddress);

	assertEquals(true, appt.getValid());
	assertEquals(true, appt2.getValid());
	assertEquals(true, appt3.getValid());
	assertEquals(true, appt4.getValid());
	assertEquals(true, appt5.getValid());

 appt.setStartMinute(startMinute);
 appt2.setStartMinute(startMinute2);
 appt3.setStartDay(startDay2);
 appt4.setStartDay(startDay3);
 appt5.setStartMonth(startMonth2);

}


@Test
 public void test14()  throws Throwable  {
	 int startHour=11;
	 int startMinute=30; //change invalid minute lower bound
	 int startDay=15;
	 int startMonth=01;
	 int startYear=2018;
	 String title="Birthday Party";
	 String description="This is my birthday party.";

  String emailAddress="ABC@gmail.com";

  Appt appt = new Appt(startHour,
           startMinute ,
           startDay ,
           startMonth ,
           startYear ,
           title,
          description,
          emailAddress);

	appt.setStartHour(-1);
  assertEquals(true, appt.getValid());
}


@Test
 public void test15()  throws Throwable  {
	 int startHour=11;
	 int startMinute=30;
	 int startDay=15;
	 int startMonth=01;
	 int startYear=2018;
	 String title="Birthday Party";
	 String description="This is my birthday party.";

  String emailAddress="ABC@gmail.com";

  Appt appt = new Appt(startHour,
           startMinute ,
           startDay ,
           startMonth ,
           startYear ,
           title,
          description,
          emailAddress);
appt.setStartMinute(-1);
assertEquals(true, appt.getValid());
}

@Test
 public void test16()  throws Throwable  {
	 int startHour=11;
	 int startMinute=30;
	 int startDay=15;
	 int startMonth=01;
	 int startYear=2018;
	 String title="Birthday Party";
	 String description="This is my birthday party.";

  String emailAddress="ABC@gmail.com";

  Appt appt = new Appt(startHour,
           startMinute ,
           startDay ,
           startMonth ,
           startYear ,
           title,
          description,
          emailAddress);
appt.setStartDay(-1);
assertEquals(true, appt.getValid());
}//end test16 function
@Test
 public void test04()  throws Throwable  {
   Appt appt8 = new Appt(15, 30, 9, 1, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
   appt8.setValid();
   assertTrue(appt8.getValid());
   Appt appt9 = new Appt(15, 30, 9, 12, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
   appt9.setValid();
   assertTrue(appt9.getValid());
   Appt appt10 = new Appt(0, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
   appt10.setValid();
   assertTrue(appt10.getValid());
   Appt appt11 = new Appt(23, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
   appt11.setValid();
   assertTrue(appt11.getValid());
   Appt appt12 = new Appt(15, 0, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
   appt12.setValid();
   assertTrue(appt12.getValid());
   Appt appt13 = new Appt(15, 59, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
   appt13.setValid();
   assertTrue(appt13.getValid());
   Appt appt14 = new Appt(15, 30, 9, 10, 0, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
   appt14.setValid();
   assertFalse(appt14.getValid());
   Appt appt15 = new Appt(15, 30, 31, 1, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
   appt15.setValid();
   assertTrue(appt15.getValid());
   Appt appt16 = new Appt(15, 30, 1, 1, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
   appt16.setValid();
   assertTrue(appt16.getValid());
}
}
