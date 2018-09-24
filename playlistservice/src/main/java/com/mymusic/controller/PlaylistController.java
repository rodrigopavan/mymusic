package com.mymusic.controller;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

import com.mymusic.model.MusicaModel;
import com.mymusic.model.PlaylistModel;
import com.mymusic.model.UsuarioModel;
import com.mymusic.service.PlaylistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {

  private final PlaylistService playlistService;

  public PlaylistController(final PlaylistService playlistService) {
    this.playlistService = playlistService;
  }

  @GetMapping
  public ResponseEntity<List<UsuarioModel>> listarPlaylist(@RequestParam final String usuario) {
    final List<UsuarioModel> playlist = playlistService.listarPlaylist(usuario);
    if (playlist.isEmpty()) {
      return noContent().build();
    }
    return ok(playlist);
  }

  @PutMapping("/{playlistId}/musicas")
  public ResponseEntity<PlaylistModel> adicionarMusica(@PathVariable(name = "playlistId") final String playlistId,
      @RequestBody final List<MusicaModel> musicas) {
    PlaylistModel playlist = playlistService.adicionarMusica(playlistId, musicas);
    return ok(playlist);
  }

  @DeleteMapping("/{playlistId}/musicas/{musicaId}")
  public ResponseEntity<PlaylistModel> removerMusica(@PathVariable(name = "playlistId") final String playlistId,
      @PathVariable(name = "musicaId") final String musicaId) {
    PlaylistModel playlist = playlistService.removerMusica(playlistId, musicaId);
    return ok(playlist);
  }
}
