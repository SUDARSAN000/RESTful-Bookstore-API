package Bookstore.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Bookstore.dto.AuthorDTO;
import Bookstore.service.AuthorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/author")
@RequiredArgsConstructor
public class AuthorController {
	
	private final AuthorService authorService;
	
	@PostMapping
	public ResponseEntity<AuthorDTO> create(@RequestBody AuthorDTO dto){
		return ResponseEntity.ok(authorService.createAuthor(dto));
	}
	
	@GetMapping
	public ResponseEntity<List<AuthorDTO>> getAll(){
		return ResponseEntity.ok(authorService.getAllAuthors());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AuthorDTO> getById(@PathVariable Long id){
		return ResponseEntity.ok(authorService.getAuthorById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		authorService.deleteAuthor(id);
		return ResponseEntity.ok("Author deleted successfully...");
	}
}
