package com.antonov.projyh2.controller;


import com.antonov.projyh2.dto.*;
import com.antonov.projyh2.model.Request;
import com.antonov.projyh2.service.RequestService;
import com.antonov.projyh2.service.WordService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class MainRestController {

    private final RequestService requestService;
    private final WordService wordService;

    @GetMapping("/")
    public String index() {
        return "Hello!";
    }

    @GetMapping("/task1/{word}")
    public List<Task1Response> task1(@PathVariable String word) {
        word = word.toLowerCase();
        return wordService.task1(word.toLowerCase());
    }

    @GetMapping("/task2/{word}")
    public List<Task2Response> task2(@PathVariable String word) {
        word = word.toLowerCase();
        requestService.saveRequest(word);
        List<String> words = requestService.getAllWords();
        return wordService.task2(words);
    }

}
