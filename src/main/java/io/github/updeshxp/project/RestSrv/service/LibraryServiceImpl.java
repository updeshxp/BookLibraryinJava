package io.github.updeshxp.project.RestSrv.service;

import io.github.updeshxp.project.RestSrv.entity.Book;
import io.github.updeshxp.project.RestSrv.entity.Person;
import io.github.updeshxp.project.RestSrv.library.BookRepo;
import io.github.updeshxp.project.RestSrv.library.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LibraryServiceImpl implements LibraryService{

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private PersonRepo personRepo;

    //Save
    @Override
    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }

    //Read
    @Override
    public List<Book> fetchBookList() {
        return (List<Book>) bookRepo.findAll();
    }

    //Update
    @Override
    public Book updateBook(Book book, Long givenBookId) {
        Book bookDB = bookRepo.findById(givenBookId).get();

        if(Objects.nonNull(book.getBookName()) && !"".equalsIgnoreCase(book.getBookName())){
            bookDB.setBookName(book.getBookName());
        }
        if(Objects.nonNull(book.getBookAuthor()) && !"".equalsIgnoreCase(book.getBookAuthor())){
            bookDB.setBookAuthor(book.getBookAuthor());
        }
        if(Objects.nonNull(book.getBookCode()) && !"".equalsIgnoreCase(book.getBookCode())){
            bookDB.setBookCode(book.getBookCode());
        }
        if(Objects.nonNull(book.getIsBorrowedBy())){
            bookDB.setIsBorrowedBy(book.getIsBorrowedBy());
        }
        return bookRepo.save(bookDB);
    }

    @Override
    public void deleteBookById(Long givenBookId) {
        bookRepo.deleteById(givenBookId);

    }

    @Override
    public Person addVisitor(Person person) {
        return personRepo.save(person);
    }

    @Override
    public List<Person> fetchVisitorList() {
        return (List<Person>) personRepo.findAll();
    }

    @Override
    public Person updatePerson(Person person, Long personId) {
        Person personDB = personRepo.findById(personId).get();
        if(Objects.nonNull(person.getPersonName()) && !"".equalsIgnoreCase(person.getPersonName()))
            personDB.setPersonName(person.getPersonName());

        if(Objects.nonNull(person.getPersonAddress()) && !"".equalsIgnoreCase(person.getPersonAddress()))
            personDB.setPersonAddress(person.getPersonAddress());

        return personRepo.save(personDB);
    }

    @Override
    public void deletePersonById(Long personId) {
        personRepo.deleteById(personId);
    }

    @Override
    public Boolean borrowBookById(Long BookId, Long personId) {
        Person personDB = personRepo.findById(personId).get();
        Book bookDB = bookRepo.findById(BookId).get();
        if(null != bookDB.getIsBorrowedBy())
            return false;
        bookDB.setIsBorrowedBy(personDB);
        bookRepo.save(bookDB);
        List<Book> borrowedBooks = personDB.getBooksList();
        if (borrowedBooks.add(bookDB))
            personDB.setBooksList(borrowedBooks);
        personRepo.save(personDB);
        return true;
    }

    @Override
    public Boolean returnBookById(Long BookId, Long personId) {
        Person personDB = personRepo.findById(personId).get();
        Book bookDB = bookRepo.findById(BookId).get();
        if(personDB != bookDB.getIsBorrowedBy())
            return false;
        bookDB.setIsBorrowedBy(null);
        bookRepo.save(bookDB);
        List<Book> borrowedBooks = personDB.getBooksList();
        if (borrowedBooks.remove(bookDB))
            personDB.setBooksList(borrowedBooks);
        personRepo.save(personDB);
        return true;
    }
}
