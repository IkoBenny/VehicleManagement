import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;

public class HotelReservation extends Reservation {

	private Boolean hasKitchenette; 

	//loads Hotel Reservation from file, using given filename
	public HotelReservation(String fileName) {	
		//call to super constructor
		super(fileName);
		//load String from file - filename
		String line;
		Scanner sc;
		try {
			sc = new Scanner(new File(fileName));
			line = sc.nextLine();	
			sc.close();
		} catch (FileNotFoundException e) {
			//if file name doesnt exist/object cannot be loaded throw IllegalLoadException and fail
			throw new IllegalLoadException(fileName, accountID , "Hotel Reservation");
		}

		catch (Exception e) {
			//if file name doesnt exist/object cannot be loaded throw IllegalLoadException and fail
			throw new IllegalLoadException(fileName, accountID , "Hotel Reservation");
		}
		//otherwise create the object	
		//parse String
		//get hasKitchenette value
		int hasKitchenetteOpenTagPos = line.indexOf("<haskitchenette>");
		int hasKitchenetteCloseTagPos = line.indexOf("</haskitchenette>");
		hasKitchenette = Boolean.parseBoolean(line.substring(hasKitchenetteOpenTagPos + 16, hasKitchenetteCloseTagPos));
	}

	//constructor for when mailing address is not explicitly given
	public HotelReservation(String reservationNo, Boolean kitchenette, Address physical, Integer nights, Calendar startDate, Integer bedrooms, Integer size, Integer beds) {
		
		//initalize values
		super(reservationNo, physical, nights, bedrooms, size, startDate, beds);
		hasKitchenette = kitchenette;		
		//validate values
		if(hasKitchenette.equals(null))
			throw new IllegalArgumentException("Parameter values cannot be null");
	}

	//constructor for when mailing address is explicitly given
	public HotelReservation(String reservationNo, Boolean kitchenette, Address physical, Address mailing, Integer beds, Integer nights, Calendar startDate, Integer bedrooms, Integer size) {
		//initalize values
		super(reservationNo, physical, mailing, startDate, nights, beds, size, bedrooms);
		hasKitchenette = kitchenette;
		//validate values
		if(hasKitchenette.equals(null))
			throw new IllegalArgumentException("Parameter values cannot be null");
	}

	//get XML formatted data for Hotel Reservation; return as String
	public String toString() {
		//format data in XML format
		String line = "<hotelreservation>" +  super.toString() + "<haskitchenette>" + hasKitchenette + "</haskitchenette>" + "</hotelreservation>";
		//return as String
		return line;
	}
	
	public void setHasKitchenette(Boolean kitchen) {
		//validate draft status, kitchen value
		if(kitchen == null)
			throw new IllegalArgumentException("Kitchenette status cannot be null");
		// if draft, set value
		if(reservationStatus.equals("draft"))
			hasKitchenette = kitchen;
		//otherwise it fails with IllegalStateException being thrown
		else
			throw new IllegalStateException("Reservation is not in draft status; state cannot be changed.");
	 }

	public void updateReservation(HotelReservation reservation) {
		//validate input/reservation values
		super.updateReservation(reservation);
			this.hasKitchenette = reservation.hasKitchenette;		
	}
	
	//returns true if this hotel has a kitchentte
	public Boolean getKitchenetteStatus() {
		return hasKitchenette;
	}



}