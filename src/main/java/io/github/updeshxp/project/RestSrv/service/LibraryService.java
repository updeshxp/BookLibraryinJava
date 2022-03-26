package io.github.updeshxp.project.RestSrv.service;

import io.github.updeshxp.project.RestSrv.entity.Book;
import io.github.updeshxp.project.RestSrv.entity.Person;

import java.util.List;

public interface LibraryService {
    //Save book
    Book saveBook(Book book);

    //Read Books
    List<Book> fetchBookList();

    //Update Book
    Book updateBook(Book book, Long bookId);

    //Delete book
    void deleteBookById(Long bookId);

    Person addVisitor(Person person);

    // List People
    List<Person> fetchVisitorList();

    // Update Person
    Person updatePerson(Person person, Long personId);

    // Remove Visitor
    void deletePersonById(Long personId);

    // Borrow Book
    Boolean borrowBookById(Long BookId, Long personId);

    // Return Book
    Boolean returnBookById(Long BookId, Long personId);
}
