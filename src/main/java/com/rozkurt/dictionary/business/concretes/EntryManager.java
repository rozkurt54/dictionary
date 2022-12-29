package com.rozkurt.dictionary.business.concretes;

import com.rozkurt.dictionary.business.abstracts.EntryService;
import com.rozkurt.dictionary.dataAccess.EntryRepository;
import com.rozkurt.dictionary.model.WordEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryManager implements EntryService {

    EntryRepository entryRepository;


    public EntryManager(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    @Override
    public Page<WordEntry> getAll(String q, int page, int size) {

        if(!q.isBlank()) {
         return entryRepository.findAllByWordContainingIgnoreCase(q, createPageAble(page, size));
        }

        return  entryRepository.findAll(createPageAble(page,size));

    }

    @Override
    public Page searchWord(String q, int page, int size) {
        return entryRepository.findAllByWordContainingIgnoreCase(q, createPageAble(page, size));
    }

    protected Pageable createPageAble(int page, int size) {
        return PageRequest.of(page, size);
    }

    @Override
    public List<WordEntry> getWordsOfDay() {
        return entryRepository.getWordsOfDay();
    }
}
