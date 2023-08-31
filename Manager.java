import java.io.File;
import java.util.Vector;

public class Manager {

	private Vector <Account> accounts;	//to load all the existing accounts and their associated lodging reservations on startup.

	private final String PATH = "C:/tmp/accounts/";	//hard-coded path for storing directories
	
	//create instance of manager
	public Manager() {
		//create vector for accounts
		accounts = new Vector <Account>();
		//get directory
		File dir = new File(PATH);
		if(dir.isDirectory()) {
			String [] list = dir.list();
			for(int i =0; i < list.length; i++) {
				//load the accounts data from the hardcoded path
				//get names of all files in directory
				String line = list[i];
				 Account a = new Account(PATH + line);
				 accounts.add(a);
			}	
		}
		else
		//if Path path does not exist, it should create it
		dir.mkdir();
	}

	//adds given reservation, to given account
	public void addReservation(Integer accountNumber, Reservation reservation) {
		boolean flag = false;
		for(int i =0; i<accounts.size(); i++) {
			//find the appropriate account that matches the passed in id
			if(accounts.get(i).getAccountid().compareTo(accountNumber) == 0) {
				flag = true;
				//call its add method (separation of concerns principle);
				accounts.get(i).addReservation(reservation);
			}
		}
		//if account object with matching id doesnt exist,
		if(flag == false)
			//then throw llegalargumentexception, otherwise
			throw new DuplicateObjectException(accountNumber, "Manager");				
	}

	//returns the Account object associated with accountno parameter
	public Account getAccount(Integer accountNo) {
		Account temp = null;
		//get the account matched by accountNo
		for(int i =0; i< accounts.size(); i++) {
			if(accounts.get(i).getAccountid().compareTo(accountNo) == 0)
				temp = accounts.get(i);				
		}
		//return null if it does not exist
			return temp;	
	}

	public void updateReservation(Integer accountNo, Reservation reservation) {
		//find account by number
		boolean flag = false;
		for(int i =0; i<accounts.size(); i++) {
			if(accounts.get(i).getAccountid().compareTo(accountNo) == 0) {
				flag = true;
				//update reservation
				accounts.get(i).updateReservation(reservation);
			}
		}
		if(flag == false)
		//throw IllegalArgumentException if does not exist
		throw new IllegalArgumentException("Account# " + accountNo + " does not exist.");
	}
	
	//adds new managed account object
	public void addAccount(Account account) {
		//if account number exists already throw duplicateobjectexception
		for(int i =0; i<accounts.size(); i++) {
			if(accounts.get(i).getAccountid().compareTo(account.getAccountid()) == 0) {
				throw new DuplicateObjectException(account.getAccountid(), "Manager");
			}
		}
		//add to managed accounts
		accounts.add(account);
	}

	public void updateAccount(Account account) {
		boolean exists = false;
		//call Account update method 
		for(int i =0; i<accounts.size(); i++) {
			if(accounts.get(i).getAccountid().compareTo(account.getAccountid()) == 0) {
				accounts.get(i).updateAccount(account);
				exists = true;
			}
		}
		//throw IllegalArgumentException if account doesnt exist
		if(exists == false)
			throw new IllegalArgumentException("The account " + account.getAccountid() + " does not exist.");
	}

	public void completeReservation(Integer accountNo, Reservation reservation) {
		//find right account,reservation
		boolean found = false;
		for(int i =0; i< accounts.size(); i++) {
			if(accounts.get(i).getAccountid().compareTo(accountNo) == 0)
				//call  appropiate complete reservation in account, then reservation class
				accounts.get(i).completeReservation(reservation.getReservationnumber());
			found = true;
		}		
		//if matching account doesnt exist, throw IllegalArgumentException
		if(found == false) {
			throw new IllegalArgumentException("The account with account# "+ accountNo + "does not exist." );
		}
	}

	public void cancelReservation(Integer accountNo, Reservation reservation) {
		//find right account,reservation
		for(int i =0; i< accounts.size(); i++) {
			if(accounts.get(i).getAccountid().compareTo(accountNo) == 0)
				//call  appropiate cancel reservation in account, then reservation class
				accounts.get(i).cancelReservation(reservation.getReservationnumber());
		}		
	}

	public Float calculatePricePerNight(Integer accountNo, String reservationNumber) {
		Float price = null;
		//find account
		for(int i =0; i < accounts.size(); i++) {
			if(accounts.get(i).getAccountid().compareTo(accountNo) == 0)
				//find reservation
				//call methods for calculating price
				price =  accounts.get(i).calculateReservationPricePerNight(reservationNumber);
		}
		return price;
	}

	public Float calculateTotalReservationPrice(Integer accountNo, String reservationNumber) {
		Float price = null;
		//find account
		for(int i =0; i < accounts.size(); i++) {
			if(accounts.get(i).getAccountid().compareTo(accountNo) == 0)
				//find reservation
				//call methods for calculating price
				price =  accounts.get(i).calculateTotalReservationPrice(reservationNumber);
		}
		return price;
	}

	//Saves given account to file, by calling account method; account method calls managed reservations save to files methods
	public void saveToFile(Integer accountID) {
		//find account
		boolean found = false;
		for(int i =0; i < accounts.size(); i++) {
			if(accounts.get(i).getAccountid().compareTo(accountID) == 0) {
				//save account directory, file and reservation files
				accounts.get(i).saveToFile(PATH + accountID);
				//create directory using account no
				File file = new File(PATH + "\\" + accountID);
				if(file.isDirectory() == false)
					//create subdirectory in PATH called the accountID if it does not exist
					file.mkdir();
			}
				
			
			found = true;
		}	
		//if account object with matching parameter id is not found it should throw IllegalArgumentException
		if(found == false) {
			throw new IllegalArgumentException("Account with matching id# +" + accountID + " could not be found.");
		}
	}
	 
	//return  the list of accounts managed by this Manager
	public Vector <Account> getAccounts() {		  
		 return accounts;
	}

}