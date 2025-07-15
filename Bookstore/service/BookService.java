package Bookstore.service;

import java.util.List;

import Bookstore.dto.BookDTO;

public interface BookService {
    
	BookDTO createBook(BookDTO dto);
	List<BookDTO> getAllBooks();
	BookDTO updateBook(Long id, BookDTO dto);
	void deleteBook(Long id);
	BookDTO getBookById(Long id);
}
