package com.sun.repository;

import com.sun.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sun
 * @date 2021/2/25 - 11:43
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
}
