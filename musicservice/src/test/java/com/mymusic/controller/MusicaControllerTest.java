package com.mymusic.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import com.mymusic.model.MusicaModel;
import com.mymusic.service.MusicaService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MusicaControllerTest {
  private static final String WILD_CARD_STRING = "anyString";

  private MusicaController musicaController;
  private MusicaService musicaService;

  @Before
  public void setUp() {
    this.musicaService = mock(MusicaService.class);
    this.musicaController = new MusicaController(musicaService);
  }

  @Test
  public void testListarMusicasWithContent() {
    final List<MusicaModel> musicas = new ArrayList<>();
    musicas.add(new MusicaModel());
    when(this.musicaService.listarMusicas(anyString())).thenReturn(musicas);
    assertEquals(this.musicaController.listarMusicas(WILD_CARD_STRING).getStatusCode(), OK);
  }

  @Test
  public void testListarMusicasWithoutContent() {
    when(this.musicaService.listarMusicas(anyString())).thenReturn(new ArrayList<>());
    assertEquals(this.musicaController.listarMusicas(WILD_CARD_STRING).getStatusCode(), NO_CONTENT);
  }
}
