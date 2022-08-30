package com.challenge.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.Service.GenreService;

@RestController
@RequestMapping("genre")
public class GenreController {
	
	@Autowired
	private GenreService genreservice;

}
