package com.mymusic.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.junit.Before;
import org.junit.Test;

public class PlaylistControllerAdviceTest {
  private static final String WILD_CARD_STRING = "anyString";
  private PlaylistControllerAdvice playlistControllerAdvice;

  @Before
  public void setUp() {
    this.playlistControllerAdvice = new PlaylistControllerAdvice();
  }

  @Test
  public void testHandleException() {
    assertEquals(
        playlistControllerAdvice.handleException(new Exception(WILD_CARD_STRING)).getStatusCode(),
        BAD_REQUEST);
  }
}
