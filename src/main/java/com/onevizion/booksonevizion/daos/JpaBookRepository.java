package com.onevizion.booksonevizion.daos;

import com.onevizion.booksonevizion.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBookRepository extends JpaRepository<Book, Integer> {

}
