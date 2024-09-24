/**
 * 
 */
package com.mkreativ.librari.vo;

import java.util.ArrayList;
import java.util.List;

import com.mkreativ.librari.entity.Book;

/**
 * @author miko
 *
 */
public class Books {
	
    private List<Book> bookList;

	/**
	 * @return the bookList
	 */
	public List<Book> getBookList() {
		
        if(bookList == null) {
        	bookList = new ArrayList<Book>();
        }
        
		return bookList;
	}

	/**
	 * @param bookList the bookList to set
	 */
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
    
}
