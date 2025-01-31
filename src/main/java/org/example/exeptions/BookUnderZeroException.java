package org.example.exeptions;

public class BookUnderZeroException extends RuntimeException {
    public BookUnderZeroException(String message) {
        super(message);
    }
}
