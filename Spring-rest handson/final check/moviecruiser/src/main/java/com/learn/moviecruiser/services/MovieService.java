package com.learn.moviecruiser.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.moviecruiser.dao.MovieDao;
import com.learn.moviecruiser.model.Movie;


@Service
public class MovieService {

	@Autowired
	MovieDao movieDao;
	
	public List<Movie> getMovieListAdmin()
	{
		return movieDao.getMovieListAdmin();
	}
	
	public List<Movie> getMovieListCustomer()
	{
		return movieDao.getMovieListCustomer();
	}
	
	public Movie getMovie(long movieId)
	{
		return movieDao.getMovie(movieId);
	}
	
	public void modifyMovie(Movie movie)
	{
		movieDao.modifyMovie(movie);
	}

}