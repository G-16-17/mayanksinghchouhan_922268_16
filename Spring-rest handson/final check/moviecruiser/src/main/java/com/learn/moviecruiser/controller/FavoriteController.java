package com.learn.moviecruiser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.moviecruiser.exception.FavoritesEmptyException;
import com.learn.moviecruiser.model.Movie;
import com.learn.moviecruiser.services.FavoritesService;



@RestController
@RequestMapping("/favorites")
public class FavoriteController {
	
	@Autowired
	FavoritesService service;
	
	@PostMapping("/{userId}/{movieId}")
	public void addFavoritesMovie(@PathVariable long userId, @PathVariable long movieId)
	{
		service.addFavoritesMovie(userId, movieId);
	}
	
	@GetMapping("/{userId}")
	public List<Movie> getAllFavoriteMovies(@PathVariable long userId) throws FavoritesEmptyException
	{
		return service.getAllFavoriteMovies(userId);
	}
	
	@DeleteMapping("/{userId}/{movieId}")
	public void deleteFavoriteMovie(@PathVariable long userId, @PathVariable long movieId)
	{
		service.removeFavoriteMovie(userId, movieId);
	}

}