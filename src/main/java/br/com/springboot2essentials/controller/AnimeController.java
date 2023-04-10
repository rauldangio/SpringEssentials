package br.com.springboot2essentials.controller;

import br.com.springboot2essentials.model.Anime;
import br.com.springboot2essentials.service.AnimeService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    private ResponseEntity<Anime> findById(@PathVariable long id){
        return new ResponseEntity<Anime>(animeService.listById(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody Anime anime){
    	return new ResponseEntity<Anime>(animeService.save(anime), HttpStatus.CREATED);
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
    	animeService.deleteById(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Anime anime){
    	animeService.replace(anime);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
