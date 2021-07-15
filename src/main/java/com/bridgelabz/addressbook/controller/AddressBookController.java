package com.bridgelabz.addressbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.PersonDetails;
import com.bridgelabz.addressbook.service.IPersonService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	
	@Autowired
	private IPersonService personService;
	
	@RequestMapping(value = {"","/","/get"})
	public ResponseEntity<ResponseDTO> getPersonDetails()
	{
		List<PersonDetails> personDetailsList = personService.getPersonDetails();
		ResponseDTO resDTO = new ResponseDTO("Getting All Details", personDetailsList);
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
		
	}
	@GetMapping("/get/{personId}")
	public ResponseEntity<ResponseDTO> getPersonDetails(@PathVariable("personId") int personId)
	{
		PersonDetails personData = personService.getPersonDetailsById(personId);
		ResponseDTO resDTO = new ResponseDTO("Getting Details with Id :", personData);
		return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
	}
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createPersonDetails(@RequestBody AddressBookDTO addressBookDTO)
	{
		PersonDetails personData = personService.createPersonDetails(addressBookDTO);
		ResponseDTO resDTO = new ResponseDTO("Create Personal Details Addressbook for :", personData);
		return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
	}
	@PutMapping("/update/{personId}")
	public ResponseEntity<ResponseDTO> updatePersonDetails(@PathVariable("personId") int personId,@RequestBody AddressBookDTO addressBookDTO)
	{
		PersonDetails personData = personService.updatePersonDetails(personId, addressBookDTO);
		ResponseDTO resDTO = new ResponseDTO("Updated Personal Details Addressbook for :", personData);
		return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{personId}")
	public ResponseEntity<ResponseDTO> deletePersonDetailsById(@PathVariable("personId") int personId)
	{
		personService.deletePersonDetailsById(personId);
		ResponseDTO resDTO = new ResponseDTO("Delete Successfully", "Deleted for id :" +personId);
		return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
	}

}
