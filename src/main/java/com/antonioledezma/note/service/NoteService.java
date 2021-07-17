package com.antonioledezma.note.service;

import java.util.ArrayList;
import java.util.Optional;

import com.antonioledezma.note.model.NoteModel;
import com.antonioledezma.note.repository.NoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antonioledezma.note.exception.NoSuchFountException;

@Service
public class NoteService {
  @Autowired
  NoteRepository noteRepository;

  public NoteModel create(String title, String text) {
    NoteModel note = new NoteModel(title, text);
    return noteRepository.save(note);
  }

  public NoteModel find(Long id) {
    Optional<NoteModel> optional = noteRepository.findById(id.longValue());
    if(optional.isPresent()) {
      return optional.get();
    }
    throw new NoSuchFountException(id);
  }

  public ArrayList<NoteModel> findAll() {
    ArrayList<NoteModel> list = new ArrayList<>();
    
    for (NoteModel note : noteRepository.findAll()) {
      list.add(note);
    }

    return list;
  }

  public NoteModel update(Long id, String title, String text) {
    NoteModel note = this.find(id);
    note.setTitle(title);
    note.setText(text);
    return noteRepository.save(note);
  }

  public void delete(Long id) {
    this.find(id);                                // validar que existe.
    noteRepository.deleteById(id);
  }
}
