package com.example.dockerfromjenkins.controller;

import com.example.dockerfromjenkins.model.BookDO;
import com.example.dockerfromjenkins.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public List<BookDO> getBooks(){{
        Iterable<BookDO> bookDOIterable = bookRepository.findAll();
        return StreamSupport.stream(bookDOIterable.spliterator(),false).collect(Collectors.toList());
    }

    }


    @PostMapping("/save")
    public BookDO saveBook(@RequestBody BookDO bookDO){
       return bookRepository.save(bookDO);
    }

}
