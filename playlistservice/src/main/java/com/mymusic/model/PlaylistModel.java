package com.mymusic.model;

import org.hibernate.annotations.GenericGenerator;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "playlists")
public class PlaylistModel {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  private String id;

  @OneToMany(mappedBy = "playlist",fetch = FetchType.LAZY)
  private List<PlaylistMusicasModel> musicas;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<PlaylistMusicasModel> getMusicas() {
    return musicas;
  }

  public void setMusicas(List<PlaylistMusicasModel> musicas) {
    this.musicas = musicas;
  }
}
