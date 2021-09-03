package com.learn.moviecruiser.dao;

import java.util.List;

import com.learn.moviecruiser.exception.FavoritesEmptyException;
import com.learn.moviecruiser.model.Movie;



public interface FavoriteDao {
	
	public void addFavoritesMovie(long userId, long movieId);

	public List<Movie> getAllFavoritesMovies(long userId) throws FavoritesEmptyException;

	public void removeFavoritesMovie(long userId, long movieId);
}