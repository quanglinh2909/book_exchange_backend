package com.erp.backend.repositories;

import com.erp.backend.entities.Book;
import com.erp.backend.entities.Category;
import com.erp.backend.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationRepository  extends JpaRepository<Notification, Long> {
    @Query("select n from Notification  n where n.userTarget.id = ?1 ")
    public List<Notification> getAll(long idUser);

}
