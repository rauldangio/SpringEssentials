package br.com.springboot2essentials.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.springboot2essentials.model.Anime;

@Service
public class AnimeService{
	private List<Anime> animes = Arrays.asList(new Anime(1L, "Berserk"), new Anime(2L, "Vinland Saga"));
	
	public List<Anime> listAll(){
		return animes;
	}

	public Anime listById(long id){
		return animes.stream()
				.filter(anime -> anime.getId().equals(id))
				.findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
	}
}
