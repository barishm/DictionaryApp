package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.WordCreateBindingModel;
import com.dictionaryapp.model.dto.WordDTO;
import org.springframework.stereotype.Service;

@Service
public interface WordService {
    WordDTO getAllWords();

    boolean create(WordCreateBindingModel wordCreateBindingModel);

    void remove(Long id);

    void removeAll();

}
