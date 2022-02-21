package com.Library.Service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.Library.Exception.ResourceNotFoundException;
import com.Library.Model.Book;
import com.Library.Repository.BookRepository;

@SpringBootTest
class BookServiceTest {
	
	@Mock
	BookRepository Repository;
	@InjectMocks
	BookService Service;

	@Test
	void test() {
		List<Book> allBooks=new ArrayList<>();
		when(Repository.findAll()).thenReturn(allBooks);
		Service.listAll();
		verify(Repository,times(1)).findAll();
		
	}
	
	@Test
	public void createandSave()
	{
		Book book=new Book("authorname","bookname");
		Service.createBook(book);
		verify(Repository,times(1)).save(book);
	}
    @Test
	public void delete()
	{
		
		Service.delete(anyInt());
		verify(Repository,times(1)).deleteById(anyInt());
		
	}
    
   @Test
    public void get() throws ResourceNotFoundException
    {
	   Optional<Book> book=Optional.of(new Book("authorname","bookname"));
	   when(Repository.findById(anyInt())).thenReturn(book);
    	Service.get(anyInt());
    	verify(Repository,times(1)).findById(anyInt());
    }
    
    
}
