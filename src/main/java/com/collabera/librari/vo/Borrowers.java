/**
 * 
 */
package com.collabera.librari.vo;

import java.util.ArrayList;
import java.util.List;

import com.collabera.librari.entity.Borrower;

/**
 * @author miko
 *
 */
public class Borrowers {
	
    private List<Borrower> borrowerList;

	/**
	 * @return the borrowerList
	 */
	public List<Borrower> getBorrowerList() {
		
        if(borrowerList == null) {
        	borrowerList = new ArrayList<Borrower>();
        }
        
        
		return borrowerList;
	}

	/**
	 * @param borrowerList the borrowerList to set
	 */
	public void setBorrowerList(List<Borrower> borrowerList) {
		this.borrowerList = borrowerList;
	}


    
}
