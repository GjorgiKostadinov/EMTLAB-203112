package com.example.emtlab2.service.impl;

import com.example.emtlab2.model.Author;
import com.example.emtlab2.model.Book;
import com.example.emtlab2.model.enumerations.Category;
import com.example.emtlab2.model.exceptions.NoAuthorIdFoundException;
import com.example.emtlab2.model.exceptions.NoBookIdFoundException;
import com.example.emtlab2.model.exceptions.NoCopiesLeftException;
import com.example.emtlab2.repository.AuthorRepository;
import com.example.emtlab2.repository.BookRepository;
import com.example.emtlab2.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void create(String name, Category category, Long authorId, Integer availableCopies) {
        Author author = this.authorRepository.findById(authorId).orElseThrow(NoAuthorIdFoundException::new);
        Book book = new Book(name,category,author,availableCopies);
        this.bookRepository.save(book);
    }

    @Override
    public void deleteById(Long bookId) {
        Book book = this.bookRepository.findById(bookId).orElseThrow(NoBookIdFoundException::new);
        this.bookRepository.delete(book);
    }

    @Override
    public void edit(Long bookId,String name,Category category,Long authorId, Integer availableCopies) {
        Book book = this.bookRepository.findById(bookId).orElseThrow(NoBookIdFoundException::new);
        Author author = this.authorRepository.findById(authorId).orElseThrow(NoAuthorIdFoundException::new);

        book.setName(name);
        book.setAuthor(author);
        book.setCategory(category);
        book.setAvailableCopies(availableCopies);

        this.bookRepository.save(book);
    }

    @Override
    public void markAsTaken(Long bookId) {
        Book book = this.bookRepository.findById(bookId).orElseThrow(NoBookIdFoundException::new);

        if(book.getAvailableCopies()>0){
            book.setAvailableCopies(book.getAvailableCopies()-1);
        }else{
            throw new NoCopiesLeftException();
        }

        this.bookRepository.save(book);
    }

    @Override
    public Optional<Book> findById(Long bookId) {
        return Optional.of(this.bookRepository.findById(bookId).orElseThrow(NoBookIdFoundException::new));
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }
}
