package com.mymusic.repository;

import com.mymusic.model.ArtistaModel;
import com.mymusic.model.MusicaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicaRepository extends CrudRepository<MusicaModel,String> {
  List<MusicaModel> findByArtistaOrNome(ArtistaModel artista,String nome);
  @Override
  List<MusicaModel> findAll();
}
