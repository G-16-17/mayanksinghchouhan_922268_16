package com.cognizant.moviecruiser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.moviecruiser.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	// List<Movie> findByActiveTrue();
	@Query(value = "select * from movie where active=true and date_of_launch<=CURDATE()", nativeQuery = true)
	public List<Movie> findByActiveandDateOfLaunch();
}
