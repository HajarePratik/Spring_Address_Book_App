package com.bridgelabz.addressbook.dto;

import javax.validation.constraints.Pattern;

import lombok.ToString;

public @ToString class AddressBookDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Person Name cannot be Correct")
	public String name;
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{5,}$",message = "Address cannot be Correct")
	public String address;
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "City Name cannot be Correct")
	public String city;
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "State Name cannot be Correct")
	public String state;
	
	@Pattern(regexp = "^[a-zA-Z0-9]+([+_.-][a-zA-Z0-9]+)*[@][a-zA-Z0-9]+[.][a-zA-Z]{2,4}([.][a-zA-Z]{2,4})?",message = "Email ID cannot be Correct")
	public String email;
	
	@Pattern(regexp = "(0|91)?\\s([7-9][0-9]{9})",message = "Contact Number cannot be Correct")
	public String contactno;
	
	@Pattern(regexp = "^[1-9]{6}$",message = "Zipcode cannot be Correct")
	public long zipcode;

}
