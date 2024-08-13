/**
 * 
 */
package com.collabera.librari.entity;

import java.util.Date;

/**
 * @author miko
 *
 */
public class Message {
	
	private String reference;
	
	private String referenceContent;
	
	private String referenceDetail;
	
	private Date date ;
	
	/**
	 * @param reference
	 * @param referenceContent
	 * @param referenceDetail
	 * @param date
	 */
	public Message(String reference, String referenceContent,
			String referenceDetail, Date date) {
		
		this.reference = reference;
		this.referenceContent = referenceContent;
		this.referenceDetail = referenceDetail;
		this.date = date;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @return the referenceContent
	 */
	public String getReferenceContent() {
		return referenceContent;
	}

	/**
	 * @return the referenceDetail
	 */
	public String getReferenceDetail() {
		return referenceDetail;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @param referenceContent the referenceContent to set
	 */
	public void setReferenceContent(String referenceContent) {
		this.referenceContent = referenceContent;
	}

	/**
	 * @param referenceDetail the referenceDetail to set
	 */
	public void setReferenceDetail(String referenceDetail) {
		this.referenceDetail = referenceDetail;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
}
