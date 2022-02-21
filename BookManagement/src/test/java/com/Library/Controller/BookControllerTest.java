package com.Library.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.Library.Model.Book;
import com.Library.Service.BookService;

@AutoConfigureMockMvc
public class BookControllerTest {

	
@Mock
BookService service;

@InjectMocks
BookController controller;

private MockMvc mockMvc;

@Before
public void setUp() throws Exception {
this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
}

	@Test
	public void getAllBooks() throws Exception {
//		List<Book> books =new ArrayList<>();
//	    books.add(new Book("authorname","bookname"));
//	    when(service.listAll()).thenReturn(books);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/books");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(200, response.getStatus());
		
		
	}

}
