package com.mymusic.service;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.mymusic.repository.MusicaRepository;
import org.junit.Before;
import org.junit.Test;

public class MusicaServiceImplTest {

  private MusicaServiceImpl musicaService;
  private MusicaRepository musicaRepository;

  @Before
  public void setUp() {
    this.musicaRepository = mock(MusicaRepository.class);
    this.musicaService = new MusicaServiceImpl(musicaRepository);
  }

  @Test
  public void testListarMusicas(){
    musicaService.listarMusicas("ABCD");
    verify(musicaRepository,atLeastOnce()).findAll();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testListarMusicaWithError(){
    musicaService.listarMusicas("ABC");
  }

}
