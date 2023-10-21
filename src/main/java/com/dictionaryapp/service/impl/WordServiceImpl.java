package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.*;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.WordService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;
    private final LanguageRepository languageRepository;

    public WordServiceImpl(WordRepository wordRepository, UserRepository userRepository, LoggedUser loggedUser, LanguageRepository languageRepository) {
        this.wordRepository = wordRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
        this.languageRepository = languageRepository;
    }

    @Override
    public WordDTO getAllWords() {
        List<Word> words = wordRepository.findAll();

        List<GermanWordDTO> germanWords = new ArrayList<>();
        List<SpanishWordDTO> spanishWords = new ArrayList<>();
        List<FrenchWordDTO> frenchWords = new ArrayList<>();
        List<ItalianWordDTO> italianWords = new ArrayList<>();

        for (Word word: words) {
            if(word.getLanguage().getName().name().equals("GERMAN")){
                germanWords.add(new GermanWordDTO(word));
            } else if (word.getLanguage().getName().name().equals("FRENCH")) {
                frenchWords.add(new FrenchWordDTO(word));
            } else if (word.getLanguage().getName().name().equals("SPANISH")) {
                spanishWords.add(new SpanishWordDTO(word));
            } else if (word.getLanguage().getName().name().equals("ITALIAN")) {
                italianWords.add(new ItalianWordDTO(word));
            }
        }
        return new WordDTO(germanWords,spanishWords,frenchWords,italianWords);
    }

    @Override
    public boolean create(WordCreateBindingModel wordCreateBindingModel) {
        Language language = languageRepository.findByName(wordCreateBindingModel.getLanguage());
        if(loggedUser.getUsername() != null){
            User user = userRepository.findByUsername(loggedUser.getUsername());
            Word word = new Word(wordCreateBindingModel.getTerm(),
                    wordCreateBindingModel.getTranslation(),wordCreateBindingModel.getExample(),
                    wordCreateBindingModel.getInputDate(),language,user);
            wordRepository.save(word);
            return true;
        }


        return false;
    }

    @Override
    public void remove(Long id) {
        wordRepository.deleteById(id);
    }

    @Override
    public void removeAll() {
        wordRepository.deleteAll();
    }
}
