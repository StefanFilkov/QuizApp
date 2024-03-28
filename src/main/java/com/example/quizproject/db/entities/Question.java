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

    @Column(name = "question_body")
    private String questionBody;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Difficulty difficulty;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Category category;

    @ManyToOne
    private Quiz quiz;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Answer rightAnswer;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private List<Answer> answers;
}