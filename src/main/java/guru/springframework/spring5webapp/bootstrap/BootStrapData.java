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

        Author eric = new Author("Eric", "Evans");

        Book ddd = new Book("Domain Driven Design", "12312312");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");

        Book noEJB = new Book("J2EE development without EJB", "123123132");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        //sout + enter sysout intellij
        System.out.println("Started Bootstrap");
        System.out.println("Number of books:  " + bookRepository.count());

        Publisher pub = new Publisher("aaaa", "aaaa", "aaaa", "aaaa", "aaaa", "aaaa");

        System.out.println(pub.toString());
        ddd.setPublisher(pub);
        pub.getBooks().add(ddd);

        publisherRepository.save(pub);


    }
}
