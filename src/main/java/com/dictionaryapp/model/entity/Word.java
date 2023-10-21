package com.dictionaryapp.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "words")
public class Word extends BaseEntity {
    @Column(nullable = false)
    private String term;
    @Column(nullable = false)
    private String translation;
    @Column
    private String example;
    @Column(nullable = false)
    private LocalDate inputDate;
    @NotNull
    @ManyToOne
    private Language language;

    @ManyToOne
    private User addedBy;

    public Word() {

    }

    public Word(String term, String translation, String example, LocalDate inputDate, Language language, User addedBy) {
        this.term = term;
        this.translation = translation;
        this.example = example;
        this.inputDate = inputDate;

        this.language = language;
        this.addedBy = addedBy;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
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

    public LocalDate getInputDate() {
        return inputDate;
    }

    public void setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }
}
