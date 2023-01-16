package com.example.demo.service;

import java.util.List;
import com.example.demo.model.AddressBookModel;
import com.example.demo.repositery.AddressBookRepositery;
import com.example.demo.dto.AddressBookDTO;

public interface IAddressBookService {

	String addAddressBook(AddressBookDTO addressbookDTO );
	List<AddressBookRepositery> showAddressBookdata();
	AddressBookModel getAddressBookById(int id);
	AddressBookModel editAddressBook(int id, AddressBookDTO addressbookDTO);
	String deleteAddressBook(int id);
	List<AddressBookModel> searchAddressBookByState(String state);
	List<AddressBookModel> searchAddressBookByCity(String city);
	
}
