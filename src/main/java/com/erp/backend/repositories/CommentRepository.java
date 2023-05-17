package com.erp.backend.repositories;


import com.erp.backend.entities.Category;
import com.erp.backend.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository  extends JpaRepository<Comment, Long> {
    @Query("select  c from Comment  c where c.book.bookId = ?1")
    public List<Comment> getListComment(long idBook);
}
