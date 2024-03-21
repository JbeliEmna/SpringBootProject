package com.jbeli.evaluation.test;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService{
      private final TestRepository repository;
      private final TestMapper mapper;

    @Override
    public TestResponse findById(Integer id) {
        return this.repository.findById(id)
                .map(mapper::toTestDto)
                .orElse(new TestResponse());
    }

    @Override
    public List<TestResponse> findAll() {
        return this.repository.findAll()
                .stream()
                .map(mapper::toTestDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        this.repository.deleteById(id);
    }

    @Override
    public Integer save(TestRequest t) {
        Test test = mapper.toTest(t);
        return this.repository.save(test).getId();
    }

    @Override
    public boolean TestExisteParDate(Date date) {
        return repository.TestExisteParDate(date);
    }
}
