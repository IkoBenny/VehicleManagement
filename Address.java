public class Address {

	private String street;

	private String city;

	private String state;

	private String zip;

	public Address(String city, String state, String zip, String street) {
		try {
		//validate parameters
		if(city.equals(null)  || city.length() == 0 || state.equals(null) || state.length() == 0 || zip.equals(null) || zip.length() == 0  || street.equals(null) || street.length() == 0)
			throw new IllegalArgumentException("Parameter values cannot be null or empty strings");
		//initialize values
			this.city = city;
			this.street = street;
			this.zip = zip;
			this.state = state;
		}
		//catch NPE, throw IllegalArgument instead
		catch(NullPointerException npe) {
			throw new IllegalArgumentException("Parameter values cannot be null or empty strings");
		}
	}
	
	//loads Address from string
	public Address(String line) {
		//parse String
		//get street value
		int streetOpenTagPos = line.indexOf("<street>");
		int streetCloseTagPos = line.indexOf("</street>");
		street = line.substring(streetOpenTagPos + 8, streetCloseTagPos); 
		//get city value
		int cityOpenTagPos = line.indexOf("<city>");
		int cityCloseTagPos = line.indexOf("</city>");
		city = line.substring(cityOpenTagPos + 6, cityCloseTagPos);
		//get state value
		int stateOpenTagPos = line.indexOf("<state>");
		int stateCloseTagPos = line.indexOf("</state>");
		state = line.substring(stateOpenTagPos + 7, stateCloseTagPos);
		//get zip value
		int zipOpenTagPos = line.indexOf("<zip>");
		int zipCloseTagPos = line.indexOf("</zip>");
		zip = line.substring(zipOpenTagPos + 5, zipCloseTagPos);
		//create the object
	}

	//formats this Address's data; returns it as String
	public String toString() {
		//format data in XML style
		String line = "<address>" +  "<street>" + street + "</street>" + "<city>" + city + "</city>" + "<state>" + state + "</state>"
		+ "<zip>" + zip + "</zip>" + "</address>" ; 
		//return as String object
		return line;
	}

	//return this address's street value
	public String getStreet() {
		return street;
	}

	//return this address's city value
	public String getCity() {
		return city;
	}

	//return this address's state value
	public String getState() {
		return state;
	}

	//return this address's zip value
	public String getZip() {
		return zip;
	}

	//sets the street for an Address
	public void setStreet(String street) {
		//validate input,
		if(street.equals(null))
			throw new IllegalArgumentException("street may not be a null value.");
		//then set value
		else
			this.street = street;
	}

	//sets the city for an Address
	public void setCity(String city) {
		//validate input,
		if(city.equals(null))
			throw new IllegalArgumentException("city may not be a null value");
		//then set value
		this.city = city;
	}

	//sets the state for an Address
	public void setState(String state) {
		//validate input, 
		if(state.equals(null))
			throw new IllegalArgumentException("state may not be null value");
		//then set value
		this.state = state;
	}

	//sets the zip for an Address
	public void setZip(String zip) {
		//validate input, 
		if(zip.equals(null))
			throw new IllegalArgumentException("zip may not be null value.");
		//then set value
		else
			this.zip = zip;
	}


}