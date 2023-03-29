package com.example.emtlab2.datainit;



import com.example.emtlab2.model.Author;
import com.example.emtlab2.model.Book;
import com.example.emtlab2.model.Country;
import com.example.emtlab2.model.enumerations.Category;
import com.example.emtlab2.repository.AuthorRepository;
import com.example.emtlab2.repository.BookRepository;
import com.example.emtlab2.repository.CountryRepository;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class Datainit {

    public List<Book> books = new ArrayList<>();
    public List<Author> authors = new ArrayList<>();
    public List<Country> countries = new ArrayList<>();

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public Datainit(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }


    @PostConstruct
    public void init() {

        //Countries init
        countries.add(new Country("Germany","Europe"));
        countries.add(new Country("USA","North America"));
        countries.add(new Country("Japan","Asia"));
        countries.add(new Country("Italy","Europe"));
        countries.add(new Country("South Korea","Asia"));
        countries.add(new Country("Brazil","South America"));

        this.countryRepository.saveAll(countries);

        //Authors init
        authors.add(new Author("Victor","Hugo",countries.get((int) (Math.random() * countries.size()))));
        authors.add(new Author("Dante","Alighieri",countries.get((int) (Math.random() * countries.size()))));
        authors.add(new Author("Ernest ","Hemingway",countries.get((int) (Math.random() * countries.size()))));
        authors.add(new Author("George","Orwell",countries.get((int) (Math.random() * countries.size()))));
        authors.add(new Author("Eftim","Mircev",countries.get((int) (Math.random() * countries.size()))));

        this.authorRepository.saveAll(authors);

        //Books init
        books.add(new Book("The God of Endings: A Novel", Category.FANTASY,authors.get((int) (Math.random() * authors.size())),50));
        books.add(new Book("Don Quixote", Category.CLASSICS,authors.get((int) (Math.random() * authors.size())),50));
        books.add(new Book("Assistant to the Villain", Category.HISTORY,authors.get((int) (Math.random() * authors.size())),50));
        books.add(new Book("Da Vinci Code,The", Category.HISTORY,authors.get((int) (Math.random() * authors.size())),50));
        books.add(new Book("Harry Potter and the Deathly Hallows", Category.BIOGRAPHY,authors.get((int) (Math.random() * authors.size())),50));
        books.add(new Book("Harry Potter and the Philosopher's Stone", Category.THRILLER,authors.get((int) (Math.random() * authors.size())),50));
        books.add(new Book("The Hobbit", Category.CLASSICS,authors.get((int) (Math.random() * authors.size())),50));

        this.bookRepository.saveAll(books);

    }
}