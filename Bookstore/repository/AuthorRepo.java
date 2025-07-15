package Bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Bookstore.entity.Author;

public interface AuthorRepo extends JpaRepository<Author, Long>{
	
}