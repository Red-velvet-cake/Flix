package com.red_velvet.flix.data.repository


import com.red_velvet.flix.data.remote.dtos.PaginationDto
import com.red_velvet.flix.data.remote.dtos.movie.MovieDetailsDto
import com.red_velvet.flix.data.remote.dtos.movie.MovieDto
import com.red_velvet.flix.data.remote.dtos.review.ReviewDto
import com.red_velvet.flix.data.remote.dtos.trailer.TrailersDto


interface MovieRepository {

    suspend fun insertPopularMovie()

    suspend fun insertTopRatedMovie()

    suspend fun insertUpcomingMovie()

    suspend fun insertNowPlayingMovie()

    suspend fun getPopularMovies(page: Int, region: String?, language: String): List<MovieDto?>

    suspend fun getUpcomingMovies(page: Int, region: String?, language: String): PaginationDto<MovieDto>?

    suspend fun getNowPlayingMovies(page: Int, region: String?, language: String): List<MovieDto?>

    suspend fun getTopRatedMovies(page: Int = 1, region: String?, language: String): List<MovieDto?>

    suspend fun getMovieDetails(movieId: Int): List<MovieDetailsDto?>

    suspend fun getLatestMovie(movieId: Int): List<MovieDto?>

    suspend fun getMovieKeywords(movieId: Int): List<MovieDto?>

    suspend fun getSimilarMovies(movieId: Int, page: Int, language: String): List<MovieDto?>

    suspend fun getMovieTrailers(movieId: Int, language: String): List<TrailersDto?>

    suspend fun getLatestMovie(): List<MovieDto?>

    suspend fun getMovieRecommendations(
        movieId: Int,
        page: Int = 1,
        language: String
    ): List<MovieDto?>

    suspend fun rateMovie(movieId: Int, rating: Double)

    suspend fun deleteMovieRating(movieId: Int)

    suspend fun getMovieReviews(movieId: Int, page: Int, language: String): List<ReviewDto?>
}