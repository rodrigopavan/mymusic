package com.mymusic.repository;

import com.mymusic.model.UsuarioModel;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UsuarioRepository extends PagingAndSortingRepository<UsuarioModel,String> {
  List<UsuarioModel> findByNome(String nome);
}
