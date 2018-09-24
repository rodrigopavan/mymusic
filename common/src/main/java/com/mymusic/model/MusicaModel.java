package com.mymusic.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "musicas")
public class MusicaModel {

  @Id
  private String id;
  private String nome;

  @ManyToOne
  @JoinColumn(name = "artistaId")
  private ArtistaModel artista;

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

  public ArtistaModel getArtista() {
    return artista;
  }

  public void setArtista(ArtistaModel artista) {
    this.artista = artista;
  }
}
