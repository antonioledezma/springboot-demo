package com.antonioledezma.note.repository;

import com.antonioledezma.note.model.NoteModel;

import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<NoteModel, Long> {
  
}
