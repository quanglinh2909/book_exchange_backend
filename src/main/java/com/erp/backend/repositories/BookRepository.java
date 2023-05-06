package com.erp.backend.repositories;

import com.erp.backend.entities.Book;
import com.erp.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> 8c2fcc47fc3037cedb2aa38575b5590b725daf17
import java.util.Optional;
>>>>>>> dev


<<<<<<< HEAD
<<<<<<< HEAD
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByBookNameContainingIgnoreCaseOrAuthorNameContainingIgnoreCase(String name, String author);

}
=======
    @Query("select b from Book b where b.bookId=?1")
    public Book getBookById(long id);
    @Query("select  b from Book  b where b.category.category_id = ?1")
    public List<Book> getBookByCategory(long id);
    @Query("select  b from Book  b where b.author.author_id = ?1")
    public List<Book> getBookByAuthor(long id);
 //   List<Book> findByNameContainingIgnoreCaseOrAuthorContainingIgnoreCase(String name, String author);
    List<Book> findByBookNameContainingIgnoreCaseOrAuthorNameContainingIgnoreCase(String name, String author);
}

//public interface BookRepository extends CrudRepository<Book, Long> {
//}package com.erp.backend.repositories;
//
//import com.erp.backend.entities.Book;
//import com.erp.backend.entities.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface BookRepository extends JpaRepository<Book, Long> {
//
//    @Query("select b from Book b where b.bookId=?1")
//    public Book getBookById(long id);
//    @Query("select  b from Book  b where b.category.category_id = ?1")
//    public List<Book> getBookByCategory(long id);
//    @Query("select  b from Book  b where b.author.author_id = ?1")
//    public List<Book> getBookByAuthor(long id);
//
//}
//
////public interface BookRepository extends CrudRepository<Book, Long> {
////}
>>>>>>> dev
=======
    @Query("select b from Book b where b.bookId=?1")
    public Book getBookById(long id);
    @Query("select  b from Book  b where b.category.category_id = ?1")
    public List<Book> getBookByCategory(long id);
    @Query("select  b from Book  b where b.author.author_id = ?1")
    public List<Book> getBookByAuthor(long id);

}

//public interface BookRepository extends CrudRepository<Book, Long> {
//}
>>>>>>> 8c2fcc47fc3037cedb2aa38575b5590b725daf17
