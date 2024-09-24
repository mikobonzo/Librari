/**
 * 
 */
package com.mkreativ.librari.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mkreativ.librari.entity.Book;

/**
 * @author miko
 *
 */	
	
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
    @Query("FROM Book WHERE isbn = ?1")
    Book findByBookISBN(String isbn, Sort sort);

    @Query("FROM Book WHERE title = ?1")
    Book findByBookTitle(String title, Sort sort);
    
    @Query("FROM Book WHERE title = ?1 AND author = ?2")
    List<Book> findByBookTitleAuthor(String title, String author, Sort sort);    

    @Query("FROM Book WHERE bookid = ?1")
    Book findByBookId(String bookid);     
    
    List<Book> findAllByActive(int active);
    
   
}
