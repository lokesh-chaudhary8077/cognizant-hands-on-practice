package com.library.controller;

import com.library.service.BookService;

public class LibraryController {

    private BookService service = new BookService();

    public void start() {
        service.addBook();
    }

}