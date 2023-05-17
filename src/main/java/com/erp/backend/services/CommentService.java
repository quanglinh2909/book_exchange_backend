package com.erp.backend.services;

import com.erp.backend.dtos.request.CommentRequest;
import com.erp.backend.entities.Book;
import com.erp.backend.entities.Comment;
import com.erp.backend.entities.User;
import com.erp.backend.repositories.BookRepository;
import com.erp.backend.repositories.CommentRepository;
import com.erp.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    public List<Comment> getListComment(Long idBook){
        return commentRepository.getListComment(idBook);

    }
    public Comment createComment(CommentRequest request){
        User user=userRepository.findById(request.getIdUser()).get();
        Book book=bookRepository.findById(request.getIdBook()).get();
        Comment comment=Comment.builder().content(request.getContent())
                .userCreate(user)
                .book(book)
                .build();
        Comment saveComment=commentRepository.save(comment);
        return saveComment;
    }
}
