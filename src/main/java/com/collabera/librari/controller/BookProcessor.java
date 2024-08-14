/**
 * 
 */
package com.collabera.librari.controller;

import java.util.Calendar;
import java.util.List;

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
import com.collabera.librari.entity.Book;
import com.collabera.librari.entity.Message;
import com.collabera.librari.services.BookService;
import com.collabera.librari.utils.LibUtils;
import com.collabera.librari.vo.Books;

/**
 * @author Michael_Bachini
 *
 */

@CrossOrigin
@RestController
@RequestMapping(path = "/book")
public class BookProcessor {
	
	private static Logger logger = LoggerFactory.getLogger(BookProcessor.class);
	
    @Autowired
    private LibUtils libUtils;
	
	@Autowired
	private BookService bookService;


	@GetMapping(path = "/listing", produces = "application/json")
	public Books listBooks(){
		
		Books bookzzz = new Books();
		
		bookzzz.setBookList(bookService.getAllBook());
		
		logger.info("@listingBorrower");
		
		return bookzzz;
		
	}	
	
	@PostMapping(path = "/locate", produces = "application/json")
	public ResponseEntity<Book> locateBook(@RequestParam(required = true) String bookid){
		
		ResponseEntity<Book> re = ResponseEntity.status(
				HttpStatus.NOT_FOUND).body(new Book());

		
		logger.info("BID" + bookid);
		Book book = bookService.getBookByBookId(bookid);

		if (book != null) {
		    re =  ResponseEntity.ok(book);
	    }

		return re;
	}	
	
	@PostMapping(path = "/register", produces = "application/json")
	public Message registerBook(@RequestParam(required = true) String bookTitle,
			@RequestParam(required = true) String bookAuthor){
		
		Message message = null;
		List<Book> books = bookService.getBookByTitleAuthor(
				bookTitle, bookAuthor);
		
		if(books!=null && books.size()>0) {
					
			Book book2 = new Book(books.get(0).getIsbn(),bookTitle,0,
				Calendar.getInstance().getTime(),bookAuthor,
				String.valueOf(Calendar.getInstance().getTimeInMillis()));	
			
			bookService.saveBook(book2);
			
			message = new Message(LibrariConstants.SUCCESS, book2.getBookid(),
					"Book: "+book2.getTitle()+"--"+"Author: "+book2.getAuthor()+
					" Already existent. Adding with same ISBN", 
					Calendar.getInstance().getTime());
			
			logger.info("@registerBook : " + "Book: "+book2.getTitle()+
					"--"+"Author: "+book2.getAuthor()+
					" Already existent..");

		}else {
			Book book = new Book(libUtils.generateISBN(),bookTitle,0,
			Calendar.getInstance().getTime(),bookAuthor,
			String.valueOf(Calendar.getInstance().getTimeInMillis()));
			bookService.saveBook(book); 
			
			message = new Message(LibrariConstants.SUCCESS, book.getIsbn(),
					"Book: "+book.getBookid()+"--"+"Author: "+book.getAuthor()+" Saved ..", 
					Calendar.getInstance().getTime());
			book = null;

		}
		
		return message;
	}
}
