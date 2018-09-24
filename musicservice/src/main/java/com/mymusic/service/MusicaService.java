package com.mymusic.service;

import com.mymusic.model.MusicaModel;

import java.util.List;

public interface MusicaService {
  List<MusicaModel> listarMusicas(String filtro);
}
