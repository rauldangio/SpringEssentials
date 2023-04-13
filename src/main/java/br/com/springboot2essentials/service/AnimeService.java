package br.com.springboot2essentials.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.springboot2essentials.model.Anime;
import br.com.springboot2essentials.repository.AnimeRepository;
import br.com.springboot2essentials.requests.AnimePostRequestBody;
import br.com.springboot2essentials.requests.AnimePutRequestBody;

@Service
public class AnimeService{
	@Autowired
	private AnimeRepository animeRepository;
	
	public List<Anime> listAll(){
		return animeRepository.findAll();
	}

	public Anime listByIdOrElseThrowNotFound(long id){
		return animeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public Anime save(AnimePostRequestBody animePostRequestBody) {
		Anime anime = Anime.builder().name(animePostRequestBody.getName()).build();
		return animeRepository.save(anime);
	}
	
	
	public void deleteById(long id) {
		animeRepository.delete(listByIdOrElseThrowNotFound(id));
	}
	
	public void replace(AnimePutRequestBody animePutRequestBody){
		Anime animeInTheDataBase = listByIdOrElseThrowNotFound(animePutRequestBody.getId());
		Anime anime = Anime.builder()
							.id(animeInTheDataBase.getId())
							.name(animePutRequestBody.getName())
							.build();
		animeRepository.save(anime);
		
	}
}
