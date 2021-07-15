package com.bridgelabz.addressbook.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.addressbook.model.PersonDetails;

@Repository
public interface AddressBookRespository extends JpaRepository<PersonDetails, Integer> {
	
	

}
