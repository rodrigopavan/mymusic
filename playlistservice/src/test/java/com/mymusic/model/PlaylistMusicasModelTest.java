package com.mymusic.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PlaylistMusicasModelTest {
  private static final String WILD_CARD_STRING = "anyString";

  private PlaylistMusicasModel playlistMusicasModel;

  @Before
  public void setUp() {
    this.playlistMusicasModel = new PlaylistMusicasModel();
  }

  @Test
  public void testId() {
    this.playlistMusicasModel.setId(WILD_CARD_STRING);
    assertEquals(this.playlistMusicasModel.getId(), WILD_CARD_STRING);
  }

  @Test
  public void testPlaylist() {
    final PlaylistModel playlistModel = new PlaylistModel();
    this.playlistMusicasModel.setPlaylist(playlistModel);
    assertEquals(this.playlistMusicasModel.getPlaylist(), playlistModel);
  }

  @Test
  public void testMusica() {
    final MusicaModel musicaModel = new MusicaModel();
    this.playlistMusicasModel.setMusica(musicaModel);
    assertEquals(this.playlistMusicasModel.getMusica(), musicaModel);
  }
}
