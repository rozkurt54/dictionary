package com.rozkurt.dictionary.dataAccess;

import com.rozkurt.dictionary.model.WordEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EntryRepository extends JpaRepository<WordEntry, Long> {

    Page findAllByWordContainingIgnoreCase(String query, Pageable pageable);

    @Query("SELECT w from WordEntry w order by rand() limit 10")
    List<WordEntry> getWordsOfDay();

}
