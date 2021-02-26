package com.sun.mapper;

import com.sun.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sun
 * @date 2021/2/25 - 21:52
 */
@Mapper
@Repository
public interface BookMapper {
    List<Book> findAll();
    Book getBookById(int id);
    Book getBookByName(String name);
    int delBookById(int id);
    int updBook(Book books);
    int insertBook(Book books);
}