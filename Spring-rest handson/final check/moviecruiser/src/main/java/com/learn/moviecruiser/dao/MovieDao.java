package com.learn.moviecruiser.dao;

import java.util.List;


import com.learn.moviecruiser.model.Movie;
public interface MovieDao {
	public List<Movie> getMovieListAdmin();

	public List<Movie> getMovieListCustomer();

	public void modifyMovie(Movie movie);

	public Movie getMovie(long movieId);

	
}
