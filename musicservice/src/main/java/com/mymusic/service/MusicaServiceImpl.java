package com.mymusic.service;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.lang.String.format;

import com.mymusic.model.MusicaModel;
import com.mymusic.repository.MusicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaServiceImpl implements MusicaService {
  private static final int LIMITE_FILTRO = 3;

  private final MusicaRepository musicaRepository;

  public MusicaServiceImpl(final MusicaRepository musicaRepository) {
    this.musicaRepository = musicaRepository;
  }

  @Override
  public List<MusicaModel> listarMusicas(final String filtro) {
    checkFiltroLimit(filtro);
    return musicaRepository.findAll();
  }

  private void checkFiltroLimit(final String filtro) {
    if (!isNullOrEmpty(filtro)) {
      if (filtro.length() <= LIMITE_FILTRO) {
        throw new IllegalArgumentException(
            format("Filtro deve ter mais do que %d caracteres", LIMITE_FILTRO));

      }
    }
  }
}
