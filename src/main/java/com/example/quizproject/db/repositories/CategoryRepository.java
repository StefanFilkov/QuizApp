package com.example.quizproject.db.repositories;

import com.example.quizproject.db.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {
    Optional<Category> findByCategoryName(String categoryName);
}
