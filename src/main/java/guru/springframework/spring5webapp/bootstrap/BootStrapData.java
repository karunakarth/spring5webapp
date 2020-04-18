package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author vyas = new Author("Vyasa", "Veda");
        Book epic1 = new Book("Mahabharata", "ISBNBC4600");
        vyas.getBooks().add(epic1);
        epic1.getAuthors().add(vyas);
        Publisher publisher1 = new Publisher("HDPublisher", "Hyderabad", "Hyderabad", "Telangana", "500079" );
        publisher1.getBooks().add(epic1);
        authorRepository.save(vyas);
        bookRepository.save(epic1);

        Author valmiki = new Author("Valmiki", "val");
        Book epic2 = new Book("Ramayana", "ISBNTretayuga");
        valmiki.getBooks().add(epic2);
        epic1.getAuthors().add(valmiki);
        publisher1.getBooks().add(epic2);
        authorRepository.save(valmiki);
        bookRepository.save(epic2);


        publisherRepository.save(publisher1);
        System.out.println("Started in Bootstrap");
        System.out.println("Number Of Books: "+bookRepository.count());
        System.out.println("Number of publishers: "+publisherRepository.count());
        System.out.println("Number Of Books Published: "+publisher1.getBooks().size());
    }
}
