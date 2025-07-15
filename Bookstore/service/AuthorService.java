package Bookstore.service;

import java.util.List;

import Bookstore.dto.AuthorDTO;
import Bookstore.entity.Author;

public interface AuthorService {
	AuthorDTO createAuthor(AuthorDTO dto);
	List<AuthorDTO> getAllAuthors();
	AuthorDTO getAuthorById(Long id);
	void deleteAuthor(Long id);
}
