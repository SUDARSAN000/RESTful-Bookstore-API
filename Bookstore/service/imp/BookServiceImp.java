package Bookstore.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Bookstore.dto.BookDTO;
import Bookstore.entity.Author;
import Bookstore.entity.Book;
import Bookstore.exception.ResourceNotFoundException;
import Bookstore.repository.AuthorRepo;
import Bookstore.repository.BookRepo;
import Bookstore.service.BookService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImp implements BookService {
	
	private final BookRepo bookRepo;
	private final AuthorRepo authorRepo;
	
	@Override
	public BookDTO createBook(BookDTO dto) {
		Author author = authorRepo.findById(dto.getAuthorId())
				.orElseThrow(()-> new ResourceNotFoundException("Author not found with ID : "+dto.getAuthorId()));
		Book book = Book.builder()
				.title(dto.getTitle())
		        .description(dto.getDescription())
		        .price(dto.getPrice())
		        .publishedDate(dto.getPublishedDate())
		        .author(author)
		        .build();
		Book saved = bookRepo.save(book);
		return mapToDTO(saved);
	}

	private BookDTO mapToDTO(Book book) {
		return BookDTO.builder()
				.title(book.getTitle())
				.description(book.getDescription())
				.price(book.getPrice())
				.publishedDate(book.getPublishedDate())
				.authorId(book.getAuthor().getId())
				.build();
	}

	@Override
	public List<BookDTO> getAllBooks() {
		return bookRepo.findAll()
				.stream()
				.map(this::mapToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public BookDTO updateBook(Long id, BookDTO dto) {

		Book book = bookRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Book not found with ID : "+id));
		
		Author author = authorRepo.findById(dto.getAuthorId())
				.orElseThrow(()-> new ResourceNotFoundException("Author not found with ID : "+dto.getAuthorId()));
		
		book.setTitle(dto.getTitle());
		book.setDescription(dto.getDescription());
		book.setPrice(dto.getPrice());
	    book.setPublishedDate(dto.getPublishedDate());
	    book.setAuthor(author);
	    
	    Book updated =bookRepo.save(book);
	    return mapToDTO(updated);
	}

	@Override
	public void deleteBook(Long id) {
		Book book = bookRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Book not found with ID : "+id));
		bookRepo.delete(book);
	}

	@Override
	public BookDTO getBookById(Long id) {
		Book book = bookRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Book not found with ID : "+id));
		return mapToDTO(book);
	}
	
}