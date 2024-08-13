/**
 * 
 */
package com.collabera.librari.controller;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.librari.LibrariConstants;
import com.collabera.librari.entity.Borrower;
import com.collabera.librari.entity.Message;
import com.collabera.librari.services.BorrowerService;
import com.collabera.librari.vo.Borrowers;

/**
 * @author Michael_Bachini
 *
 */

@CrossOrigin
@RestController
@RequestMapping(path = "/borrower")
public class BorrowerProcessor {
	
	private static Logger logger = LoggerFactory.getLogger(BorrowerProcessor.class);

	
	@Autowired
	private BorrowerService borrowerService;	

	@GetMapping(path = "/listing", produces = "application/json")
	public Borrowers listBooks(){
		
		Borrowers borrowerz = new Borrowers();
		
		borrowerz.setBorrowerList(borrowerService.getAllBorrower());
		
		logger.info("@listingBorrower");
		
		return borrowerz;
		
	}	
	
	@PostMapping(path = "/locate", produces = "application/json")
	public ResponseEntity<Borrower> locateBorrower(
			@RequestParam(required = true) String username){
		
		
		ResponseEntity<Borrower> re = ResponseEntity.status(
				HttpStatus.NOT_FOUND).body(new Borrower());

		
		logger.info("username" + username);
		Borrower borrower = borrowerService.getBorrowerByUname(
				username);

		if (borrower != null) {
		    re =  ResponseEntity.ok(borrower);
	    }
		logger.info("@locateBorrowers");

		return re;		
	}	
	
	@PostMapping(path = "/register", produces = "application/json")
	public Message registerBorrower(@RequestParam(required = true) String username,
			@RequestParam(required = true) String firstname,
			@RequestParam(required = true) String lastname){
		
		logger.info("@registerBorrower");
		Message message = null;
		Borrower borrower = borrowerService.getBorrowerByUname(username);
		
		if(borrower!=null) {
			
			message = new Message(LibrariConstants.ERROR, username,
					"Username Already existent..", Calendar.getInstance().getTime());
			
			logger.info("@registerBorrower : " +username+ " existent !" );

		}else {
			 if(username.trim().isEmpty() || firstname.trim().isEmpty()
					 || lastname.trim().isEmpty() ) {
				 
					message = new Message(LibrariConstants.ERROR, username,
							"Please complete all parameters",Calendar.getInstance().getTime());	 
				 
			 }else {
				 
					borrower = new Borrower(username,firstname,lastname,
							LibrariConstants.ACTIVE,Calendar.getInstance().getTime());
					borrowerService.saveBorrower(borrower);
					
					message = new Message(LibrariConstants.SUCCESS, username,
							"FirstName: "+firstname+"--"+"LastName: "+lastname+" Saved ..", 
							Calendar.getInstance().getTime());
			 }
		}
		
		borrower = null;
		return message;		
		
	}	
}
