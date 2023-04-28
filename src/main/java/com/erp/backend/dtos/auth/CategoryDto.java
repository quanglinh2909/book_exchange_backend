package com.erp.backend.dtos.auth;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
@Data
@Builder
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class CategoryDto {
    @NotNull(message = "Ten the loai khong duoc de trong")
    private String name;
    private String description;
}
