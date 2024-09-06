package com.example.demo.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class CategoryListResponse {
    private List<CategoryResponse> categoryResponseList;
    private int totalPage;
}
