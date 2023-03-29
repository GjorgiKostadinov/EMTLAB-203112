package com.example.emtlab2.web;

import com.example.emtlab2.datainit.Datainit;
import com.example.emtlab2.model.Book;
import com.example.emtlab2.model.enumerations.Category;
import com.example.emtlab2.service.AuthorService;
import com.example.emtlab2.service.BookService;
import com.example.emtlab2.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {

    private final BookService bookService;
    private final CountryService countryService;
    private final AuthorService authorService;
    private final Datainit datainit;

    public HomeController(BookService bookService, CountryService countryService, AuthorService authorService, Datainit datainit) {
        this.bookService = bookService;
        this.countryService = countryService;
        this.authorService = authorService;
        this.datainit = datainit;
    }

    @GetMapping({"/","/books"})
    public List<Book> findAllBooks(){
        return this.bookService.findAll();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id,
                                         @RequestParam String name,
                                         @RequestParam Long authorId,
                                         @RequestParam String category,
                                         @RequestParam Integer availableCopies){
        Category cat = Category.valueOf(category);
        this.bookService.edit(id,name,cat,authorId,availableCopies);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/markAsTaken/{id}")
    public ResponseEntity<Book> markAsTaken(@PathVariable Long id){
        this.bookService.markAsTaken(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addNewBook(@RequestParam String name,
                                           @RequestParam String category,
                                           @RequestParam Long authorId,
                                           @RequestParam Integer availableCopies){
        Category cat = Category.valueOf(category);
        this.bookService.create(name,cat,authorId,availableCopies);

        return ResponseEntity.ok().build();

    }

}
