package com.erp.backend.services;

import com.erp.backend.dtos.request.CommentRequest;
import com.erp.backend.entities.Book;
import com.erp.backend.entities.Comment;
import com.erp.backend.entities.User;
import com.erp.backend.repositories.BookRepository;
import com.erp.backend.repositories.CommentRepository;
import com.erp.backend.repositories.UserRepository;
import com.erp.backend.socket_io.SocketHandleGlobal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    SocketHandleGlobal socket;
    @Transactional
    public Comment createComment(String email,CommentRequest request){
        User user=userRepository.findByEmail(email).get();
        Book book=bookRepository.findById(request.getIdBook()).get();
        Comment comment=Comment.builder().content(request.getContent())
                .userCreate(user)
                .build();
        Comment saveComment=commentRepository.save(comment);
        book.getListComment().add(comment);
        bookRepository.save(book);
        List<User> listClient=userRepository.findAll();
        for(User client:listClient){
            socket.sendEvent(client.getId(),"comment",saveComment);
        }
        return saveComment;
    }
}
