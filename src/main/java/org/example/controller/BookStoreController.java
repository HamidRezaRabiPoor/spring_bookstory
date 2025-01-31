package org.example.controller;

import org.example.model.BookDTO;
import org.example.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookStoreController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookStoreController.class);
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    List<BookDTO> bookDTOS(){
        return bookService.getAllBooks();
    }


    @GetMapping("/bookById")
    private BookDTO getBookById(@RequestParam(required = false) long id){
        return bookService.getBookById(id);
    }



    @GetMapping("/bookByTitle")
    private BookDTO getBookByTitleOfTheBook(@RequestParam(required = false) String bookTitle){
        return bookService.getBookByNameOfTheBook(bookTitle);
    }



    @GetMapping("/add_new_book")
    private void addNewBookToDB(@RequestParam(required = false) BookDTO bookDTO){
        bookService.addNewBook(bookDTO);
    }


    @GetMapping("/number_of_book")
    private int getNumberOfSpecificBook(@RequestParam(required = false) long id){
        return bookService.getNumberOfRecordsById(id);
    }


    @GetMapping("/add_quantity")
    private void addQuantityOfBook(@RequestParam(required = false) long id,@RequestParam(required = false) int quantity){
        bookService.getQuantityToAdd(id, quantity);
    }

    @GetMapping("/book_sold")
    private void bookIsSold(@RequestParam(required = false) long id){
        bookService.sellingBook(id);
    }
 }



