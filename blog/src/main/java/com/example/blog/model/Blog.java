package com.example.blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Table(name = "blog")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,unique = true)
    private String code;
    @Column(nullable = false)
    private String content;
    @Column(name = "create_time",nullable = false)
    private LocalDateTime createTime;
    @PrePersist
    protected void onCreate() {
        this.createTime = LocalDateTime.now();
    }
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_author")
    private Author author;
}
