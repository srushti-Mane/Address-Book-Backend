package com.example.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AddressBookDTO;
import com.example.demo.exception.AddressBookException;
import com.example.demo.model.AddressBookModel;
import com.example.demo.repositery.AddressBookRepositery;

@Service
public class AddressBookService implements IAddressBookService {

	@Autowired
	AddressBookRepositery addressbookRepositery;

	@Autowired
	ModelMapper modelMapper;

	// ___________ adding new contact ____________//
	@Override
	public String addAddressBook(AddressBookDTO addressbookDTO) {
		if (addressbookRepositery.findByEmail(addressbookDTO.getEmail()) == null) {
			AddressBookModel addressBookModel = modelMapper.map(addressbookDTO, AddressBookModel.class);
			addressbookRepositery.save(addressBookModel);
		return "Address Book Added";
	}
	 throw new AddressBookException("This email-Id is already exist"+" \nPlease Try with another emai-Id");
}


/*	// ______________ get all by contact ____________//
	@Override
	public List<AddressBookModel> showAddressBookdata() {
		return addressbookRepositery.findAll();
	}
*/
	// __________ get contact by id ____________//
	@Override
	public AddressBookModel getAddressBookById(int id) {
		if (addressbookRepositery.findById(id).isPresent()) {
		return addressbookRepositery.findById(id).get();
	}
	throw new AddressBookException("AddressBook Not Found"+"\nInvalid Id");
}


	// ___________ update contact ____________//
	@Override
	public AddressBookModel editAddressBook(int id, AddressBookDTO addressbookDTO) {
		if (addressbookRepositery.findById(id).isPresent()) {
			AddressBookModel model = (AddressBookModel) addressbookRepositery.findById(id).get();
			AddressBookModel edit = modelMapper.map(addressbookDTO, AddressBookModel.class);
			edit.setId(id);
			if (addressbookRepositery.findByEmail(addressbookDTO.getEmail()) == null) {
				if (edit.getFirstname() == null) {
					edit.setFirstname(model.getFirstname());
				}
				if (edit.getLastname() == null) {
					edit.setLastname(model.getLastname());
				}
				if (edit.getAddress() == null) {
					edit.setAddress(model.getAddress());
				}
				if (edit.getEmail() == null) {
					edit.setEmail(model.getEmail());
				}
				if (edit.getCity() == null) {
					edit.setCity(model.getCity());
				}
				if (edit.getState() == null) {
					edit.setState(model.getState());
				}
				if (edit.getZip() == 0) {
					edit.setZip(model.getZip());
				}
				if (edit.getPhoneno() == 0) {
					edit.setPhoneno(model.getPhoneno());
		}
		return addressbookRepositery.save(edit);
			}
		 throw new AddressBookException("This email_id is already exist"+"\nplease try with another email id");
	        }
	        throw new AddressBookException("Address Not Found" + "\nInvalid Id");
	    }
	

	// _______________ delete contact ______________//
	@Override
	public String deleteAddressBook(int id) {
		if (addressbookRepositery.findById(id).isPresent()) {
			addressbookRepositery.deleteById(id);
		}
		return "AddressBook Deleted Successfully";

	}

	// __________ find by state ________//
	@Override
	public List<AddressBookModel> searchAddressBookByState(String state) {
		List<AddressBookModel> addressBookModelList = addressbookRepositery.findByState(state);
		return addressBookModelList;
	}

	@Override
	public List<AddressBookModel> searchAddressBookByCity(String city) {
		List<AddressBookModel> addressBookModelList = addressbookRepositery.findByCity(city);
		return addressBookModelList;
	}


	@Override
	public List<AddressBookRepositery> showAddressBookdata() {
		
		return null;
	}

}
