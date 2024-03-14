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
@Table(name = "difficulty")
public class Difficulty {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "difficulty", nullable = false, unique = true)
    private String difficulty;

    @OneToMany
    @JoinColumn(name = "difficulty_id", referencedColumnName = "id")
    private List<Question> questions;

    Difficulty(String difficulty) { this.difficulty = difficulty; }
}