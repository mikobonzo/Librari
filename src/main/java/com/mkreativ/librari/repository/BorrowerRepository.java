/**
 * 
 */
package com.mkreativ.librari.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mkreativ.librari.entity.Borrower;

/**
 * @author miko
 *
 */	
	
@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
	
    @Query("FROM Borrower WHERE username = ?1")
    Borrower findByBorrowerByUsername(String userName, Sort sort);

    @Query("FROM Borrower WHERE firstname = ?1 AND lastname = ?2")
    Borrower findByBorrower(String firstName, String lastName, Sort sort);    
    
    List<Borrower> findAllByActive(int active);
   
   
}
