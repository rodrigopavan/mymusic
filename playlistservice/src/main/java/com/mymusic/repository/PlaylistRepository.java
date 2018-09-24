package com.mymusic.repository;

import com.mymusic.model.PlaylistModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends CrudRepository<PlaylistModel,String> {

}
