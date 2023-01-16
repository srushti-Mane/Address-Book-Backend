package com.example.demo.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AddressBookModel;

@Repository
public interface AddressBookRepositery extends JpaRepository<AddressBookModel,Integer> {

	// AddressBookModel findByEmail();
	List<AddressBookModel> findByState(String state);
	List<AddressBookModel> findByCity(String city);
	 //save(AddressBookModel addressBookModel);
	Object findByEmail(String email);
	
	
}
