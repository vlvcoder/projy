package com.antonov.projyh2.service;

import com.antonov.projyh2.dto.Task1Response;
import com.antonov.projyh2.dto.Task2Response;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class WordServiceImpl implements WordService {
    private long letterCount(String word, char letter) {
        return word.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c.equals(letter))
                .count();
    }

    private long maxSequenceLength(String word, char letter) {
        var sequences = new ArrayList<Long>();
        long len = 0;
        for (char c : word.toCharArray()) {
            if (c == letter) {
                len++;
            } else {
                if (len > 0) {
                    sequences.add(len);
                    len = 0;
                }
            }
        }
        if (len > 0) {
            sequences.add(len);
        }
        return sequences.stream().mapToLong(Long::longValue).max().orElse(0);
    }

    private Stream<String> distinctLetters(List<String> words) {
        return words.stream()
                .flatMap(word -> word.chars()
                        .mapToObj(c -> (char) c))
                .distinct()
                .sorted()
                .map(String::valueOf);
    }

    @Override
    public List<Task1Response> task1(String word) {
        return word.chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .sorted()
                .map(c -> Task1Response.builder()
                        .letter((char) c)
                        .letterCount(letterCount(word, c))
                        .maxSequenceLength(maxSequenceLength(word, c))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<Task2Response> task2(List<String> words) {
        return distinctLetters(words).map(s -> {
                    char c = s.charAt(0);
                    long wordCount = words.stream().filter(word -> word.contains(s)).count();
                    long letterCount = words.stream().mapToLong(word -> letterCount(word, c)).sum();
                    long maxSequenceLength = words.stream().mapToLong(word -> maxSequenceLength(word, c)).sum();
                    return Task2Response.builder()
                            .letter(c)
                            .requestCount(wordCount)
                            .averageCountInRequest((double) letterCount / (double) wordCount)
                            .averageSequenceLength((double) maxSequenceLength / (double) wordCount)
                            .build();
                })
                .collect(Collectors.toList());
    }
}
