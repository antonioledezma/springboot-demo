package com.antonioledezma.note.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class NoteRequest {
  @JsonAlias("title")
  private String title;

  @JsonAlias("text")
  private String text;
  
  public NoteRequest(String title, String text) {
    this.title = title;
    this.text = text;
  }

  protected NoteRequest() {
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
