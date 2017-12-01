package com.thebtnco.mybatis.mapper;

import com.thebtnco.persistence.domain.Movie;

import java.util.List;

/**
 * Created by NaNi on 11/29/2017.
 */
@SuppressWarnings("DefaultFileTemplate")
public interface MovieMapper {

    List<Movie> getMovieList(/*@Param("id") Long id*/);

}
