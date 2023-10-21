package com.dictionaryapp.model.dto;

import java.util.List;

public class WordDTO {
    private List<GermanWordDTO> germanWords;
    private List<SpanishWordDTO> spanishWords;
    private List<FrenchWordDTO> frenchWords;
    private List<ItalianWordDTO> italianWords;
    private int germanWordsCount;
    private int spanishWordsCount;
    private int frenchWordsCount;
    private int italianWordsCount;
    private int allWordsCount;

    public int getGermanWordsCount() {
        return germanWordsCount;
    }

    public void setGermanWordsCount(int germanWordsCount) {
        this.germanWordsCount = germanWordsCount;
    }

    public int getSpanishWordsCount() {
        return spanishWordsCount;
    }

    public void setSpanishWordsCount(int spanishWordsCount) {
        this.spanishWordsCount = spanishWordsCount;
    }

    public int getFrenchWordsCount() {
        return frenchWordsCount;
    }

    public void setFrenchWordsCount(int frenchWordsCount) {
        this.frenchWordsCount = frenchWordsCount;
    }

    public int getItalianWordsCount() {
        return italianWordsCount;
    }

    public void setItalianWordsCount(int italianWordsCount) {
        this.italianWordsCount = italianWordsCount;
    }

    public WordDTO(List<GermanWordDTO> germanWords, List<SpanishWordDTO> spanishWords, List<FrenchWordDTO> frenchWords, List<ItalianWordDTO> italianWords) {
        this.germanWords = germanWords;
        this.spanishWords = spanishWords;
        this.frenchWords = frenchWords;
        this.italianWords = italianWords;
        this.germanWordsCount = germanWords.size();
        this.spanishWordsCount = spanishWords.size();
        this.frenchWordsCount = frenchWords.size();
        this.italianWordsCount = italianWords.size();
        this.allWordsCount = germanWordsCount + spanishWordsCount + frenchWordsCount + italianWordsCount;
    }

    public int getAllWordsCount() {
        return allWordsCount;
    }

    public void setAllWordsCount(int allWordsCount) {
        this.allWordsCount = allWordsCount;
    }

    public List<GermanWordDTO> getGermanWords() {
        return germanWords;
    }

    public void setGermanWords(List<GermanWordDTO> germanWords) {
        this.germanWords = germanWords;
    }

    public List<SpanishWordDTO> getSpanishWords() {
        return spanishWords;
    }

    public void setSpanishWords(List<SpanishWordDTO> spanishWords) {
        this.spanishWords = spanishWords;
    }

    public List<FrenchWordDTO> getFrenchWords() {
        return frenchWords;
    }

    public void setFrenchWords(List<FrenchWordDTO> frenchWords) {
        this.frenchWords = frenchWords;
    }

    public List<ItalianWordDTO> getItalianWords() {
        return italianWords;
    }

    public void setItalianWords(List<ItalianWordDTO> italianWords) {
        this.italianWords = italianWords;
    }
}
