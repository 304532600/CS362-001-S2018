
/** A JUnit test class to test the class DataHandler. */



package calendar;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;
import java.time.Month;
import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
DataHandler data= new DataHandler();
    int startHour=21;
    			int startMinute=30;
    			int startDay=15;
    			int startMonth=01;
    			int startYear=2018;
    			String title="Birthday Party";
    			String description="This is my birthday party.";
          String emailAddress= "ABC@gmail.com";
    			//Construct a new Appointment object with the initial data
    			Appt appt = new Appt(startHour,
    							 startMinute ,
    							 startDay ,
    							 startMonth ,
    							 startYear ,
    							 title,
    							description,
                  emailAddress);

                  int day=23;
                  		 int month=9;
                  		 int year=2018;
          java.util.LinkedList <calendar.Appt> appts2;
          GregorianCalendar cal = new GregorianCalendar();
          cal.set(2018, 1, 27);
          day = 27;
          GregorianCalendar cal2 = new GregorianCalendar();
          cal2.set(2018, 1, 25);
    		  assertTrue(appt.getValid());

          Appt appt3 = new Appt(25,
                   40 ,
                   10 ,
                   10 ,
                   2018 ,
                   "title",
                  "description",
                  "emailAddress");
          CalDay calday = new CalDay(cal);
         	CalDay calday2 = new CalDay(cal2);
          calday.addAppt(appt);
		      calday2.addAppt(appt3);
      	  appts2= calday.getAppts();

          String convert;
		 convert = calday.toString();

		 assertTrue(appt.getValid());

		 assertTrue(calday.isValid());
		 assertTrue(calday2.isValid());
     assertTrue(data.save());
		 assertNotNull(data.getApptRange(cal2, cal));
     assertTrue(data.saveAppt(appt));
     assertTrue(data.deleteAppt(appt));
     assertTrue(data.saveAppt(appt3));
     assertTrue(data.deleteAppt(appt3));
     //data.getNextApptOccurrence(appt,cal2);

     // assertNotNull(appts2.getDocument());
     // assertNotNull(appts.getFileName());
     Appt appt4 = new Appt(0,0,0,0,0,"","","");
     CalDay calday3 = new CalDay(cal2);
     calday3.addAppt(appt4);
     assertTrue(calday3.isValid());
     int recurdays[] = null;
 		int recurby = 1;
 		int recurinc = 1;
 		int recurnnum= 1;
 		appt.setRecurrence(recurdays, recurby, recurinc, recurnnum);
 		appt.isRecurring();
         }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
    DataHandler data= new DataHandler("x", false);
        int startHour=21;
        			int startMinute=30;
        			int startDay=15;
        			int startMonth=01;
        			int startYear=2018;
        			String title="Birthday Party";
        			String description="This is my birthday party.";
              String emailAddress= "ABC@gmail.com";
        			//Construct a new Appointment object with the initial data
        			Appt appt = new Appt(startHour,
        							 startMinute ,
        							 startDay ,
        							 startMonth ,
        							 startYear ,
        							 title,
        							description,
                      emailAddress);
                      int recurdays[] = new int[3];
                  		int recurby = 2;
                  		int recurinc = 1;
                  		int recurnnum= 1;
                  		appt.setRecurrence(recurdays, recurby, recurinc, recurnnum);
                  		appt.isRecurring();


  }

}
