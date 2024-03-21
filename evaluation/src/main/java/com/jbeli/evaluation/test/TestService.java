package com.jbeli.evaluation.test;


import java.util.Date;
import java.util.List;

public interface TestService {
    TestResponse findById(Integer id);
    List<TestResponse> findAll();
    void deleteById(Integer id);
    Integer save(TestRequest test );

    boolean TestExisteParDate(Date date);
}
