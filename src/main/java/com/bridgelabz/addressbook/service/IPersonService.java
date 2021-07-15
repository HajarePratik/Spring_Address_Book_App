package com.bridgelabz.addressbook.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.PersonDetails;

@Service
public interface IPersonService {

	public List<PersonDetails> getPersonDetails();
	
	public PersonDetails getPersonDetailsById(int personId);
	
	public PersonDetails createPersonDetails(AddressBookDTO addBookDTO);
	
	public PersonDetails updatePersonDetails(int personId,AddressBookDTO addBookDTO);
	
	public void deletePersonDetailsById(int personId);
		
	
}
