package com.mymusic.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UsuarioModelTest {
  private static final String WILD_CARD_STRING = "anyString";
  private UsuarioModel usuarioModel;

  @Before
  public void setUp() {
    this.usuarioModel = new UsuarioModel();
  }

  @Test
  public void testId(){
    this.usuarioModel.setId(WILD_CARD_STRING);
    assertEquals(this.usuarioModel.getId(),WILD_CARD_STRING);
  }

  @Test
  public void testNome(){
    this.usuarioModel.setNome(WILD_CARD_STRING);
    assertEquals(this.usuarioModel.getNome(),WILD_CARD_STRING);
  }

  @Test
  public void testPlaylist(){
    final PlaylistModel playlistModel = new PlaylistModel();
    this.usuarioModel.setPlaylist(playlistModel);
    assertEquals(this.usuarioModel.getPlaylist(),playlistModel);
  }
}
