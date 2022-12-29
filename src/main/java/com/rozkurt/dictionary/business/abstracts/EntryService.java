package com.rozkurt.dictionary.business.abstracts;

import com.rozkurt.dictionary.model.WordEntry;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EntryService {

    Page getAll(String q, int page, int size);

    Page searchWord(String q, int page, int size);

    List<WordEntry> getWordsOfDay();
}
