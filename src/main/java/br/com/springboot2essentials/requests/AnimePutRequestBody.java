package br.com.springboot2essentials.requests;

import lombok.Data;

@Data
public class AnimePutRequestBody {
	private long id;
	private String name;
}
