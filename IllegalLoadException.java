
@SuppressWarnings("serial")
public class IllegalLoadException extends RuntimeException {
	private String message;	//meaningful msg for to string

	  //constructor assigns name of failed file, account and calling method to appropiate variables
	  public IllegalLoadException(String fileName, Integer accountID, String errorOrigin) {
		//must call super passing meaningful message for first statement
		  super("Account# " + accountID + ": The file " + fileName + " could not be parsed. There was an issue with the " + errorOrigin + " file.");
		  //construct message
		  message = "Account# " + accountID + ": The file " + fileName + " could not be parsed. There was an issue with the " + errorOrigin + " file.";
	  }

	  //returns meaningful message regarding exceptional event
	  public String toString() {
		  //display meaningful msg
		  return message;
	  }
}
