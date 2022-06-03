package com.techelevator.controller;

import com.techelevator.dao.BookDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Book;
import com.techelevator.model.Member;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class BookController {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private UserDao userDao;

    @ApiOperation("get all books by userId")
    @RequestMapping(path="/myBooks", method = RequestMethod.GET)
    public List<Book> getAllBooksByUserId(@ApiParam("principal") Principal principal) {

        long userId =(long)userDao.findIdByUsername(principal.getName());

        return bookDao.getListOfBooksByUser(userId);

    }

    @ApiOperation("get all books")
    @RequestMapping(path="/books", method = RequestMethod.GET)
    public List<Book> getAllBooks() {

        return bookDao.getAllBooks();

    }


    @ApiOperation("get a book by bookId")
    @RequestMapping(path="/books/{id}", method = RequestMethod.GET)
    public Book getBookByBookId(@PathVariable @ApiParam("book id") Long id) {

        return bookDao.getBookById(id);

    }

    

}
