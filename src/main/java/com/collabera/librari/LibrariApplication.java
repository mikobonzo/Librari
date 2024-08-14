package com.collabera.librari;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.collabera.librari.entity.Book;
import com.collabera.librari.entity.Borrower;
import com.collabera.librari.services.BookService;
import com.collabera.librari.services.BorrowerService;
import com.collabera.librari.utils.LibUtils;

@SpringBootApplication
public class LibrariApplication implements CommandLineRunner {
	
    @Autowired
    private BookService bookService;

    
    @Autowired
    private BorrowerService borrowerService;
    
    
    @Autowired
    private LibUtils libUtils;
    
    private static Logger logger = LoggerFactory.getLogger(
			LibrariApplication.class);
	

    @Override
	public void run(String... args) throws Exception {
		logger.info("Initizliing H2 ... ");
		
		Book book = null;
		Borrower borrower = null; 
		
		logger.info("Loding default Books and Borrowers ... ");

			 book = new Book("97B-2-39-898420-0","Little Fires Everywhere",0,
					 Calendar.getInstance().getTime(),"Celeste Ng",
					 String.valueOf(Calendar.getInstance().getTimeInMillis()));
			 bookService.saveBook(book); book = null;
			 
			 book = new Book("97B-2-49-8943980-0","One by One",0,
					 Calendar.getInstance().getTime(),"Ruth Ware",
					 String.valueOf(Calendar.getInstance().getTimeInMillis()));

			 bookService.saveBook(book); book = null;

			 book = new Book(libUtils.generateISBN(),"The Guest List",0,
					 Calendar.getInstance().getTime(),"Lucy Foley",
					 String.valueOf(Calendar.getInstance().getTimeInMillis()));

			 bookService.saveBook(book); book = null;

			 book = new Book(libUtils.generateISBN(),"The Ballad of Songbirds and Snakes",0,
					 Calendar.getInstance().getTime(),"Suzanne Collins",
					 String.valueOf(Calendar.getInstance().getTimeInMillis()));

			 bookService.saveBook(book); book = null;
			 
			 book = null;
			 
			 borrower = new Borrower("mmayor", "Michael", "Mayor",
					 1, Calendar.getInstance().getTime(),"mmayor@abc123.com");
			 
			 borrowerService.saveBorrower(borrower); borrower = null;
			 
			 borrower = new Borrower("svai", "Steve", "Vai",
					 1, Calendar.getInstance().getTime(),"svai@hotmail.com");
			 
			 borrowerService.saveBorrower(borrower); borrower = null;	
			 
			logger.info("Loding complete... ");
			 


	}
	
	public static void main(String[] args) {
		SpringApplication.run(LibrariApplication.class, args);
	}

}
