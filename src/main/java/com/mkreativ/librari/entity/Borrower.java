/**
 * 
 */
package com.mkreativ.librari.entity;

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
@Table(name="borrower")
@EntityListeners(AuditingEntityListener.class)
public class Borrower extends Audit<String> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="username")
    private String username;
    
    @Column(name="firstname")
    private String firstname;
    
    @Column(name="lastname")
    private String lastname;    
    
    @Column(name="active",columnDefinition = "integer default 1")
    private int active;
    
    @Column(name="createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    
    @Column(name="email")
    private String email; 


	public Borrower() {}


	/**
	 * @param username
	 * @param firstName
	 * @param lastName
	 * @param active
	 * @param createdate
	 */
	public Borrower(String username, String firstname, String lastname, int active, Date createdate,String email) {
		this.username = username;
		this.firstname = firstname;
		this.lastname = firstname;
		this.active = active;
		this.createdate = createdate;
		this.email = email;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * @return the firstName
	 */
	public String getFirstname() {
		return firstname;
	}


	/**
	 * @return the lastName
	 */
	public String getLastname() {
		return lastname;
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
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastname) {
		this.lastname = lastname;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}    


}
