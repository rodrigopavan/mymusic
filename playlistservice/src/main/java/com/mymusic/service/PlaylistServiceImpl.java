package com.mymusic.service;

import com.mymusic.model.MusicaModel;
import com.mymusic.model.PlaylistModel;
import com.mymusic.model.PlaylistMusicasModel;
import com.mymusic.model.UsuarioModel;
import com.mymusic.repository.PlaylistRepository;
import com.mymusic.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService {

  private final PlaylistRepository playlistRepository;
  private final UsuarioRepository usuarioRepository;

  public PlaylistServiceImpl(final PlaylistRepository playlistRepository,
      final UsuarioRepository usuarioRepository) {
    this.playlistRepository = playlistRepository;
    this.usuarioRepository = usuarioRepository;
  }

  @Override
  public List<UsuarioModel> listarPlaylist(final String usuario) {
    return usuarioRepository.findByNome(usuario);
  }

  @Override
  public PlaylistModel adicionarMusica(final String playlistId, final List<MusicaModel> musicas) {
    final PlaylistModel playlist = obterPlaylist(playlistId);
    musicas.forEach(m -> playlist.getMusicas().add(new PlaylistMusicasModel(playlist, m)));
    return playlistRepository.save(playlist);
  }

  @Override
  public PlaylistModel removerMusica(String playListId, String musicaId) {
    final PlaylistModel playlist = obterPlaylist(playListId);
    playlist.getMusicas().removeIf(p -> p.getMusica().getId().equals(musicaId));
    return playlistRepository.save(playlist);
  }

  private PlaylistModel obterPlaylist(final String playlistId) {
    final Optional<PlaylistModel> playlistOptional = playlistRepository.findById(playlistId);
    final PlaylistModel playlist = playlistOptional.orElseThrow(
        () -> new IllegalArgumentException(
            String.format("Playlist %s não encontrada", playlistId)));
    return playlist;
  }
}
