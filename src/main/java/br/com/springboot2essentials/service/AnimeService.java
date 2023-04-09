package br.com.springboot2essentials.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.springboot2essentials.model.Anime;

@Service
public class AnimeService{
	public List<Anime> listAll(){
		return Arrays.asList(new Anime(1, "Berserk"), new Anime(2, "Vinland Saga"));
	}

}
