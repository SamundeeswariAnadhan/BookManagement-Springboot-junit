package com.Library.Controller;


import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Library.Exception.ResourceNotFoundException;
import com.Library.Model.Book;

import com.Library.Service.BookService;


@RestController
@RequestMapping("/Bookmanage/")
public class BookController {
	

@Autowired
  private BookService bookservice;

@GetMapping("books")
public List<Book> getAllBooks() 
{
	List<Book> book = bookservice.listAll();
		
return book;

}

@GetMapping("/books/{id}")
private Book getBook(@PathVariable("id") int id) throws Exception   
{ 
	Book bookid=bookservice.get(id);
	
	return bookid;
}

@PostMapping("addbook")
public ResponseEntity<Book> createBook(@Valid @RequestBody Book book)
{
	
Book savedBook=bookservice.createBook(book);


return new ResponseEntity<Book>(savedBook,HttpStatus.CREATED);

}


@DeleteMapping("/books/{id}")
public void delete(@PathVariable Integer id) {
	bookservice.delete(id);
}



@PutMapping("/books/{id}")
public ResponseEntity<Book> updateBook(@PathVariable(value="id") Integer Id, @Validated @RequestBody Book bookDetails) throws ResourceNotFoundException
{
return ResponseEntity.ok(bookservice.update(Id,bookDetails));
}














/*

@GetMapping("books")
public List<Book> getAllBooks() throws Exception
{
	List<Book> book = bookrepo.findAll();
	if (book.isEmpty()) {
		throw new ResourceNotFound(
		"There are no data found ");
		}	
return book;
}

@PostMapping("addBook")
public ResponseEntity<Book> createBook(@Valid @RequestBody Book book)
{
	
Book savedBook=bookservice.createBook(book);


return new ResponseEntity<Book>(savedBook,HttpStatus.CREATED);

}

@DeleteMapping("/delete/{id}")
private void deleteBook(@PathVariable("id") int id)   
{  
	
bookservice.delete(id);  
}  

@GetMapping("/Get/{id}")  
private Book getBook(@PathVariable("id") int id) throws Exception   
{ 
	Book bookid=bookservice.getBookById(id);
	if (bookid==null) {
		throw new Exception(
		"There are no data found for Id:" + id);
		}
	return bookid;
//return bookservice.getBookById(id);  
}  
*/

}