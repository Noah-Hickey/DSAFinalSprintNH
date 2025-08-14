package com.repository;

import com.model.TreeResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TreeResultRepository extends JpaRepository<TreeResult, Long> {
    List<TreeResult> findAllByOrderByCreatedAtDesc();
}