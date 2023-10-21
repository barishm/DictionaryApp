package com.dictionaryapp.model.dto;

import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;

import java.time.LocalDate;

public class GermanWordDTO {
    private Long id;
    private String germanTerm;
    private String translation;
    private String example;
    private User addedBy;
    private LocalDate inputDate;

    public GermanWordDTO() {
    }
    public GermanWordDTO(Word word) {
        id = word.getId();
        germanTerm = word.getTerm();
        translation = word.getTranslation();
        example = word.getExample();
        addedBy = word.getAddedBy();
        inputDate = word.getInputDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGermanTerm() {
        return germanTerm;
    }

    public void setGermanTerm(String germanTerm) {
        this.germanTerm = germanTerm;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public void setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
    }
}
