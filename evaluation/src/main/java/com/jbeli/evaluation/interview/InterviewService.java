package com.jbeli.evaluation.interview;

import com.jbeli.evaluation.PageResponse;

public interface InterviewService {
    Interview findById(Integer id);
    PageResponse<Interview> findAll(int page, int size);
    void deleteById(Integer id);
    Interview CreateInterview(Interview u);
}
