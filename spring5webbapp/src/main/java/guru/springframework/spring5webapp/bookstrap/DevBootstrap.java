package guru.springframework.spring5webapp.bookstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;

@Component
public class DevBootstrap implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	private void initData() {
		Author ernestCline = new Author("Ernest","Cline");
		Book readyPlayerOne = new Book("Ready Player One", "978-0307887436", "Random House");
		Book armada = new Book("Armada", "0804137250", "Crown");
		
		ernestCline.addBook(readyPlayerOne);
		ernestCline.addBook(armada);
		
		readyPlayerOne.addAuthor(ernestCline);
		armada.addAuthor(ernestCline);
		
		authorRepository.save(ernestCline);
		bookRepository.save(readyPlayerOne);
		bookRepository.save(armada);
		
	}

	@Override
	public void run(String... args) throws Exception {
		this.initData();
	}
}
