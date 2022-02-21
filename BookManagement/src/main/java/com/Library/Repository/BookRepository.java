package com.Library.Repository;

import org.springframework.stereotype.Repository;

import com.Library.Model.Book;


import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

	


}







