package com.jbeli.evaluation.test;
import lombok.Builder;
import org.springframework.stereotype.Service;

@Service
@Builder
public class TestMapper {

    public TestResponse toTestDto(Test t) {
        return TestResponse.builder()
                .date(t.getDate())
                .build();
    }

    public Test toTest(TestRequest t) {
        return Test.builder()
                .id(t.getId())
                .note(t.getNote())
                .build();
    }
}
