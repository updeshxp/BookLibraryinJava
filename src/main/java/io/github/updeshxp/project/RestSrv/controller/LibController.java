package io.github.updeshxp.project.RestSrv.controller;

import io.github.updeshxp.project.RestSrv.entity.Book;
import io.github.updeshxp.project.RestSrv.entity.Person;
import io.github.updeshxp.project.RestSrv.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;


import java.util.HashMap;
import java.util.List;

@RestController
public class LibController {
    @Autowired
    private LibraryService libraryService;

    //SaveOp
    @PostMapping("/books")

    public Book saveBook(@RequestBody Book book){
        return libraryService.saveBook(book);
    }

    //ReadOp
    @GetMapping("/books")

    public List<Book> fetchBookList(){
        return libraryService.fetchBookList();
    }

    //UpdateOp

    @PutMapping("/books/{id}")

    public Book updateBook(@RequestBody Book book, @PathVariable("id") Long bookId){
        return libraryService.updateBook(book, bookId);
    }

    @DeleteMapping("books/{id}")

    public String deleteBookById(@PathVariable("id") Long bookId){
        libraryService.deleteBookById(bookId);
        return "Book Removed Successfully";
    }

    //SaveOp
    @PostMapping("/visitors")

    public Person addVisitor(@RequestBody Person person){
        return libraryService.addVisitor(person);
    }

    //ReadOp
    @GetMapping("/visitors")

    public List<Person> fetchVisitorList(){
        return libraryService.fetchVisitorList();
    }

    //UpdateOp

    @PutMapping("/visitors/{id}")

    public Person updatePerson(@RequestBody Person person, @PathVariable("id") Long personId){
        return libraryService.updatePerson(person, personId);
    }

    @DeleteMapping("visitors/{id}")

    public String deletePersonById(@PathVariable("id") Long personId){
        libraryService.deletePersonById(personId);
        return "Visitor Removed Successfully";
    }

    @PostMapping("/borrow/{bookId}/{personId}")

    public JSONObject borrowBookById(@PathVariable("bookId") Long bookId, @PathVariable("personId") Long personId){
        HashMap<String,String> res = new HashMap<String, String>();
        if(libraryService.borrowBookById(bookId, personId))
            res.put("status","Success");
        else
            res.put("status","Failed");
        return new JSONObject(res);
    }

    @PostMapping("/return/{bookId}/{personId}")

    public JSONObject returnBookById(@PathVariable("bookId") Long bookId, @PathVariable("personId") Long personId){
        HashMap<String,String> res = new HashMap<String, String>();
        if(libraryService.returnBookById(bookId, personId))
            res.put("status","Success");
        else
            res.put("status","Failed");
        return new JSONObject(res);
    }
}
