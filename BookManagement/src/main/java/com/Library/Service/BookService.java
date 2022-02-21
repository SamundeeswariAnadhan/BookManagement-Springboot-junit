package com.Library.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Library.Exception.ResourceNotFoundException;
import com.Library.Model.Book;
import com.Library.Repository.BookRepository;


@Service

public class BookService {
	
	@Autowired
	private BookRepository bookrepo;

	public Book createBook(Book book) {
		System.out.println("check");

	return bookrepo.save(book);
	}

	public List<Book> listAll() {
	return bookrepo.findAll();
	}


	public void delete(Integer bookId) {
	bookrepo.deleteById(bookId);
	}

	public Book get(int id) throws ResourceNotFoundException  
	{ 
		
	return bookrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book id is not available "+id));  
	}

	public Book update(Integer id, Book bookDetails) throws ResourceNotFoundException {
		Book book=bookrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book id is not available"+id));
		book.setAuthorName(bookDetails.getAuthorName());
		book.setBookName(bookDetails.getBookName());
		return bookrepo.save(book);
		
	}
	
}
