package com.erp.backend.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAuthorRequest {
    private Long id;
    @NotNull(message = "name is require")
    private String name;
    private String description;
}
