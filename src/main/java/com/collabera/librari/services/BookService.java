/**
 * 
 */
package com.collabera.librari.services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collabera.librari.entity.Book;

/**
 * @author miko
 *
 */

@Component
@Service
@Transactional

public interface BookService {

	
	public Book saveBook(Book book);

	public Book getBook(String isbn);
	
	public Book getBookByTitle(String title);
	
	public List<Book> getAllBook(int active);
	
	public List<Book> getAllBook();
	
	public List<Book> getBookByTitleAuthor(String title,String author);
	
	public Book getBookByBookId(String bookid);
	
	}
