/**
 * 
 */
package com.collabera.librari.controller;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.librari.LibrariConstants;
import com.collabera.librari.entity.Book;
import com.collabera.librari.entity.Borrower;
import com.collabera.librari.entity.Message;
import com.collabera.librari.services.BookService;
import com.collabera.librari.services.BorrowerService;
import com.collabera.librari.vo.Books;

/**
 * @author Michael_Bachini
 *
 */

@CrossOrigin
@RestController
@RequestMapping(path = "/couple")
public class AssignProcessor {
	
	private static Logger logger = LoggerFactory.getLogger(AssignProcessor.class);

	@Autowired
	private BookService bookService;
	
	@Autowired
	private BorrowerService borrowerService;


	@GetMapping(path = "/listing", produces = "application/json")
	public Books listAssignedBooks(){
		
		Books bookzzz = new Books();
		
		bookzzz.setBookList(bookService.getAllBook());
		
		logger.info("@listingBorrower");
		
		return bookzzz;
		
	}	
	
	@PostMapping(path = "/assign", produces = "application/json")
	public Message assignBookToBorrower(@RequestParam(required = true) String bookid,
			@RequestParam(required = true) String username){
		
		Message message = null;
		Book book = bookService.getBookByBookId(bookid);
		Borrower borrower = borrowerService.getBorrowerByUname(username);
		
		if(book!=null && borrower!=null) {
			
			if(book.getActive()==LibrariConstants.ACTIVE && 
					book.getBorrower().equalsIgnoreCase(username)) {
				
				message = new Message(LibrariConstants.ERROR, book.getTitle(),
						"Book: "+book.getTitle()+"--"+"Borrower: "+borrower.getUsername()+" Assignment Existing!", 
						Calendar.getInstance().getTime());
			}else {
				book.setActive(LibrariConstants.ACTIVE);
				book.setBorrower(username);
				bookService.saveBook(book);
				
				message = new Message(LibrariConstants.SUCCESS, book.getTitle(),
						"Book: "+book.getTitle()+"--"+"Borrower: "+borrower.getUsername()+" Assignment Complete!", 
						Calendar.getInstance().getTime());				
			}
			logger.info("@AssignBook : " + "Book: "+book.getTitle()+"--"+"Borrower: "+borrower.getUsername()+
					" Already existent..");

		}else {

			message = new Message(LibrariConstants.ERROR, "Non-Existent Found !",
					"Either the specified Book / Borrower is non-existent", 
					Calendar.getInstance().getTime());
		}
		
		book = null;
		return message;
	}	
	
	@PostMapping(path = "/release", produces = "application/json")
	public Message releaseBookFromBorrower(@RequestParam(required = true) String bookid,
			@RequestParam(required = true) String username){
		
		Message message = null;
		Book book = bookService.getBookByBookId(bookid);
		Borrower borrower = borrowerService.getBorrowerByUname(username);
		
		if(book!=null && borrower!=null) {
			
			if(book.getActive()==LibrariConstants.ACTIVE && 
					book.getBorrower().equalsIgnoreCase(username)) {
				
				book.setActive(LibrariConstants.NONACTIVE);
				book.setBorrower(null);
				bookService.saveBook(book);
				
				message = new Message(LibrariConstants.SUCCESS, book.getTitle(),
						"Book: "+book.getTitle()+"--"+"Borrower: "+borrower.getUsername()
						+" Assignment Released. Book Available once more!", 
						Calendar.getInstance().getTime());
			}else {
				
				message = new Message(LibrariConstants.ERROR, book.getTitle(),
						"Book: "+book.getTitle()+"--"+"Borrower: "+borrower.getUsername()+
						" Book/Borrower assignment non existent!", 
						Calendar.getInstance().getTime());				
			}

		}else {

			message = new Message(LibrariConstants.ERROR, "Release Halted !",
					"Either the specified Book / Borrower is non-existent", 
					Calendar.getInstance().getTime());
		}
		
		book = null;
		return message;
	}	
}
