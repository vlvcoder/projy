package com.antonov.projyh2.service;

import com.antonov.projyh2.model.Request;

import java.util.List;

public interface RequestService {
    List<String> getAllWords();
    Request saveRequest(String word);
}
