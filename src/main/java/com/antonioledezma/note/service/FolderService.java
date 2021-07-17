package com.antonioledezma.note.service;

import java.util.ArrayList;
import java.util.Optional;

import com.antonioledezma.note.exception.NoSuchFountException;
import com.antonioledezma.note.model.FolderModel;
import com.antonioledezma.note.repository.FolderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FolderService {
  @Autowired
  FolderRepository folderRepository;

  public FolderModel create(String title) {
    FolderModel Folder = new FolderModel(title);
    return folderRepository.save(Folder);
  }

  public FolderModel find(Long id) {
    Optional<FolderModel> optional = folderRepository.findById(id.longValue());
    if(optional.isPresent()) {
      return optional.get();
    }
    throw new NoSuchFountException(id);
  }

  public ArrayList<FolderModel> findAll() {
    ArrayList<FolderModel> list = new ArrayList<>();
    
    for (FolderModel folder : folderRepository.findAll()) {
      list.add(folder);
    }

    return list;
  }

  public FolderModel update(Long id, String title) {
    FolderModel folder = this.find(id);
    folder.setTitle(title);
    return folderRepository.save(folder);
  }

  public void delete(Long id) {
    this.find(id);                                // validar que existe.
    folderRepository.deleteById(id);
  }
}
