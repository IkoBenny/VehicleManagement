
@SuppressWarnings("serial")
public class DuplicateObjectException extends RuntimeException {
	private String message;	//meaningful msg for to string
	  
	  //constructors assign relevant, appropiate values to string depending on situation
	  
	  //for when an account already exists
	  public DuplicateObjectException(Integer accountID, String origin) {
		  //must call super passing meaningful message for first statement
		  super("The caller " + origin + " has generated an error. " + "The account# " + accountID + " already exists.");
		  //save state for where error came from, and account info
		  message = "The caller " + origin + " has generated an error. " + "The account# " + accountID + " already exists.";
	  }
	  //for when a reservation already exists
	  public DuplicateObjectException(String reservationNo, String origin) {
		  //must call super passing meaningful message for first statement
		  super("The caller " + origin + " has generated an error. " + "The reservation# " + reservationNo + " already exists.");
		  //save state for reservation no, and where error came from
		  message = "The caller " + origin + " has generated an error. " + "The reservation# " + reservationNo + " already exists.";
	  }

	  public DuplicateObjectException(String reservationNo, Integer accountID, String errorOrigin) {
		  //must call super passing meaningful message for first statement
		  super("The caller " + errorOrigin + " has generated an error. " + "The account# " + accountID + 
				  ", and/or the reservation# " + reservationNo + " already exists.");
		  //save account and reservation info, and oorigin info
		  message = "The caller " + errorOrigin + " has generated an error. " + "The account# " + accountID + 
				  ", and/or the reservation# " + reservationNo + " already exists.";
	  }

	 //displays the message with pertinent excepional event information
	  public String toString() {
		  return message;
	  }

}
