package com.mymusic.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MusicaModelTest {
  private static final String WILD_CARD_STRING = "anyString";

  private MusicaModel musicaModel;

  @Before
  public void setUp(){
    this.musicaModel = new MusicaModel();
  }

  @Test
  public void testId(){
    this.musicaModel.setId(WILD_CARD_STRING);
    assertEquals(this.musicaModel.getId(),WILD_CARD_STRING);
  }

  @Test
  public void testNome(){
    this.musicaModel.setNome(WILD_CARD_STRING);
    assertEquals(this.musicaModel.getNome(),WILD_CARD_STRING);
  }

  @Test
  public void testArtista(){
    final ArtistaModel artista = new ArtistaModel();
    artista.setId(WILD_CARD_STRING);
    this.musicaModel.setArtista(artista);
    assertEquals(this.musicaModel.getArtista(),artista);
  }


}
