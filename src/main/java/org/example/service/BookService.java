package org.example.service;

import org.example.model.BookDTO;

import java.util.List;

public interface BookService {


void addNewBook(BookDTO bookDTO);

BookDTO getBookById(long id);

List<BookDTO> getAllBooks();

int getNumberOfRecordsById(long id);

BookDTO getBookByNameOfTheBook(String title);

void getQuantityToAdd(long id, int quantityToAdd);

void sellingBook(long id);
}
