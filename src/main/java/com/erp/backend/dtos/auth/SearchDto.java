package com.erp.backend.dtos.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class SearchDto {
    private String keyword;
}
