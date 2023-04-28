package com.erp.backend.repositories;

import com.erp.backend.entities.Book;
import com.erp.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

<<<<<<< HEAD
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {


=======
public interface BookRepository extends CrudRepository<Book, Long> {
>>>>>>> dev
}
