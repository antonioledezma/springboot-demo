package com.antonioledezma.note.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class FolderRequest {
  @JsonAlias("title")
  private String title;
  
  public FolderRequest(String title) {
    this.title = title;
  }

  protected FolderRequest() {
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
