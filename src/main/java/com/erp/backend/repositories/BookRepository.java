package com.erp.backend.repositories;

import com.erp.backend.entities.Book;
import com.erp.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
   // List<Book> findByBookNameContainingIgnoreCaseOrAuthorNameContainingIgnoreCase(String name, String author);



    @Query("select b from Book b where b.bookId=?1")
    public Book getBookById(long id);
    @Query("select  b from Book  b where b.category.category_id = ?1")
    public List<Book> getBookByCategory(long id);
    @Query("select  b from Book  b where b.userCreate.id = ?1")
    public List<Book> getBookByUser(long idUser);
    @Query("select  b from Book  b where b.author.author_id = ?1 ")
    public List<Book> getBookByAuthor(long id);
    @Modifying
    @Query("select b from Book b where b.author.name like ?1 or b.bookName like ?1")
    public List<Book> searchBook(String keyword);
//    @Modifying
//    @Query("select b from Book b where b.category=?1 order by createdAt DESC")
//    public List<Book> findByCategoryOrderByCreatedAt(Long categoryId);
//    @Modifying
//    @Query("select top 5 b from Book b order by createdAt DESC")
//    public List<Book> findTopRecent();
    //List<Book> findByNameContainingIgnoreCaseOrAuthorContainingIgnoreCase(String name, String author);
    List<Book> findByBookNameContainingIgnoreCaseOrAuthorNameContainingIgnoreCase(String name, String author);

    @Query("select b from Book b join Category c on c.category_id = b.category.category_id order by c.createdAt desc ")
    public List<Book> topBook();

    @Query("select b from Book b join Category c on c.category_id = b.category.category_id order by c.createdAt desc ")
    public List<Book> topBookByNameCategory();
    @Query("select b from Book b join Author a on a.author_id = b.author.author_id order by a.name desc ")
    public List<Book> topBookAuthor();

}


