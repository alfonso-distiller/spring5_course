package guru.springframework.spring5webapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"authors"})
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String isbn;
	
	@OneToOne
	@JoinColumn(name = "publisher_id", referencedColumnName = "id")
	private Publisher publisher;

	@ManyToMany
	@JoinTable(name = "author_book", 
		joinColumns = @JoinColumn(name = "book_id"), 
		inverseJoinColumns = @JoinColumn(name = "author_id")
	)
	private Set<Author> authors = new HashSet<>();

	public Book(String title, String isbn) {
		super();
		this.title = title;
		this.isbn = isbn;
	}
	
	public void addAuthor(Author author) {
		this.authors.add(author);
	}
}
