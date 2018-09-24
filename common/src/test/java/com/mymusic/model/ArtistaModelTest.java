package com.mymusic.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ArtistaModelTest {
  private static final String WILD_CARD_STRING = "anyString";

  private ArtistaModel artistaModel;

  @Before
  public void setUp(){
    this.artistaModel = new ArtistaModel();
  }

  @Test
  public void testId(){
    this.artistaModel.setId(WILD_CARD_STRING);
    assertEquals(this.artistaModel.getId(),WILD_CARD_STRING);
  }

  @Test
  public void testNome(){
    this.artistaModel.setNome(WILD_CARD_STRING);
    assertEquals(this.artistaModel.getNome(),WILD_CARD_STRING);
  }

}
