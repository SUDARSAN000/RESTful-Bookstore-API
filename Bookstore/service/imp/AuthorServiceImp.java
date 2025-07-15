package Bookstore.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Bookstore.dto.AuthorDTO;
import Bookstore.entity.Author;
import Bookstore.exception.ResourceNotFoundException;
import Bookstore.repository.AuthorRepo;
import Bookstore.service.AuthorService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorServiceImp implements AuthorService{
	
	private final AuthorRepo authorRepo;
	
	@Override
	public AuthorDTO createAuthor(AuthorDTO dto) {
		Author author = Author.builder()
                .name(dto.getName())
                .bio(dto.getBio())
                .build();
		
		Author saved = authorRepo.save(author);
		return mapToDTO(saved);
	}

	private AuthorDTO mapToDTO(Author author) {
		return AuthorDTO.builder()
				.id(author.getId())
				.name(author.getName())
				.bio(author.getBio())
				.build();
	}

	@Override
	public List<AuthorDTO> getAllAuthors() {
		return authorRepo.findAll()
				.stream()
				.map(this::mapToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public AuthorDTO getAuthorById(Long id) {
		Author author = authorRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with ID: " + id));
		return mapToDTO(author);
	}

	@Override
	public void deleteAuthor(Long id) {
		Author author = authorRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with ID: " + id));
		authorRepo.delete(author);
	}
}
