package com.rozkurt.dictionary.controller;


import com.rozkurt.dictionary.business.abstracts.EntryService;
import com.rozkurt.dictionary.model.WordEntry;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class EntryController {

    EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping
    public Page getAll(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "100") int size,
                       @RequestParam(defaultValue = "", name = "q") String query
    ) {
        return entryService.getAll(query, page, size);
    }

    @GetMapping("/wordsofday")
    public List<WordEntry> getWordsOfDay() {
        return entryService.getWordsOfDay();
    }


}
