package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Response;
import com.example.demo.dto.AddressBookDTO;
import com.example.demo.model.AddressBookModel;
import com.example.demo.repositery.AddressBookRepositery;
import com.example.demo.service.IAddressBookService;

@RestController
@RequestMapping("/AddressBook")
public class AddressBookController {

	@Autowired
    IAddressBookService iAddressBookService;
	
	 //--------------------------------- Add New Contact ---------------------------------

    @PostMapping("/Add_UserData")
    public ResponseEntity<Response> addUserDataInAddressBook(@RequestBody AddressBookDTO addressBookDTO) {
        iAddressBookService.addAddressBook(addressBookDTO);
        Response response = new Response( "User Data Successfully Added In AddressBook",addressBookDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //--------------------------------- Get All By Contact ---------------------------------

    @GetMapping("/Show_All_AddressBook_Data")
    public ResponseEntity<Response> showAllData() {
        List<AddressBookRepositery> addressBookModelList = iAddressBookService.showAddressBookdata();
        Response response = new Response( "AddressBook Data",addressBookModelList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //--------------------------------- Get Contact By Id ---------------------------------
    @GetMapping("/Get_AddressBook_Data_ByID")
    public ResponseEntity<Response> getDataById(@RequestParam int id) {
        AddressBookModel addressBookData = iAddressBookService.getAddressBookById(id);
        Response response = new Response( "Address Book Data",addressBookData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //--------------------------------- Update Contact ---------------------------------
    @PutMapping("/Update_AddressBook")
    public ResponseEntity<Response> updateAddressBook(@RequestParam int id, @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookModel update = iAddressBookService.editAddressBook(id, addressBookDTO);
        Response response = new Response( "Address book update successful",update);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //--------------------------------- Delete Contact ---------------------------------
    @DeleteMapping("/Delete_AddressBook")
    public ResponseEntity<Response> updateAddressBook(@RequestParam int id) {
        iAddressBookService.deleteAddressBook(id);
        Response response = new Response("Deleted AddressBook: " + id, "Deleted Successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //--------------------------------- Get Contact By City ---------------------------------
    @GetMapping("/Search_By_City")
    public ResponseEntity<Response> serchByCity(@RequestParam String city) {
        List<AddressBookModel> addressBookModelList = iAddressBookService.searchAddressBookByCity(city);
        Response response = new Response( "AddressBooks Data For City "+ city,addressBookModelList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //--------------------------------- Get Contact By State ---------------------------------
    @GetMapping("/Search_By_State")
    public ResponseEntity<Response> serchByState(@RequestParam String state) {
        List<AddressBookModel> addressBookModelList = iAddressBookService.searchAddressBookByState(state);
        Response response = new Response( "AddressBooks Data For State "+ state,addressBookModelList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
