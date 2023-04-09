package br.com.springboot2essentials.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.springboot2essentials.model.Anime;

@Repository
public interface AnimeRepository {
	
	public List<Anime> listAll();
}
