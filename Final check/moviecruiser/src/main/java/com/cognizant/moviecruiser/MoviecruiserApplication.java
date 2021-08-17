package com.cognizant.moviecruiser;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;
import com.cognizant.moviecruiser.util.DateUtil;

@SpringBootApplication
public class MoviecruiserApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(MoviecruiserApplication.class);
	private static MovieService movieService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MoviecruiserApplication.class, args);
		movieService = context.getBean(MovieService.class);
		LOGGER.info("............Start...........");
		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testGetMovie(2);
		testModifyMovie();
		LOGGER.info("............End...........");
	}

	private static void testGetMovieListAdmin() {
		LOGGER.info("////////Start////////");
		List<Movie> list = movieService.getMenuListAdmin();
		System.out.println(String.format("%-3s %-20s %-15s %-8s %-30s %-18s " + "%-15s", "Id", "Title", "Box Office",
				"Active", "Date of Launch", "Genre", "Has Teaser"));
		System.out.println("****************************************");
		list.forEach(e -> System.out.println(e));
		LOGGER.info("////////End///////");
	}

	private static void testGetMovieListCustomer() {
		LOGGER.info("*******Start******");
		List<Movie> list = movieService.getMovieListCustomer();
		System.out.println(String.format("%-3s %-20s %-15s %-8s %-30s %-18s %-15s", "Id", "Title", "Box Office",
				"Active", "Date of Launch", "Genre", "Has Teaser"));
		list.forEach(e -> System.out.println(e));
		LOGGER.info("******End*********");
	}

	private static void testModifyMovie() {
		LOGGER.info("/////////Start/////////");
		Movie movie = new Movie(1, "Avengers: Infinity War ", "$2,514,512,900", true,
				DateUtil.convertToDate("15/09/2022"), "Superhero", false);
		movieService.modifyMovie(movie);
		LOGGER.info("//////End///////");
	}

	private static void testGetMovie(long id) {
		LOGGER.info("..........Start............");
		Movie update = movieService.getMovie(id);
		System.out.println(String.format("%-3s %-20s %-15s %-8s %-30s %-18s" + " %-15s", "Id", "Title", "Box Office",
				"Active", "Date of Launch", "Genre", "Has Teaser"));
		System.out.println(update);
		LOGGER.info("End.......");

	}

}
