package com.antonioledezma.note.repository;

import com.antonioledezma.note.model.FolderModel;

import org.springframework.data.repository.CrudRepository;

public interface FolderRepository extends CrudRepository<FolderModel, Long> {
  
}
