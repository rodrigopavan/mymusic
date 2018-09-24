package com.mymusic.service;

import com.mymusic.model.MusicaModel;
import com.mymusic.model.PlaylistModel;
import com.mymusic.model.UsuarioModel;

import java.util.List;

public interface PlaylistService {
  List<UsuarioModel> listarPlaylist(String usuario);

  PlaylistModel adicionarMusica(String playListId, List<MusicaModel> musicas);

  PlaylistModel removerMusica(String playListId, String musicaId);

}
