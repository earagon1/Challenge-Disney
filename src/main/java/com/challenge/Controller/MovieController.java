package com.challenge.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.Service.MovieService;

@RestController
@RequestMapping("movie")
public class MovieController {

	@Autowired
	private MovieService movieService;
}
