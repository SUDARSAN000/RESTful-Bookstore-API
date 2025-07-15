package Bookstore.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {
	private long id;
	private String name;
	private String bio;
}

