package com.example.quizproject.db.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "answer", nullable = false, unique = true)
    private String answer;

    @Column(name = "is_right", nullable = false)
    private Boolean isRight;

    @ManyToOne
    private Question question;
}
