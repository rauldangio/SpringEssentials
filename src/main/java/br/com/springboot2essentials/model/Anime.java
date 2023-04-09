package br.com.springboot2essentials.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Anime {
	
	private Long id;
    private String name;
    
}
