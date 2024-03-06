package com.jbeli.evaluation.test;

import com.jbeli.evaluation.interview.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Integer> {
}
