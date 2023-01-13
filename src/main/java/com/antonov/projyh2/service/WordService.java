package com.antonov.projyh2.service;

import com.antonov.projyh2.dto.Task1Response;
import com.antonov.projyh2.dto.Task2Response;
import com.antonov.projyh2.model.Request;

import java.util.List;

public interface WordService {
    List<Task1Response> task1(String word);

    List<Task2Response> task2(List<String> words);
}
