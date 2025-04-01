package com.example.blog.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {
    private int blogId;
    private String blogCode;
    private String content;
    private LocalDateTime createTime;
    private int authorId;
    private String authorCode;
    private String authorName;
}
