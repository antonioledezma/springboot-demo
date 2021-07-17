package com.antonioledezma.note.controller;

import com.antonioledezma.note.dto.NoteRequest;
import com.antonioledezma.note.dto.NoteResponse;

import java.util.ArrayList;

import com.antonioledezma.note.model.NoteModel;
import com.antonioledezma.note.service.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/note")
public class NoteController {
  @Autowired
  NoteService noteService;

  @PostMapping(path={"/", ""})
  public Object create(@RequestBody NoteRequest request) {
    NoteModel note = noteService.create(
      request.getTitle(),
      request.getText()
    );
    NoteResponse response = new NoteResponse(
      note.getId(), 
      note.getTitle(), 
      note.getText()
    );
    return response;
  }

  @GetMapping(path={"/{id}"})
  public Object find(@PathVariable(value="id") Long id) {
    NoteModel note = noteService.find(id);
    NoteResponse response = new NoteResponse(
      note.getId(), 
      note.getTitle(), 
      note.getText()
    );
    return response;
  }

  @GetMapping(path={"/", ""})
  public Object findAll() {
    ArrayList<NoteModel> noteList = noteService.findAll();
    ArrayList<NoteResponse> noteListResponse = new ArrayList<>();

    for(NoteModel note: noteList) {
      noteListResponse.add(new NoteResponse(
        note.getId(),
        note.getTitle(),
        note.getText()
      ));
    }

    return noteListResponse;
  }

  @PatchMapping(path={"/{id}"})
  public Object update(@PathVariable(name="id") Long id, @RequestBody NoteRequest body) {
    NoteModel note = noteService.update(id, body.getTitle(), body.getText());
    NoteResponse response = new NoteResponse(
      note.getId(), 
      note.getTitle(), 
      note.getText()
    );
    return response;
  }

  @DeleteMapping(path={"/{id}"})
  public Object delete(@PathVariable(name="id") Long id) {
    noteService.delete(id);
    return Boolean.TRUE;
  }
}
