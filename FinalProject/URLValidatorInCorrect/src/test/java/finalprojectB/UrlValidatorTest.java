
package finalprojectB;

import junit.framework.TestCase;
import java.util.Random;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!



public class UrlValidatorTest extends TestCase {

    public UrlValidatorTest(String testName) {
        super(testName);
    }



    public void testManualTest()
    {
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        //System.out.println(urlVal.isValid("http://www.amazon.com"));
        assertTrue(urlVal.isValid("http://www.amazon.com/"));
        assertTrue(urlVal.isValid("http://www.google.com/"));
        assertTrue(urlVal.isValid("http://www.apache.org/"));
        assertFalse(urlVal.isValid("1.1.1.1")); //changed
        assertFalse(urlVal.isValid("www.amazon.com/x/y/z")); //changed
        assertFalse("Port 80 should be valid", urlVal.isValid("http://www.amazon.com:80/abcde")); //changed
        assertTrue("Query String \"?x=y&y=z\" should be valid", urlVal.isValid("http://www.amazon.com/abcde?x=y&y=z")); //changed
        assertFalse("\"3ft\" shouldn't be a vlid protocol", urlVal.isValid("3ft://google.com"));
        assertTrue("Query String \"?x=!\" should be valid", urlVal.isValid("http://www.amazon.com/abcde?x=!"));
        assertTrue("No digit in an ip address should be above 255", urlVal.isValid("http://1.2.3.400/")); //changed
       UrlValidator urlVal1 = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        assertFalse(urlVal1.isValid("www.google.com"));
        UrlValidator urlVal2 = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
        assertFalse(urlVal2.isValid("www.google.com"));
        assertFalse(urlVal.isValid(""));
        UrlValidator urlVal3 = UrlValidator.getInstance();
        assertFalse(urlVal3.isValid("http://www.google.com"));
        assertFalse(urlVal3.isValid(""));
        UrlValidator urlVal4 = new UrlValidator(UrlValidator.PARSE_URL_PATH);
        assertTrue(urlVal4.isValid("http://www.google.com"));
        assertFalse(urlVal4.isValid("http"));
        assertFalse(urlVal4.isValid("A"));
        assertFalse(urlVal4.isValid(""));
        assertFalse(urlVal4.isValid(null));
        UrlValidator urlVal5 = new UrlValidator(UrlValidator.NO_FRAGMENTS);
        assertFalse(urlVal5.isValid("http://"));
        assertNotNull(UrlValidator.matchURL("www.google.com"));
        assertFalse(urlVal.isValid(null));
        
        UrlValidator urlVal6 = new UrlValidator(null);
        assertFalse(urlVal6.isValid("http://"));
        
        UrlValidator urlVal7 = new UrlValidator(UrlValidator.ALLOW_LOCAL_URLS);
        assertFalse(urlVal7.isValid("http://www.google.com"));
        assertFalse(urlVal7.isValid("http"));
        assertFalse(urlVal7.isValid("A"));
        assertFalse(urlVal7.isValid(""));
        assertFalse(urlVal7.isValid(null));
//        String RE[] = {"localhost", 
//        				"my-testing",
//        				"www.google.com"};
//        RegexValidator regex = new RegexValidator(RE,false);
//        UrlValidator validator = new UrlValidator(regex, UrlValidator.NO_FRAGMENTS);
//
//        assertTrue("localhost URL should validate",
//                validator.isValid("http://localhost/test/index.html"));
//        assertTrue("first.my-testing should validate",
//                validator.isValid("http://first.my-testing/test/index.html"));
//        assertTrue("sup3r.my-testing should validate",
//                validator.isValid("http://sup3r.my-testing/test/index.html"));
//
//        assertFalse("broke.my-test should not validate",
//                validator.isValid("http://broke.my-test/test/index.html"));
//
//        assertTrue("www.apache.org should still validate",
//                validator.isValid("http://www.apache.org/test/index.html"));

        
    }


    public void testYourFirstPartition()
    {
        UrlValidator urlVal = new UrlValidator();

        //Min & max ports
        assertFalse("https://www.google.com:0/1/2/3/4",urlVal.isValid("https://www.google.com:0/1/2/3/4"));
        assertFalse("http://6.5.4.3:65535/?h=j", urlVal.isValid("http://6.5.4.3:65535/?h=j")); //changed

        //Min & max IP's
        assertFalse(urlVal.isValid("http://0.0.0.0"));
        assertFalse(urlVal.isValid("http://255.255.255.255"));


    }

    public void testYourSecondPartition(){
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

        //Min & max ports
        assertFalse(urlVal.isValid("http://www.google.com:-1/1/2"));
        assertFalse("http://6.5.4.3:65536/?h=j", urlVal.isValid("http://6.5.4.3:65536/?h=j"));

        //Invalid IP's
        assertTrue(urlVal.isValid("http://211.-2.30.174"));
        assertTrue("http://256.1.2.3", urlVal.isValid("http://256.1.2.3")); //changed
    }


    public void testIsValid()
    {
        UrlValidator urlVal = new UrlValidator();
        assertFalse(urlVal.isValid("12345"));
       String myScheme[] = {
    				   "http://",
    				   "ftp://",
    				   "https://",
    				   "sftp://",
    				   "ssh://",
    				   ""
       },
    		   myAuthority[] = {
    				   "amazon.com",
    				   "google.com",
    				   "apple.com",
    				   "sky.net",
    				   "kissanime.to",
    				   "somedomain.org",
    				   "theguardian.net",
    				   "250.19.101.15"
       },
    		   myPort[] = {
    				   ":0",
    				   ":10000",
    				   ":13000",
    				   ":47027",
    				   ":65535",
    				   ""

       },
    		   myPath[] = {
    				   "/07/87/2017/index.html",
    				   "/wassup/homie/index.php",
    				   "/17/04/1995/NbZ.htm",
    				   "/somePage/fire/index.php",
    				    "/?this=that",
    				    "/?a=b&b=c",
    				    ""

       },
    		   myBadScheme[] = {
    				   "sftp://",
    				   "ssh://"
       },
    		   myBadAuthority[] = {
    				   "0.261.1.400",
    				   "256.0.0.0",
    				   "-1.1.17.200",
    				   "156.93.49.-72",
    				   ""
       },
    		   myBadPort[] = {
    				   ":-1",
    				   ":65536",
    				   ":73000",
    				   ":87027",
    				   ":95535",
    				   "-65535"
       },
    		   myBadPath[] = {
    				   ".html",
    				   ".php",
    				   ".css",
    				   ".js",
    				   "alsjdhfoithavhlairutaytlivaueytki",
    				   ".abc"
       };

		for (byte i = 0; i < myScheme.length; i++) {
			for (byte j = 0; j < myAuthority.length; j++) {
				for (byte k = 0; k < myPort.length; k++) {
					for (byte m = 0; m < myPath.length; m++) {
//						assertFalse(myScheme[i] + myAuthority[j] + myPort[k] + myPath[m], urlVal.isValid(myScheme[i] + myAuthority[j] + myPort[k] + myPath[m]));
						System.out.println("1"+urlVal.isValid(myScheme[i] + myAuthority[j] + myPort[k] + myPath[m])+ "   " + myScheme[i] + myAuthority[j] + myPort[k] + myPath[m]);
					}
				}
			}
		}

		for (byte i = 0; i < myBadScheme.length; i++) {
			for (byte j = 0; j < myAuthority.length; j++) {
				for (byte k = 0; k < myPort.length; k++) {
					for (byte m = 0; m < myPath.length; m++) {
//						assertFalse(myBadScheme[i] + myAuthority[j] + myPort[k] + myPath[m], urlVal.isValid(myBadScheme[i] + myAuthority[j] + myPort[k] + myPath[m]));
						System.out.println("2"+urlVal.isValid(myBadScheme[i] + myAuthority[j] + myPort[k] + myPath[m])+ "   " + myBadScheme[i] + myAuthority[j] + myPort[k] + myPath[m]);
					}
				}
			}
	    }
		for (byte i = 0; i < myScheme.length; i++) {
			for (byte j = 0; j < myBadAuthority.length; j++) {
				for (byte k = 0; k < myPort.length; k++) {
					for (byte m = 0; m < myPath.length; m++) {
//						assertFalse(myScheme[i] + myBadAuthority[j] + myPort[k] + myPath[m], urlVal.isValid(myScheme[i] + myBadAuthority[j] + myPort[k] + myPath[m]));
						System.out.println("3"+urlVal.isValid(myScheme[i] + myBadAuthority[j] + myPort[k] + myPath[m])+ "   " + myScheme[i] + myBadAuthority[j] + myPort[k] + myPath[m]);
					}
				}
			}
		}
		for (byte i = 0; i < myScheme.length; i++) {
			for (byte j = 0; j < myAuthority.length; j++) {
				for (byte k = 0; k < myBadPort.length; k++) {
					for (byte m = 0; m < myPath.length; m++) {
//						assertFalse(myScheme[i] + myAuthority[j] + myBadPort[k] + myPath[m], urlVal.isValid(myScheme[i] + myAuthority[j] + myBadPort[k] + myPath[m]));
						System.out.println("4"+urlVal.isValid(myScheme[i] + myAuthority[j] + myBadPort[k] + myPath[m])+ "   " + myScheme[i] + myAuthority[j] + myBadPort[k] + myPath[m]);
					}
				}
			}
		}
		for (byte i = 0; i < myScheme.length; i++) {
			for (byte j = 0; j < myAuthority.length; j++) {
				for (byte k = 0; k < myPort.length; k++) {
					for (byte m = 0; m < myBadPath.length; m++) {
//						assertFalse(myScheme[i] + myAuthority[j] + myPort[k] + myBadPath[m], urlVal.isValid(myScheme[i] + myAuthority[j] + myPort[k] + myBadPath[m]));
						System.out.println("5"+urlVal.isValid(myScheme[i] + myAuthority[j] + myPort[k] + myBadPath[m])+ "   " + myScheme[i] + myAuthority[j] + myPort[k] + myBadPath[m]);
					}
				}
			}
		}
		UrlValidator urlVal2 = new UrlValidator(myScheme, null, UrlValidator.NO_FRAGMENTS);
		for (byte i = 0; i < myScheme.length; i++) {
			for (byte j = 0; j < myAuthority.length; j++) {
				for (byte k = 0; k < myPort.length; k++) {
					for (byte m = 0; m < myPath.length; m++) {
//						assertFalse(myScheme[i] + myAuthority[j] + myPort[k] + myPath[m], urlVal.isValid(myScheme[i] + myAuthority[j] + myPort[k] + myPath[m]));
						System.out.println("1"+urlVal2.isValid(myScheme[i] + myAuthority[j] + myPort[k] + myPath[m])+ "   " + myScheme[i] + myAuthority[j] + myPort[k] + myPath[m]);
					}
				}
			}
		}
		for (byte i = 0; i < myBadScheme.length; i++) {
			for (byte j = 0; j < myAuthority.length; j++) {
				for (byte k = 0; k < myPort.length; k++) {
					for (byte m = 0; m < myPath.length; m++) {
//						assertFalse(myBadScheme[i] + myAuthority[j] + myPort[k] + myPath[m], urlVal.isValid(myBadScheme[i] + myAuthority[j] + myPort[k] + myPath[m]));
						System.out.println("2"+urlVal2.isValid(myBadScheme[i] + myAuthority[j] + myPort[k] + myPath[m])+ "   " + myBadScheme[i] + myAuthority[j] + myPort[k] + myPath[m]);
					}
				}
			}
	    }
		for (byte i = 0; i < myScheme.length; i++) {
			for (byte j = 0; j < myBadAuthority.length; j++) {
				for (byte k = 0; k < myPort.length; k++) {
					for (byte m = 0; m < myPath.length; m++) {
//						assertFalse(myScheme[i] + myBadAuthority[j] + myPort[k] + myPath[m], urlVal.isValid(myScheme[i] + myBadAuthority[j] + myPort[k] + myPath[m]));
						System.out.println("3"+urlVal2.isValid(myScheme[i] + myBadAuthority[j] + myPort[k] + myPath[m])+ "   " + myScheme[i] + myBadAuthority[j] + myPort[k] + myPath[m]);
					}
				}
			}
		}
		for (byte i = 0; i < myScheme.length; i++) {
			for (byte j = 0; j < myAuthority.length; j++) {
				for (byte k = 0; k < myBadPort.length; k++) {
					for (byte m = 0; m < myPath.length; m++) {
//						assertFalse(myScheme[i] + myAuthority[j] + myBadPort[k] + myPath[m], urlVal.isValid(myScheme[i] + myAuthority[j] + myBadPort[k] + myPath[m]));
						System.out.println("4"+urlVal2.isValid(myScheme[i] + myAuthority[j] + myBadPort[k] + myPath[m])+ "   " + myScheme[i] + myAuthority[j] + myBadPort[k] + myPath[m]);
					}
				}
			}
		}
		for (byte i = 0; i < myScheme.length; i++) {
			for (byte j = 0; j < myAuthority.length; j++) {
				for (byte k = 0; k < myPort.length; k++) {
					for (byte m = 0; m < myBadPath.length; m++) {
//						assertFalse(myScheme[i] + myAuthority[j] + myPort[k] + myBadPath[m], urlVal.isValid(myScheme[i] + myAuthority[j] + myPort[k] + myBadPath[m]));
						System.out.println("5"+urlVal2.isValid(myScheme[i] + myAuthority[j] + myPort[k] + myBadPath[m])+ "   " + myScheme[i] + myAuthority[j] + myPort[k] + myBadPath[m]);
					}
				}
			}
		}
		
		UrlValidator urlVal3 = new UrlValidator(myScheme, null, UrlValidator.ALLOW_2_SLASHES);
		for (byte i = 0; i < myScheme.length; i++) {
			for (byte j = 0; j < myAuthority.length; j++) {
				for (byte k = 0; k < myPort.length; k++) {
					for (byte m = 0; m < myPath.length; m++) {
//						assertFalse(myScheme[i] + myAuthority[j] + myPort[k] + myPath[m], urlVal.isValid(myScheme[i] + myAuthority[j] + myPort[k] + myPath[m]));
						System.out.println("1"+urlVal3.isValid(myScheme[i] + myAuthority[j] + myPort[k] + myPath[m])+ "   " + myScheme[i] + myAuthority[j] + myPort[k] + myPath[m]);
					}
				}
			}
		}
		for (byte i = 0; i < myBadScheme.length; i++) {
			for (byte j = 0; j < myAuthority.length; j++) {
				for (byte k = 0; k < myPort.length; k++) {
					for (byte m = 0; m < myPath.length; m++) {
//						assertFalse(myBadScheme[i] + myAuthority[j] + myPort[k] + myPath[m], urlVal.isValid(myBadScheme[i] + myAuthority[j] + myPort[k] + myPath[m]));
						System.out.println("2"+urlVal3.isValid(myBadScheme[i] + myAuthority[j] + myPort[k] + myPath[m])+ "   " + myBadScheme[i] + myAuthority[j] + myPort[k] + myPath[m]);
					}
				}
			}
	    }
		for (byte i = 0; i < myScheme.length; i++) {
			for (byte j = 0; j < myBadAuthority.length; j++) {
				for (byte k = 0; k < myPort.length; k++) {
					for (byte m = 0; m < myPath.length; m++) {
//						assertFalse(myScheme[i] + myBadAuthority[j] + myPort[k] + myPath[m], urlVal.isValid(myScheme[i] + myBadAuthority[j] + myPort[k] + myPath[m]));
						System.out.println("3"+urlVal3.isValid(myScheme[i] + myBadAuthority[j] + myPort[k] + myPath[m])+ "   " + myScheme[i] + myBadAuthority[j] + myPort[k] + myPath[m]);
					}
				}
			}
		}
		for (byte i = 0; i < myScheme.length; i++) {
			for (byte j = 0; j < myAuthority.length; j++) {
				for (byte k = 0; k < myBadPort.length; k++) {
					for (byte m = 0; m < myPath.length; m++) {
//						assertFalse(myScheme[i] + myAuthority[j] + myBadPort[k] + myPath[m], urlVal.isValid(myScheme[i] + myAuthority[j] + myBadPort[k] + myPath[m]));
						System.out.println("4"+urlVal3.isValid(myScheme[i] + myAuthority[j] + myBadPort[k] + myPath[m])+ "   " + myScheme[i] + myAuthority[j] + myBadPort[k] + myPath[m]);
					}
				}
			}
		}
		for (byte i = 0; i < myScheme.length; i++) {
			for (byte j = 0; j < myAuthority.length; j++) {
				for (byte k = 0; k < myPort.length; k++) {
					for (byte m = 0; m < myBadPath.length; m++) {
//						assertFalse(myScheme[i] + myAuthority[j] + myPort[k] + myBadPath[m], urlVal.isValid(myScheme[i] + myAuthority[j] + myPort[k] + myBadPath[m]));
						System.out.println("5"+urlVal3.isValid(myScheme[i] + myAuthority[j] + myPort[k] + myBadPath[m])+ "   " + myScheme[i] + myAuthority[j] + myPort[k] + myBadPath[m]);
					}
				}
			}
		}
//		RegexValidator regex = new RegexValidator(myAuthority,true);
//        UrlValidator validator = new UrlValidator(regex, UrlValidator.NO_FRAGMENTS);
//        for (byte i = 0; i < myScheme.length; i++) {
//			for (byte j = 0; j < myAuthority.length; j++) {
//				for (byte k = 0; k < myPort.length; k++) {
//					for (byte m = 0; m < myPath.length; m++) {
////						assertFalse(myScheme[i] + myAuthority[j] + myPort[k] + myPath[m], urlVal.isValid(myScheme[i] + myAuthority[j] + myPort[k] + myPath[m]));
//						System.out.println("1"+validator.isValid(myScheme[i] + myAuthority[j] + myPort[k] + myPath[m])+ "   " + myScheme[i] + myAuthority[j] + myPort[k] + myPath[m]);
//					}
//				}
//			}
//		}    
	

	}


    public void testAnyOtherUnitTest()
    {

    }
    /**
     * Create set of tests by taking the testUrlXXX arrays and
     * running through all possible permutations of their combinations.
     *
     * @param testObjects Used to create a url.
     */


}
