
@SuppressWarnings("serial")
public class IllegalOperationException extends RuntimeException {
	 private String message;

	  //assigns failed operation, account id and res num to appropiate variables
	  public IllegalOperationException(Integer accountID, String reservationNo, String errorOrigin) {
		//must call super passing meaningful message for first statement
		  super("The call to " + errorOrigin + " was unsuccesful." + " Reservation# " + reservationNo + " could not be finalized." +
				  	"The reservation will not be added to Account# " + accountID + ".");
		  //construct msg
		  message = "The call to " + errorOrigin + " was unsuccesful." + " Reservation# " + reservationNo + " could not be finalized." +
				  	"The reservation will not be added to Account# " + accountID + ".";
	  }

	//returns meaningful message regarding exceptional event
	  public String toString() {
	  	//display meaningful msg using stored values
		  return message;
	  }
}
