package com.take.movies.dao;

import com.take.movies.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query("select m from Movie m where m.category like :genre")
    List<Movie> getMoviesByGenre(@Param("genre") String genre);

}