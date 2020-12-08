package com.wp.springbootelastic.repository;

import com.wp.springbootelastic.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book,Integer> {

    List<Book> findByBookName(String name);

}
