import java.util.Calendar;

public class Test {
	//Test objects	
	//Address Objects
	String testCity;
	String testCity2;
	String testCity3;
	String testCity4;
	String testCity5;	
	String testZip;
	String testZip2;
	String testZip3;
	String testZip4;
	String testZip5;	
	String testState;
	String testState2;
	String testState3;
	String testState4;
	String testState5;	
	String testStreet;
	String testStreet2;
	String testStreet3;
	String testStreet4;
	String testStreet5;
	//Reservation objects	
	String testReservationNo;
	String testReservationNo2;
	String testReservationNo3;
	String testReservationNo4;
	String testReservationNo5;
	String testReservationNo6;
	String testReservationNo7;
	String testReservationNo8;
	String testReservationNo9;
	Boolean testKitchenette;
	Boolean testKitchenette2;
	Boolean testKitchenette3;
	Address testAddress;
	Address testAddress2;
	Address testAddress3;
	Integer testNights;
	Integer testNights2;
	Integer testNights3;
	Calendar testStartDate;
	Integer testBedrooms;
	Integer testBedrooms2;
	Integer testBedrooms3;
	Integer testSize;
	Integer testSize2;
	Integer testSize3;
	Integer testBeds;
	Integer testBeds2;
	Integer testBeds3;
	Integer testFloors;
	Integer testFloors2;
	Integer testFloors3;	
	Integer testBaths;
	Integer testBaths2;
	Integer testBaths3;
	//Account objects
	Integer testAccountID;
	Integer testAccountID2;
	Integer testAccountID3;
	
	public Test() {
		//initialize valid Address test data
		testCity = "Pittsburgh";
		testCity2 = "Philadelphia";
		testCity3 = "Hanover";		
		testZip = "15120";
		testZip2 = "19111";
		testZip3 = "17331";
		testState = "Pennsylvania";
		testState2 = "Pennsylvania";
		testState3 = "Pennsylvania";
		testStreet = "600 Becks Run Rd #3104";
		testStreet2 = "1601 Cottman Ave";
		testStreet3 = "305 Baltimore Street";				
		//initialize Reservation test data
		testReservationNo = "H367549765";
		testReservationNo2 = "H660848235";
		testReservationNo3 = "H680848131";
		testReservationNo4 = "A367549765";
		testReservationNo5 = "A660848235";
		testReservationNo6 = "A680848131";
		testReservationNo7 = "O367549765";
		testReservationNo8 = "O660848235";
		testReservationNo9 = "O680848131";
		testKitchenette = true;
		testKitchenette2 = false;
		testAddress = new Address(testCity, testState, testZip, testStreet);
		testAddress2 = new Address(testCity2, testState2, testZip2, testStreet2);
		testAddress3 = new Address(testCity3, testState3, testZip3, testStreet3);		
		testNights = 7;
		testNights2 = 3;
		testNights3 = 1;
		testStartDate = Calendar.getInstance();
		testBedrooms =7;
		testBedrooms2 = 3;
		testBedrooms3 = 1;
		testSize = 620;
		testSize2 = 1010;
		testSize3 = 800;
		testBeds = 1;
		testBeds2 = 2;
		testBeds3 = 5;
		testFloors = 2;
		testFloors2 = 1;
		testFloors3 = 3;
		testBaths = 1;
		testBaths2 = 3;
		testBaths3 =3;
		//initialize Account objects
		testAccountID = 283957383;
		testAccountID2 = 894039289;
		testAccountID3 = 894039;
		//null values
		testCity4 = null;
		testZip4 = null;
		testState4 = null;
		testKitchenette3 = null;
		testStreet4 = null;
		//empty values
		testStreet5 = "";
		testState5 = "";
		testCity5 = "";
		testZip5 = "";	
	}
	
	public void testHotelReservationClass() {
		//test case #1
		testHotelReservationConstructor();
		//test case #2
		testHotelReservationConstructor2(); 
		//test case #3
		testHotelReservationConstructor3(); 
		//test case #4
		testHotelReservationConstructor4(); 
		//test case #5
		testHotelReservationConstructor5();
		//test case #6
		testHotelReservationConstructor6();
		//test case #7
		testReservationSaveToFile();
		//test case #8
		testHotelReservationPricePrerNight();
		//test case #9
		testHotelReservationPricePrerNight2();
		 
	}
	
	//this method tests the Reservation/HotelReservation(String, Boolean, Address, Address, Integer, Integer, Calendar, Integer, Integer) constructor for initialization using toString()
	public void testHotelReservationConstructor() {
		System.out.println("testHotelReservationConstructor() - Using 3 HotelReservations, this method tests the Reservation/HotelReservation constructor that takes two Address parameters for expected functionality [assigning values & toString()] .\n");		
		HotelReservation hrTest = new HotelReservation(testReservationNo, testKitchenette, testAddress, testAddress3, testBeds, testNights, testStartDate, testBedrooms, testSize);
		HotelReservation hrTest2 = new HotelReservation(testReservationNo2, testKitchenette2, testAddress2, testAddress2, testBeds2, testNights2, testStartDate, testBedrooms2, testSize2);
		HotelReservation hrTest3 = new HotelReservation(testReservationNo3, testKitchenette, testAddress, testAddress, testBeds3, testNights3, testStartDate, testBedrooms3, testSize3);		
		System.out.println(hrTest.toString());
		System.out.println(hrTest2.toString());
		System.out.println(hrTest3.toString());
		System.out.println("\n");
	}
	
	//this method tests the Reservation/HotelReservation(String, Boolean, Address, Integer, Integer, Calendar, Integer, Integer) constructor for initialization using toString()
	public void testHotelReservationConstructor2() {
		System.out.println("testHotelReservationConstructor2() - Using 3 HotelReservations, this method tests the Reservation/HotelReservation constructor that takes one Address parameter for expected functionality [assigning values& toString()] .\n");		
		HotelReservation hrTest = new HotelReservation(testReservationNo, testKitchenette, testAddress, testBeds, testStartDate, testNights, testBedrooms, testSize);
		HotelReservation hrTest2 = new HotelReservation(testReservationNo2, testKitchenette2, testAddress2, testBeds2, testStartDate, testNights2, testBedrooms2, testSize2);
		HotelReservation hrTest3 = new HotelReservation(testReservationNo3, testKitchenette, testAddress3, testBeds3, testStartDate, testNights3, testBedrooms3, testSize3);	
		System.out.println(hrTest.toString());
		System.out.println(hrTest2.toString());
		System.out.println(hrTest3.toString());
		System.out.println("\n");
	}
	
	//this method tests the HotelReservation(String, Boolean, Address, Address, Integer, Integer, Calendar, Integer, Integer) constructor for validation of values - no nulls accepted
	public void testHotelReservationConstructor3() {
		System.out.println("testHotelReservationConstructor3() - Using single HotelReservation, this method tests the HotelReservation constructor that takes two Address parameters for expected functionality [null value detection + IllegalArgumentExcpetion class (error msg)] .\n");		
		try {
			HotelReservation hrTest = new HotelReservation(testReservationNo, testKitchenette3, testAddress, testAddress, testBeds, testNights, testStartDate, testBedrooms, testSize);	
			System.out.println(hrTest.toString());		
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.toString());
		}
		System.out.println("\n");
	}
	
	//this method tests the HotelReservation(String, Boolean, Address, Integer, Integer, Calendar, Integer, Integer) constructor for validation of values - no nulls accepted
		public void testHotelReservationConstructor4() {
			System.out.println("testHotelReservationConstructor4() - Using single HotelReservation, this method tests the Reservation/HotelReservation constructor that takes single Address parameter for expected functionality [null value detection + IllegalArgumentExcpetion class (error msg)] .\n");		
			try {
				HotelReservation hrTest = new HotelReservation(testReservationNo, testKitchenette3, testAddress, testBeds, testStartDate, testNights, testBedrooms, testSize);	
				System.out.println(hrTest.toString());				
			}
			catch (IllegalArgumentException iae) {
				System.out.println(iae.toString());
			}
			System.out.println("\n");
		}
		
		//this method tests the HotelReservation(String, Boolean, Address, Integer, Integer, Calendar, Integer, Integer) constructor for validation of values - no empty Strings accepted
		public void testHotelReservationConstructor5() {
			System.out.println("testHotelReservationConstructor5() - Using single HotelReservation, this method tests the Reservation/HotelReservation constructor that takes single Address parameter for expected functionality [empty String + IllegalArgumentExcpetion class (error msg)] .\n");		
			try {
				//change street to empty value
				testAddress.setStreet(testStreet5);
				HotelReservation hrTest = new HotelReservation(testReservationNo, testKitchenette3, testAddress, testBeds, testStartDate, testNights, testBedrooms, testSize);	
				System.out.println(hrTest.toString());
				//change it back
				testAddress.setStreet(testStreet5);
			}
			catch (IllegalArgumentException iae) {
				System.out.println(iae.toString());
			}
			System.out.println("\n");
		}
		//tests Reservation/HotelReservation constructor for file parsing
		public void testHotelReservationConstructor6() {
			System.out.println("testHotelReservationConstructor6() - Using single HotelReservation, this method tests the Reservation/HotelReservation constructor that takes single String parameter for expected functionality \n");
			HotelReservation hrTest = new HotelReservation("H367549765.txt");
			System.out.println(hrTest.toString());
		}
		//tests Reservation/HotelReservation for saving Reservation to file
		public void testReservationSaveToFile() {
			System.out.println("testReservationSaveToFile() - Using single HotelReservation, this method tests the functionality of saving Reservation/HotelReservation to file \n");
			HotelReservation hrTest = new HotelReservation(testReservationNo, testKitchenette2, testAddress, testBeds, testStartDate, testNights, testBedrooms, testSize);
			hrTest.saveToFile("");
			System.out.println("Reservation file saved to working directory.");
		}
		//tests Reservation/HotelReservation for price per night; one bedroom and one night
		public void testHotelReservationPricePrerNight() {
			System.out.println("testHotelReservationPricePrerNight() - tests Reservation/HotelReservation for price per night; one bedroom and one night");
			HotelReservation hrTest3 = new HotelReservation(testReservationNo3, testKitchenette, testAddress3, testBeds3, testStartDate, testNights3, testSize3, 4);
			System.out.println("The price per night for a hotel reservation size of" + hrTest3.getReservationsize() + " with " + testBedrooms3 + " bedroom for " + testNights3 + "nights is " +  hrTest3.calculatePricePerNight());
		}
		
		//tests Reservation/HotelReservation for price per night; two bedrooms and two nights
		public void testHotelReservationPricePrerNight2() {
			System.out.println("testHotelReservationPricePrerNight()2 - tests Reservation/HotelReservation for price per night; two bedrooms and two nights.");
			HotelReservation hrTest3 = new HotelReservation(testReservationNo3, testKitchenette, testAddress3, testBeds3, testStartDate, 2, 1120, 2);
			System.out.println("The price per night for a hotel reservation size of " + hrTest3.getReservationsize() + " with " + hrTest3.getNumberofbedrooms() + " bedroom for " + hrTest3.getNumberofnights() + " nights is " +  hrTest3.calculatePricePerNight());
		}
	
	//this method tests the Address Class functionality using different test cases
	public void testAddressClass() {
		//test case #1
		testAddressConstructor();
		//test case #4
		testAddressConstructor4();
		try {
			//test case #2
			testAddressConstructor2();
			//test case #3
			testAddressConstructor3();
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.toString());
		}
	}
	
	//test toString() and initialization using Address(String,String,String,String) constructor
	public void testAddressConstructor() {
		System.out.println("testAddressConstructor() - Using 3 Addresses, this method tests the Address constructor that takes multiple String parameters for expected functionality [assigning values] .\n");
		Address one = new Address(testCity, testState, testZip, testStreet);
		Address two = new Address(testCity2, testState2, testZip2, testStreet2);
		Address three = new Address(testCity3, testState3, testZip3, testStreet3);
		System.out.println(one.toString());
		System.out.println(two.toString());
		System.out.println(three.toString());
		System.out.println("\n");
	}
	//test null values using Address(String,String,String,String) constructor
	public void testAddressConstructor2() {
		System.out.println("testAddressConstructor2() - Using 1 Address, this method tests the Address constructor that takes multiple String parameters for null values.\n");
		Address one = new Address(testCity4, testState, testZip, testStreet);
		System.out.println(one.toString());
		System.out.println("\n");
	}
	
	//test empty values using Address(String,String,String,String) constructor
	public void testAddressConstructor3() {
		System.out.println("testAddressConstructor3() - Using 1 Address, this method tests the Address constructor that takes multiple String parameters for empty values.\n");
		Address one = new Address(testCity5, testState, testZip, testStreet);
		System.out.println(one.toString());
		System.out.println("\n");
	}
	
	//test Address constructor using Address(String) constructor
	public void testAddressConstructor4() {
		System.out.println("testAddressConstructor4() - Using 3 Address, this method tests the Address constructor that takes a single String parameters. \n");
		
		//xml toString() output from testAddressConstructor()
		String xmlAddressOne = "<address><street>1601 Cottman Ave</street><city>Philadelphia</city><state>Pennsylvania</state><zip>19111</zip></address>";
		String xmlAddressTwo = "<address><street>305 Baltimore Street</street><city>Hanover</city><state>Pennsylvania</state><zip>17331</zip></address>";
		String xmlAddressThree = "<address><street>600 Becks Run Rd #3104</street><city>Pittsburgh</city><state>Pennsylvania</state><zip>15120</zip></address>";
		
		//call to Address(String)
		Address one = new Address(xmlAddressOne);
		Address two = new Address(xmlAddressTwo);
		Address three = new Address(xmlAddressThree);
		//verify output
		System.out.println(one.toString());
		System.out.println(two.toString());
		System.out.println(three.toString());
		System.out.println("\n");
	}
	
	public void testAccountClass() {
		//test case #1
		testAccountConstructor();
		//test case #2
		testAccountConstructor2();
		//test case #3
		testAccountConstructor3();
		//test case #4
		testAccountSaveToFile();
		//test case #5
		testAccountConstructor4();
		//test case #6
		testAccountConstructor5();
	}
	
	//tests the Account(Integer, Address , String ) constructor for 9 digit Account ID validation
	public void testAccountConstructor() {
		System.out.println("TestAccountConstructor() - Using 1 Account, this method tests the Account constructor - Account(Integer accountID, Address mailing, String email) for 9 digit Account ID validation. \n");
		Account testAccount = new Account(testAccountID3, testAddress, "trueblue@hotmail.com");
		System.out.println(testAccount.toString());
	}
	
	//tests the Account(Integer, Address , String ) constructor for email length
	public void testAccountConstructor2() {
		System.out.println("TestAccountConstructor()2 - Using 1 Account, this method tests the Account constructor - Account(Integer accountID, Address mailing, String email) email validation [no empty]. \n");
		Account testAccount = new Account(testAccountID, testAddress, "");
		System.out.println(testAccount.toString());
	}
	
	//tests the Account(Integer, Address , String ) constructor for no nulls
	public void testAccountConstructor3() {
		System.out.println("TestAccountConstructor()3 - Using 1 Account, this method tests the Account constructor - Account(Integer accountID, Address mailing, String email) email validation [no nulls]. \n");
		Account testAccount = new Account(testAccountID, null, "trueblue@hotmail.com");
		System.out.println(testAccount.toString());
	}
	
	//tests the Account(String) constructor for parsing
		public void testAccountConstructor4() {
			System.out.println("TestAccountConstructor()4 - Using 1 Account, this method tests the Account constructor - Account(String) for parsing. \n");
			Account testAccount = new Account("");
			System.out.println(testAccount.toString());
		}
		
		//tests the Account(String) constructor for parsing [IllegalLoadExcpetion]
		public void testAccountConstructor5() {
			System.out.println("TestAccountConstructor()5 - Using 1 Account, this method tests the Account constructor - Account(String) for parsing.[IllegalLoadExcpetion] \n");
			try {
				Account testAccount = new Account("not a file");
				testAccount.toString();
			}
			catch(IllegalLoadException ile) {
				System.out.println("An IllegalLoadException has occured:" + ile.toString());
			}
		}
	
		
	//tests the Account(Integer, Address , String ) constructor for no nulls
	public void testAccountSaveToFile() {
		System.out.println("testAccountSaveToFile() - Using 1 Account, this method tests the Account save to file method. \n");
		Account testAccount = new Account(testAccountID, testAddress, "trueblue@hotmail.com");
		testAccount.saveToFile("");
		System.out.println("Account file saved to working directory.");
	}
	//this method tests the manager class functionality 
	public void testManagerClass() {
		testManagerAddAccount();
	}
	
	//this method tests the constructor, addAccount(), getAccount() methods of Manager class; verifies using toString()
	public void testManagerAddAccount() {
		Manager m = new Manager();
		m.addAccount(new Account("acc-283957383.txt"));
		Account temp = m.getAccount(283957383);
		temp.toString();
	}
	//some cases will execute others wont; ie error cases
	public static void main(String [] args) {
		Test driver = new Test();
		driver.testAddressClass();
		driver.testHotelReservationClass();
		driver.testManagerAddAccount();
	}
}
