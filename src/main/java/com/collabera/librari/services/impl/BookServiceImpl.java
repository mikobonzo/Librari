/**
 * 
 */
package com.collabera.librari.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collabera.librari.entity.Book;
import com.collabera.librari.repository.BookRepository;
import com.collabera.librari.services.BookService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * @author miko
 *
 */

@Service("BookServiceImpl")
@Transactional
public class BookServiceImpl implements BookService {
	

	@Autowired
	private BookRepository bookRepository;	

	@Override
	public Book saveBook(Book book) {
		
		Book bookResp = bookRepository.save(book);

		return bookResp;
	}

	@Override
	public Book getBook(String isbn) {
		
		Sort sort = Sort.by("isbn").ascending();
		Book bookResp = bookRepository.findByBookISBN(isbn, sort);

		
		return bookResp;
	}

	@Override
	public Book getBookByTitle(String title) {

		Sort sort = Sort.by("title").ascending();
		Book bookResp = bookRepository.findByBookTitle(title, sort);
		
		return bookResp;
	}

	@Override
	public List<Book> getAllBook(int active) {
		// TODO Auto-generated method stub
		return bookRepository.findAllByActive(active);
	}

	@Override
	public List<Book> getAllBook() {

		return bookRepository.findAll();
	}

	@Override
	public List<Book> getBookByTitleAuthor(String title,String author) {

		Sort sort = Sort.by("title").ascending();
		List<Book> bookResp = bookRepository.findByBookTitleAuthor(title,
				author,sort);
		
		return bookResp;
	}

	@Override
	public Book getBookByBookId(String bookid) {

		Book bookResp = bookRepository.findByBookId(bookid);

		return bookResp;
	}


}
