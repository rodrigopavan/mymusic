package com.mymusic.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import com.mymusic.model.UsuarioModel;
import com.mymusic.service.PlaylistService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PlaylistControllerTest {
  private static final String WILD_CARD_STRING = "anyString";

  private PlaylistController playlistController;
  private PlaylistService playlistService;

  @Before
  public void setUp() {
    this.playlistService = mock(PlaylistService.class);
    this.playlistController = new PlaylistController(playlistService);
  }

  @Test
  public void testListarPlaylistWithContent() {
    final List<UsuarioModel> usuarios = new ArrayList<>();
    usuarios.add(new UsuarioModel());
    when(this.playlistService.listarPlaylist(anyString())).thenReturn(usuarios);
    assertEquals(this.playlistController.listarPlaylist(WILD_CARD_STRING).getStatusCode(), OK);
  }

  @Test
  public void testListarPlaylistWithoutContent() {
    when(this.playlistService.listarPlaylist(anyString())).thenReturn(new ArrayList<>());
    assertEquals(this.playlistController.listarPlaylist(WILD_CARD_STRING).getStatusCode(),
        NO_CONTENT);
  }

  @Test
  public void testAdicionarMusica() {
    this.playlistController.adicionarMusica(WILD_CARD_STRING, new ArrayList<>());
    verify(this.playlistService, atLeastOnce()).adicionarMusica(anyString(), anyList());
  }

  @Test
  public void testRemoverMusica() {
    this.playlistController.removerMusica(WILD_CARD_STRING, WILD_CARD_STRING);
    verify(this.playlistService, atLeastOnce()).removerMusica(anyString(), anyString());
  }
}
