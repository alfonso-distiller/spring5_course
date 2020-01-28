package guru.springframework.spring5webapp.bookstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;

@Component
public class DevBootstrap implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, 
			BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	private void initData() {
		Author ernestCline = new Author("Ernest","Cline");
		
		Publisher randomHouse = new Publisher("Random House");
		Publisher crown = new Publisher("Crown");
		
		Book readyPlayerOne = new Book("Ready Player One", "978-0307887436");
		Book armada = new Book("Armada", "0804137250");
		
		ernestCline.addBook(readyPlayerOne);
		ernestCline.addBook(armada);
		
		readyPlayerOne.addAuthor(ernestCline);
		readyPlayerOne.setPublisher(randomHouse);
		armada.addAuthor(ernestCline);
		armada.setPublisher(crown);
		
		publisherRepository.save(crown);
		publisherRepository.save(randomHouse);
		authorRepository.save(ernestCline);
		bookRepository.save(readyPlayerOne);
		bookRepository.save(armada);
		
	}

	@Override
	public void run(String... args) throws Exception {
		this.initData();
	}
}
