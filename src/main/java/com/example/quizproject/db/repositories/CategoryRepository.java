package com.example.quizproject.db.repositories;

import com.example.quizproject.db.entities.Category;
import com.example.quizproject.models.outputs.CategoryOutput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {

}
