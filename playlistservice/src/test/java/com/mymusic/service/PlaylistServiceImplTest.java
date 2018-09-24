package com.mymusic.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mymusic.model.MusicaModel;
import com.mymusic.model.PlaylistModel;
import com.mymusic.model.PlaylistMusicasModel;
import com.mymusic.repository.PlaylistRepository;
import com.mymusic.repository.UsuarioRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlaylistServiceImplTest {
  private static final String WILD_CARD_STRING = "anyString";

  private PlaylistServiceImpl playlistService;
  private PlaylistRepository playlistRepository;
  private UsuarioRepository usuarioRepository;

  @Before
  public void setUp() {
    this.playlistRepository = mock(PlaylistRepository.class);
    this.usuarioRepository = mock(UsuarioRepository.class);
    this.playlistService = new PlaylistServiceImpl(playlistRepository, usuarioRepository);
  }

  @Test
  public void testListarPlaylist() {
    playlistService.listarPlaylist(WILD_CARD_STRING);
    verify(usuarioRepository, atLeastOnce()).findByNome(WILD_CARD_STRING);
  }

  @Test
  public void testAdicionarMusica() {
    playlistService.adicionarMusica(WILD_CARD_STRING, mockMusicas());
    verify(playlistRepository, atLeastOnce()).save(any(PlaylistModel.class));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testLAdicionarMusicaInvalida() {
    when(playlistRepository.findById(anyString())).thenReturn(Optional.empty());
    playlistService.adicionarMusica(WILD_CARD_STRING, new ArrayList<>());
  }

  @Test
  public void testRemoverMusica() {
    mockMusicas();
    playlistService.removerMusica(WILD_CARD_STRING, WILD_CARD_STRING);
    verify(playlistRepository, atLeastOnce()).save(any(PlaylistModel.class));
  }

  private List<MusicaModel> mockMusicas(){
    final MusicaModel musicaModel = new MusicaModel();
    musicaModel.setId(WILD_CARD_STRING);

    final PlaylistModel playListModel = new PlaylistModel();
    final List<PlaylistMusicasModel> playlistMusicasModels = new ArrayList<>();
    playlistMusicasModels.add(new PlaylistMusicasModel(null, musicaModel));
    playListModel.setMusicas(playlistMusicasModels);

    final List<MusicaModel> musicaModelList = new ArrayList<>();
    musicaModelList.add(new MusicaModel());
    when(playlistRepository.findById(anyString())).thenReturn(Optional.of(playListModel));
    return musicaModelList;
  }
}
