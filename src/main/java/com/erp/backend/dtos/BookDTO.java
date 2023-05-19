package com.erp.backend.dtos;

import com.erp.backend.entities.Comment;
import com.erp.backend.entities.ImageModel;
import com.erp.backend.entities.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

public record BookDTO(Long bookId, String bookName, String bookDescribe, String category, String author, String image,
                      User userCreate, Date createdAt, List<Comment> listComment) {
}
