package com.antonioledezma.note.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="note")
public class NoteModel {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  @Column(name="title")
  private String title;

  @Column(name="text")
  private String text;

  @JoinColumn(name="folder_id")
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private FolderModel folder;

  protected NoteModel() {
  }

  public NoteModel(String title, String text) {
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

  public FolderModel getFolder() {
    return folder;
  }

  public void setFolder(FolderModel folder) {
    this.folder = folder;
  }
}
