package com.example.quizproject.db.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "category_name", nullable = false, unique = true)
    private String categoryName;

    @OneToMany
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private List<Question> questions;

}