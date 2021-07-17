package com.antonioledezma.note.controller;

import com.antonioledezma.note.dto.NoteRequest;

import java.util.ArrayList;

import com.antonioledezma.note.dto.FolderRequest;
import com.antonioledezma.note.dto.FolderResponse;
import com.antonioledezma.note.model.FolderModel;
import com.antonioledezma.note.service.FolderService;

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
@RequestMapping(path="/folder")
public class FolderController {

  @Autowired
  FolderService folderService;

  @PostMapping(path={"/", ""})
  public Object create(@RequestBody FolderRequest request) {
    FolderModel folder = folderService.create(request.getTitle());
    FolderResponse response = new FolderResponse(folder.getId(), folder.getTitle());
    return response;
  }

  @GetMapping(path={"/{id}"})
  public Object find(@PathVariable(value="id") Long id) {
    FolderModel folder = folderService.find(id);
    FolderResponse response = new FolderResponse(folder.getId(), folder.getTitle());
    return response;
  }

  @GetMapping(path={"/", ""})
  public Object findAll() {
    ArrayList<FolderModel> folderList = folderService.findAll();
    ArrayList<FolderResponse> folderListResponse = new ArrayList<>();

    for(FolderModel folder: folderList) {
      folderListResponse.add(new FolderResponse(
        folder.getId(),
        folder.getTitle()
      ));
    }
    return folderListResponse;
  }

  @PatchMapping(path={"/{id}"})
  public Object update(@PathVariable(name="id") Long id, @RequestBody NoteRequest body) {
    FolderModel folder = folderService.update(id, body.getTitle());
    FolderResponse response = new FolderResponse(folder.getId(), folder.getTitle());
    return response;
  }

  @DeleteMapping(path={"/{id}"})
  public Object delete(@PathVariable(name="id") Long id) {
    folderService.delete(id);
    return Boolean.TRUE;
  }
}
