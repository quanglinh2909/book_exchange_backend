package com.erp.backend.services;

import com.erp.backend.dtos.request.NotificationRequest;
import com.erp.backend.entities.Book;
import com.erp.backend.entities.Notification;
import com.erp.backend.entities.User;
import com.erp.backend.enums.ReadStatus;
import com.erp.backend.models.Response;
import com.erp.backend.repositories.BookRepository;
import com.erp.backend.repositories.NotificationRepository;
import com.erp.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    NotificationRepository notificationRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;
    @Transactional
    public Notification createNotification(String email,NotificationRequest request){
        Book book=bookRepository.findById(request.getIdBook()).get();
        User userCreate=userRepository.findByEmail(email).get();
        User userTarget=book.getUserCreate();
        Notification notification=Notification.builder()
                .book(book)
                .userCreate(userCreate)
                .userTarget(userTarget)
                .isRead(ReadStatus.NOTREAD)
                .build();


        Notification saveNotify=notificationRepository.save(notification);
        return saveNotify;
    }
    public List<Notification> getAll(Long idUser){
        return notificationRepository.getAll(idUser);
    }
    public Response read(Long idNotify){
        Notification notification=notificationRepository.findById(idNotify).get();
        notification.setIsRead(ReadStatus.READ);
        notificationRepository.save(notification);
        return new Response(200,null,null);
    }
}
