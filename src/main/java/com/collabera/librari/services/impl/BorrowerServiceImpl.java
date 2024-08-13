/**
 * 
 */
package com.collabera.librari.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collabera.librari.entity.Borrower;
import com.collabera.librari.repository.BorrowerRepository;
import com.collabera.librari.services.BorrowerService;

/**
 * @author miko
 *
 */

@Service("BorrowerServiceImpl")
@Transactional
public class BorrowerServiceImpl implements BorrowerService {
	
	@Autowired
	private BorrowerRepository borrowerRepository;	

	@Override
	public Borrower saveBorrower(Borrower borrower) {
		
		Borrower borrowerz = borrowerRepository.save(borrower);

		return borrowerz;
	}

	@Override
	public Borrower getBorrowerByUname(String username) {

		Sort sort = Sort.by("username").ascending();
		Borrower borrowerz = borrowerRepository.findByBorrowerByUsername(
				username, sort);
		
		return borrowerz;
	}

	@Override
	public List<Borrower> getAllBorrower() {

		return borrowerRepository.findAll();
	}

	@Override
	public Borrower getBorrower(String firstName, String lastName) {

		Sort sort = Sort.by("firstname").ascending();
		Borrower borrowerz = borrowerRepository.findByBorrower(
				firstName, lastName, sort);
		
		return borrowerz;		
	}

//	@Override
//	public Borrower getBorrowerByFirstLastName(String firstName, String lastName) {
//
//		Sort sort = Sort.by("firstname").ascending();
//		Borrower borrowerz = borrowerRepository.findByBorrowerByFirstLastName(
//				firstName, lastName, sort);
//		
//		return borrowerz;
//	
//	}
}
