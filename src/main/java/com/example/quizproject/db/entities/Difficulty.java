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

    @Column(name = "difficulty", nullable = false)
    private String difficultyValue;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "difficulty")
    //@JoinColumn(name = "difficulty_id", referencedColumnName = "id")
    private List<Question> questions;

}