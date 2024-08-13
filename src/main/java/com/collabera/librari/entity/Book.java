/**
 * 
 */
package com.collabera.librari.entity;

import java.util.Date;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * @author miko
 *
 */
@Entity
@Table(name="book")
@EntityListeners(AuditingEntityListener.class)
public class Book extends Audit<String> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    @Column(name="bookid")
    private String bookid;
    
    @Column(name="isbn")
    private String isbn;
    
    @Column(name="title")
    private String title;
    
    @Column(name="active",columnDefinition = "integer default 0")
    private int active;
    
    @Column(name="createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    
    @Column(name="author")
    private String author;
    
    @Column(name="borrower")
    private String borrower;
    
    public Book() {}
    
	/**
	 * @param isbn
	 * @param title
	 * @param occupied
	 * @param createdate
	 * @param author
	 */
	public Book(String isbn, String title, int occupied, 
			Date createdate, String author,String bookid) {
		this.isbn = isbn;
		this.title = title;
		this.createdate = createdate;
		this.author = author;
		this.bookid = bookid;
	}

	/**
	 * @return the bookid
	 */
	public String getBookid() {
		return bookid;
	}



	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}



	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}



	/**
	 * @return the active
	 */
	public int getActive() {
		return active;
	}



	/**
	 * @return the createdate
	 */
	public Date getCreatedate() {
		return createdate;
	}



	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}



	/**
	 * @return the borrower
	 */
	public String getBorrower() {
		return borrower;
	}



	/**
	 * @param bookid the bookid to set
	 */
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}



	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}



	/**
	 * @param active the active to set
	 */
	public void setActive(int active) {
		this.active = active;
	}



	/**
	 * @param createdate the createdate to set
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}



	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}



	/**
	 * @param borrower the borrower to set
	 */
	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

}
