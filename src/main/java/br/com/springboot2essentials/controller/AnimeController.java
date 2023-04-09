package br.com.springboot2essentials.controller;

import br.com.springboot2essentials.model.Anime;
import br.com.springboot2essentials.service.AnimeService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("animes")
@RestController
@AllArgsConstructor
public class AnimeController {

	
	private AnimeService animeService;
	
    @GetMapping
    private ResponseEntity<List<Anime>> list(){

        return new ResponseEntity<List<Anime>>(animeService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    private ResponseEntity<Anime> findById(@PathVariable int id){
        return new ResponseEntity<Anime>(animeService.listById(id), HttpStatus.OK);
    }
}
