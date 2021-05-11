package com.jiho.test.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class PostResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;
}
