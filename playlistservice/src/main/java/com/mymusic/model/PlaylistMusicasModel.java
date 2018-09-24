package com.mymusic.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "playlistmusicas")
public class PlaylistMusicasModel {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  public String id;

  @ManyToOne
  @JoinColumn(name = "playlistId")
  private PlaylistModel playlist;

  @ManyToOne
  @JoinColumn(name = "musicaId")
  private MusicaModel musica;

  public PlaylistMusicasModel(){

  }

  public PlaylistMusicasModel(PlaylistModel playlist,MusicaModel musica){
    this.playlist = playlist;
    this.musica = musica;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PlaylistModel getPlaylist() {
    return playlist;
  }

  public void setPlaylist(PlaylistModel playlist) {
    this.playlist = playlist;
  }

  public MusicaModel getMusica() {
    return musica;
  }

  public void setMusica(MusicaModel musica) {
    this.musica = musica;
  }
}
