package com.bridgelabz.addressbook.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.exceptions.AddressBookException;
import com.bridgelabz.addressbook.model.PersonDetails;
import com.bridgelabz.addressbook.respository.AddressBookRespository;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class PersonService implements IPersonService {

@Autowired
private AddressBookRespository addressRespository;

@Override
public List<PersonDetails> getPersonDetails() {
	// TODO Auto-generated method stub
	return addressRespository.findAll();
}

@Override
public PersonDetails getPersonDetailsById(int personId) {
	// TODO Auto-generated method stub
	 return addressRespository.findById(personId)
			.orElseThrow(()-> new AddressBookException("AddressBook with personId " + personId + " does not exists...!"));
}

@Override
public PersonDetails createPersonDetails(AddressBookDTO addBookDTO) {
	// TODO Auto-generated method stub
	PersonDetails personData = new PersonDetails(addBookDTO);
	BeanUtils.copyProperties(addBookDTO, personData);
	log.debug("Person Data:"+personData.toString());
	return addressRespository.save(personData);
}

@Override
public PersonDetails updatePersonDetails(int personId, AddressBookDTO addBookDTO) {
	// TODO Auto-generated method stub
	PersonDetails personData = this.getPersonDetailsById(personId);
	personData.updatePersonDetails(addBookDTO);
	return addressRespository.save(personData);
}

@Override
public void deletePersonDetailsById(int personId) {
	// TODO Auto-generated method stub
	PersonDetails personData = this.getPersonDetailsById(personId);
	addressRespository.delete(personData);
}
	
}
