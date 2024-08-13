/**
 * 
 */
package com.collabera.librari.services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collabera.librari.entity.Borrower;

/**
 * @author miko
 *
 */

@Component
@Service
@Transactional

public interface BorrowerService {

	
	public Borrower saveBorrower(Borrower borrower);

	public Borrower getBorrowerByUname(String userName);
	
	public Borrower getBorrower(String firstName,
			String lastName);
	
	public List<Borrower> getAllBorrower();
	

}
