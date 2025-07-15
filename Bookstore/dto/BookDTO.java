package Bookstore.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
	
	private long id;
	
	@NotBlank(message = "Title is required")
	private String title;
	
	private String description;
	
	@Positive(message = "Price must be greater than 0 ")
	private Double price;
	
	@PastOrPresent(message = "Published date must be past or today")
	private LocalDate publishedDate;
	
	@NotNull(message = "Author ID is required")
	private long authorId; 
}
