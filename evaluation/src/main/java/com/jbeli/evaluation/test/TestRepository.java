package com.jbeli.evaluation.test;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface TestRepository extends JpaRepository<Test, Integer> {
    boolean TestExisteParDate(Date date);
}
