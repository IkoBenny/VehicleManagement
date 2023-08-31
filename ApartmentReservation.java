import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;

public class ApartmentReservation extends Reservation {

	private Integer noOfBathrooms; 
	
	//constructor for when mailing address is not explicitly given
	public ApartmentReservation(String reservationNo, Integer bathroomNo, Address physical, Integer bedrooms, Integer beds, Integer nights, Calendar startDate, Integer size) {
		//initalize values
		super(reservationNo, physical, nights, bedrooms, size, startDate, beds);
		noOfBathrooms = bathroomNo;
		//validate values
		if(bathroomNo == null)
			throw new IllegalArgumentException("Parameter values cannot be null or empty strings");		
			
	}

	//constructor for when mailing address is explicitly given
	public ApartmentReservation(String reservationNo, Integer bathroomNo, Address physical, Address mailing, Integer beds, Integer bedrooms, Integer nights, Calendar startDate, Integer size) {
		//initalize values
		super(reservationNo, physical, mailing, startDate, nights, beds, size, bedrooms);
		noOfBathrooms = bathroomNo;
		//validate values
		if(bathroomNo == null)
			throw new IllegalArgumentException("Parameter values cannot be null or empty strings");
	}
	
	//constructor for loading object from file
	public ApartmentReservation(String fileName) {	
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
			throw new IllegalLoadException(fileName, accountID , "Apartment Reservation");
		}

		catch (Exception e) {
			//if file name doesnt exist/object cannot be loaded throw IllegalLoadException and fail
			throw new IllegalLoadException(fileName, accountID , "Apartment Reservation");
		}
		//otherwise create the object	
		//parse String
		//get noOfBathrooms value
		int noOfBathroomsOpenTagPos = line.indexOf("<noofbathrooms>");
		int noOfBathroomsCloseTagPos = line.indexOf("</noofbathrooms>");
		noOfBathrooms = Integer.parseInt(line.substring(noOfBathroomsOpenTagPos + 15, noOfBathroomsCloseTagPos));
	  }

	public void updateReservation(ApartmentReservation reservation) {
		//validate input/reservation values
		super.updateReservation(reservation);
		//assign this reservation to the paramaters values
		this.noOfBathrooms = reservation.noOfBathrooms;
	}

	public Float calculatePricePerNight() {
		//call super
		Float base = super.calculatePricePerNight();
		//additional fees
		Float perBedroom = 20.0f;
		Float perBathroom = 5.0f;
		//calculate price per night
		if(noOfBedrooms > 1)
			base = Float.sum(perBedroom * noOfBedrooms, base);
		if(noOfBathrooms > 1)
			base = Float.sum(perBathroom * noOfBathrooms, base);
		//return price per night
		return base;
	}

	//format data as XML, then return to String
	public String toString() {
		//format this Apartment's data as XML
		String line = "<housereservation> " + super.toString() + "<noofbathrooms>" + noOfBathrooms + "</noofbathrooms>" + "</housereservation>";
		//return data as String
		return line;
	}
	
	 public void setNoOfBathrooms(Integer bathrooms) {
			//validate draft status, bathrooms
			if(bathrooms == null)
				throw new IllegalArgumentException("number of bathrooms may not be null");
			// if draft, set value
			if(reservationStatus.equals("draft"))
				noOfBathrooms = bathrooms;
			//otherwise it fails with IllegalStateException being thrown
			else
				throw new IllegalStateException("Reservation is not in draft status; state cannot be changed.");
	  }
	

	//return no of bathrooms for this partment reservation
	public Integer getNumberofbathrooms() {
		return noOfBathrooms;
	}
}
