package com.example.quizproject.db.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.web.JsonPath;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "question_body", nullable = false, unique = true)
    private String questionBody;

    @ManyToOne
    private Difficulty difficulty;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Quiz quiz;

    @OneToMany
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private List<Answer> answers;
}