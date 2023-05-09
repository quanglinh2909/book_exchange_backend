package com.erp.backend.dtos;

import com.erp.backend.entities.ImageModel;

import java.util.List;
import java.util.Set;

public record BookDTO(Long bookId, String bookName, String bookDescribe, String category, String author, Set<ImageModel> productImages) {
}
