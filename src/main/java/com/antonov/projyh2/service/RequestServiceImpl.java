package com.antonov.projyh2.service;

import com.antonov.projyh2.model.Request;
import com.antonov.projyh2.repository.RequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;

    @Override
    public List<String> getAllWords() {
        return requestRepository
                .findAll().stream()
                .map(Request::getWord)
                .collect(Collectors.toList());
    }

    @Override
    public Request saveRequest(String word) {
        var request = new Request();
        request.setWord(word);
        return requestRepository.save(request);
    }
}
