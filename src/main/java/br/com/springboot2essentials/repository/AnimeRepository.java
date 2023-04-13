package br.com.springboot2essentials.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springboot2essentials.model.Anime;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long>{
	 
}
