package com.mymusic.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PlaylistModelTest {
  private static final String WILD_CARD_STRING = "anyString";

  private PlaylistModel playlistModel;

  @Before
  public void setUp()  {
    this.playlistModel = new PlaylistModel();
  }

  @Test
  public void testId(){
    this.playlistModel.setId(WILD_CARD_STRING);
    assertEquals(this.playlistModel.getId(),WILD_CARD_STRING);
  }

  @Test
  public void testMusicas(){
    final List<PlaylistMusicasModel> playlistMusicasModel = new ArrayList<>();
    this.playlistModel.setMusicas(playlistMusicasModel);
    assertEquals(this.playlistModel.getMusicas(),playlistMusicasModel);
  }
}

