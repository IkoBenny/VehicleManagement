import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;

public class HouseReservation extends Reservation {

	private Integer noOfFloors;

	private Integer noOfBathrooms;
	
	public HouseReservation(String fileName) {
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
			throw new IllegalLoadException(fileName, accountID , "House Reservation");
		}

		catch (Exception e) {
			//if file name doesnt exist/object cannot be loaded throw IllegalLoadException and fail
			throw new IllegalLoadException(fileName, accountID , "House Reservation");
		}
		//otherwise create the object	
		//parse String
		//get noOfFloors value
		int noOfFloorsOpenTagPos = line.indexOf("<nooffloors>");
		int noOfFloorsCloseTagPos = line.indexOf("</nooffloors>");
		noOfFloors = Integer.parseInt(line.substring(noOfFloorsOpenTagPos + 12, noOfFloorsCloseTagPos));
		//get noOfBathrooms value
		int noOfBathroomsOpenTagPos = line.indexOf("<noofbathrooms>");
		int noOfBathroomsCloseTagPos = line.indexOf("</noofbathrooms>");
		noOfBathrooms = Integer.parseInt(line.substring(noOfBathroomsOpenTagPos + 15, noOfBathroomsCloseTagPos));
		
	}

	//constructor for when mailing address is not explicitly given
	public HouseReservation(String reservationNo, Integer bathroomNo, Integer floorNo, Address physical, Integer nights, Integer bedrooms, Integer size, Calendar startDate, Integer beds) {
		//initalize values
		super(reservationNo, physical, nights, bedrooms, size, startDate, beds);
		noOfFloors = floorNo;
		noOfBathrooms = bathroomNo;
		//validate values
		if(noOfFloors == null || noOfBathrooms == null )
			throw new IllegalArgumentException("Parameter values cannot be null");		
	}

	//constructor for when mailing address is explicitly given
	public HouseReservation(String reservationNo, Integer bathroomNo, Integer floorNo, Address physical, Integer nights, Address mailing, Calendar startDate, Integer bedrooms, Integer size, Integer beds) {
		//initalize values
		super(reservationNo, physical, mailing, startDate, nights, beds, size, bedrooms);
		noOfFloors = floorNo;
		noOfBathrooms = bathroomNo;
		//validate values
		if(noOfFloors == null || noOfBathrooms == null)
			throw new IllegalArgumentException("Parameter values cannot be null");		
	}

	//get XML formatted data for this House Reservation,  then return it  as String
	public String toString() {
		//format data in XML
		String line = "<housereservation> " + super.toString() + "<nooffloors>" + noOfFloors + "</nooffloors>" + "<noofbathrooms>" + noOfBathrooms + "</noofbathrooms>" +"</housereservation>";
		//return it  as String
		return line;
	}

	public Float calculatePricePerNight() {
			//call super
			Float base = super.calculatePricePerNight();
			//additional fees
			Float perBedroom = 20.0f;
			Float perBathroom = 5.0f;
			Float perFloor = 5.0f;
			//calculate price per night
			if(noOfFloors > 1)
				base = Float.sum(perFloor * noOfFloors, base);
			if(noOfBedrooms > 1)
				base = Float.sum(perBedroom * noOfBedrooms, base);
			if(noOfBathrooms > 1)
				base = Float.sum(perBathroom * noOfBathrooms, base);
			//return price per night
			return base;
	}
	
	public void setNoOfFloors(Integer floors) {
		//validate draft status, floors
		if(floors == null)
			throw new IllegalArgumentException("number of floor may not be null");
		// if draft, set value
		if(reservationStatus.equals("draft"))
			noOfFloors = floors;
		//otherwise it fails with IllegalStateException being thrown
		else
			throw new IllegalStateException("Reservation is not in draft status; state cannot be changed.");
	  }

	public void updateReservation(HouseReservation reservation) {
		//validate input/reservation values
		super.updateReservation(reservation);
		//assign this reservation to the paramaters values
		this.noOfFloors = reservation.noOfFloors;
		this.noOfBathrooms = reservation.noOfBathrooms;
	}

	//return number of floors for this house reservation
	public Integer getFloorsnumber() {
		return noOfFloors;
	}

	//return number of bathrroms for this house reservation
	public Integer getNumberofbathrooms() {
		return noOfBathrooms;
	}
	
	//sets the number of bathrooms for this house reservation
	public void setNoOfBathrooms(Integer bathrooms) {
		//validate draft status, bathrooms
		if(bathrooms == null)
			throw new IllegalArgumentException("reservation start date may not be null");
		// if draft, set value
		if(reservationStatus.equals("draft"))
			noOfBathrooms = bathrooms;
		//otherwise it fails with IllegalStateException being thrown
		else 
			throw new IllegalStateException("Reservation is not in draft status; state cannot be changed.");
	  }
	
}