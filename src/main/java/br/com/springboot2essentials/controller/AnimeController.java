package br.com.springboot2essentials.controller;

import br.com.springboot2essentials.model.Anime;
import br.com.springboot2essentials.service.AnimeService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("animes")
@RestController
@AllArgsConstructor
public class AnimeController {

	
	private AnimeService animeService;
	
    @GetMapping
    private List<Anime> list(){

        return animeService.listAll();
    }

}
