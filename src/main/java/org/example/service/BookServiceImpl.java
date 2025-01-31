package org.example.service;

import org.example.domain.Book;
import org.example.domain.HibernateSession;
import org.example.exeptions.BookNotFoundException;
import org.example.exeptions.BookUnderZeroException;
import org.example.exeptions.DuplicateRecordException;
import org.example.model.BookDTO;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{
    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);


    @Override
    public void addNewBook(BookDTO bookDTO) {
        Optional<Book> bookById = Optional.ofNullable(HibernateSession.getRecordById(bookDTO.getId()));
        bookById.ifPresent(_ -> {
            throw  new DuplicateRecordException(
                    "book with this id" + bookDTO.getId() + "is presented");
        });
        LOGGER.info("no such book presents in database");
        HibernateSession.saveCompleteRecord(bookDTO);
    }

    @Override
    public BookDTO getBookById(long id) {
        Optional<Book> bookById = Optional.ofNullable(Optional.ofNullable(HibernateSession.getRecordById(id))
                .orElseThrow(() -> new BookNotFoundException("book not found")));
        LOGGER.info("The book by such id is introduced");
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(bookById, BookDTO.class);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> bookList = HibernateSession.getAllRecords();
        return mapBookListToBookDtoList(bookList);
    }

    @Override
    public int getNumberOfRecordsById(long id) {
        Optional<Book> book = Optional.ofNullable(Optional.ofNullable(HibernateSession.getRecordById(id))
                .orElseThrow(() -> new BookNotFoundException("no such book existed")));
        return book.orElseThrow().getTotalCount();
    }

    @Override
    public BookDTO getBookByNameOfTheBook(String title) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Book> book = Optional.ofNullable(Optional.ofNullable(HibernateSession.getRecordByTitle(title))
                .orElseThrow(() -> new BookNotFoundException("no book with this title is found")));
        return modelMapper.map(book, BookDTO.class);
    }

    @Override
    public void getQuantityToAdd(long id, int quantityToAdd) {
        Optional<Book> bookById = Optional.ofNullable(Optional.ofNullable(HibernateSession.getRecordById(id))
                .orElseThrow(() -> new BookNotFoundException("book is not found")));
        int result = bookById.orElseThrow().getTotalCount() + quantityToAdd;
        bookById.orElseThrow().setTotalCount(result);
        HibernateSession.updateRowOfTable(id, quantityToAdd);


    }

    @Override
    public void sellingBook(long id) {
        Book bookById = HibernateSession.getRecordById(id);
        if(bookById.getTotalCount() < 0){
            throw  new BookUnderZeroException("counts of book could not be negative");
        }
        int total = bookById.getTotalCount() - 1;
        int sold = bookById.getSold() +1;
        HibernateSession.updateSoldRecords(id, total, sold);
    }

    private List<BookDTO> mapBookListToBookDtoList(List<Book> books){
        ModelMapper modelMapper = new ModelMapper();
        return  books.stream().map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }
}
