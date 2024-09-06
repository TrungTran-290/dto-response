package com.example.demo.repository;

import com.example.demo.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<Category,Long> {
}
