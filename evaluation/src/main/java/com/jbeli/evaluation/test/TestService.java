package com.jbeli.evaluation.test;

import com.jbeli.evaluation.PageResponse;
import com.jbeli.evaluation.interview.Interview;

public interface TestService {
    Test findById(Integer id);
    PageResponse<Test> findAll(int page, int size);
    void deleteById(Integer id);
    Test CreateTest(Test test);
}
