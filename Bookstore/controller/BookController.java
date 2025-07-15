package Bookstore.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Bookstore.dto.BookDTO;
import Bookstore.service.BookService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
	
	private final BookService bookService;
	
	@PostMapping
	public ResponseEntity<BookDTO> create(@RequestBody BookDTO dto){
		return ResponseEntity.ok(bookService.createBook(dto));
	}
	
	@GetMapping
	public ResponseEntity<List<BookDTO>> getAll(){
		return ResponseEntity.ok(bookService.getAllBooks());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookDTO> getById(@PathVariable Long id){
		return ResponseEntity.ok(bookService.getBookById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BookDTO> update(@PathVariable Long id,@RequestBody BookDTO dto){
		return ResponseEntity.ok(bookService.updateBook(id, dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		return ResponseEntity.ok("Book deleted successfully...");
	}
}
