package guru.springframework.spring5webapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"book"})
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String address;
	
	@OneToOne(mappedBy = "publisher")
	private Book book;


	public Publisher(String name) {
		super();
		this.name = name;
	}
	
	
}
