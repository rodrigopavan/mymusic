package com.mymusic.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {

  @Id
  private String id;
  private String nome;

  @ManyToOne
  @JoinColumn(name = "playlistId")
  private PlaylistModel playlist;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public PlaylistModel getPlaylist() {
    return playlist;
  }

  public void setPlaylist(PlaylistModel playlist) {
    this.playlist = playlist;
  }
}
