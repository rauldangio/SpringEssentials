package br.com.springboot2essentials.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.springboot2essentials.model.Anime;

@Service
public class AnimeService{
	private static List<Anime> animes;
	
	static {
		animes = new ArrayList<>(List.of(new Anime(1L, "Berserk"), new Anime(2L, "Vinland Saga")));
	}
	
	public List<Anime> listAll(){
		return animes;
	}

	public Anime listById(long id){
		return animes.stream()
				.filter(anime -> anime.getId().equals(id))
				.findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
	}

	public Anime save(Anime anime) {
		anime.setId(ThreadLocalRandom.current().nextLong(3, 10000));
		animes.add(anime);
		return anime;
	}
	
	
	public void deleteById(long id) {
		for(Anime anime: animes) {
			if(anime.getId() == id) {
				animes.remove(anime);
			}
		}
	}
}
