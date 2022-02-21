package com.example.dockerfromjenkins.repository;

import com.example.dockerfromjenkins.model.BookDO;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookDO, Integer> {
}
