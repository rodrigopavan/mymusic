package com.mymusic.controller;

import static org.springframework.http.ResponseEntity.*;

import com.mymusic.model.MusicaModel;
import com.mymusic.service.MusicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/musicas")
public class MusicaController {

  private final MusicaService musicaService;

  public MusicaController(final MusicaService musicaService) {
    this.musicaService = musicaService;
  }

  @GetMapping
  public ResponseEntity<List<MusicaModel>> listarMusicas(
      @RequestParam(required = false) final String filtro) {
    final List<MusicaModel> musicas = musicaService.listarMusicas(filtro);
    if (musicas.isEmpty()) {
      return noContent().build();
    }
    return ok(musicas);
  }
}
