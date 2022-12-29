package com.rozkurt.dictionary.model;


import jakarta.persistence.*;

@Entity
@Table(name = "wordentry")
public class WordEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String word;

    @Column(name = "wordtype")
    private String wordType;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String definition;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWordType() {
        return wordType;
    }

    public void setWordType(String wordType) {
        this.wordType = wordType;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
