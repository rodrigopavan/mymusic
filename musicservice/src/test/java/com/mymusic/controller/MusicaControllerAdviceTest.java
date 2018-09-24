package com.mymusic.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.junit.Before;
import org.junit.Test;

public class MusicaControllerAdviceTest {
  private static final String WILD_CARD_STRING = "anyString";
  private MusicaControllerAdvice musicaControllerAdvice;

  @Before
  public void setUp() {
    this.musicaControllerAdvice = new MusicaControllerAdvice();
  }

  @Test
  public void testHandleException() {
    assertEquals(
        musicaControllerAdvice.handleException(new Exception(WILD_CARD_STRING)).getStatusCode(),
        BAD_REQUEST);
  }
}
