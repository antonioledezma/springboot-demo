package com.antonioledezma.note.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class NoteResponse {
  @JsonAlias("id")
  private Long id;

  @JsonAlias("title")
  private String title;

  @JsonAlias("text")
  private String text;

  public NoteResponse(Long id, String title, String text) {
    this.id = id;
    this.title = title;
    this.text = text;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
