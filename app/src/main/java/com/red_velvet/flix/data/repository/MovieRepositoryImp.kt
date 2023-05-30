package com.red_velvet.flix.data.repository

import com.red_velvet.flix.data.local.database.MovieDao
import com.red_velvet.flix.data.remote.MoviesService
import com.red_velvet.flix.data.remote.dtos.PaginationDto
import com.red_velvet.flix.data.remote.dtos.movie.MovieDetailsDto
import com.red_velvet.flix.data.remote.dtos.movie.MovieDto
import com.red_velvet.flix.data.remote.dtos.review.ReviewDto
import com.red_velvet.flix.data.remote.dtos.trailer.TrailersDto
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    private val moviesService: MoviesService,
    private val movieDao: MovieDao
) :MovieRepository{
    override suspend fun insertPopularMovie() {
       val popularMovies = moviesService.getPopularMovies().body()
        popularMovies?.items
    }

    override suspend fun insertTopRatedMovie() {
       val topRatedMovie = moviesService.getTopRatedMovies().body()
        topRatedMovie?.items
    }

    override suspend fun insertUpcomingMovie() {
        val upcomingMovie = moviesService.getUpcomingMovies().body()
        upcomingMovie?.items

    }

    override suspend fun insertNowPlayingMovie() {
        val nowPlayingMovie = moviesService.getNowPlayingMovies().body()
        nowPlayingMovie?.items
    }

    override suspend fun getPopularMovies(
        page: Int,
        region: String?,
        language: String
    ): List<MovieDto?> {
        TODO("Not yet implemented")
    }

    override suspend fun getUpcomingMovies(
        page: Int,
        region: String?,
        language: String
    ): PaginationDto<MovieDto>? {
       return moviesService.getPopularMovies(page, region, language).body()
    }

    override suspend fun getNowPlayingMovies(
        page: Int,
        region: String?,
        language: String
    ): List<MovieDto?> {
        TODO("Not yet implemented")
    }

    override suspend fun getTopRatedMovies(
        page: Int,
        region: String?,
        language: String
    ): List<MovieDto?> {
        TODO("Not yet implemented")
    }
    override suspend fun getMovieDetails(movieId: Int): List<MovieDetailsDto?> {
        TODO("Not yet implemented")
    }

    override suspend fun getLatestMovie(movieId: Int): List<MovieDto?> {
        TODO("Not yet implemented")
    }

    override suspend fun getLatestMovie(): List<MovieDto?> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieKeywords(movieId: Int): List<MovieDto?> {
        TODO("Not yet implemented")
    }

    override suspend fun getSimilarMovies(
        movieId: Int,
        page: Int,
        language: String
    ): List<MovieDto?> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieTrailers(movieId: Int, language: String): List<TrailersDto?> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieRecommendations(
        movieId: Int,
        page: Int,
        language: String
    ): List<MovieDto?> {
        TODO("Not yet implemented")
    }

    override suspend fun rateMovie(movieId: Int, rating: Double) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMovieRating(movieId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieReviews(
        movieId: Int,
        page: Int,
        language: String
    ): List<ReviewDto?> {
        TODO("Not yet implemented")
    }

}