package com.red_velvet.flix.data.remote.recoures.movie


import com.google.gson.annotations.SerializedName
import com.red_velvet.flix.data.remote.recoures.KeywordResource
import com.red_velvet.flix.data.remote.recoures.ProductionCompanyResource
import com.red_velvet.flix.data.remote.recoures.ProductionCountryResource
import com.red_velvet.flix.data.remote.recoures.SpokenLanguageResource

data class MovieDetailsResource(
    @SerializedName("adult")
    val adult: Boolean?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("belongs_to_collection")
    val belongsToCollection: BelongsToCollectionResource?,
    @SerializedName("budget")
    val budget: Int?,
    @SerializedName("genres")
    val genres: List<KeywordResource?>?,
    @SerializedName("homepage")
    val homepage: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("imdb_id")
    val imdbId: String?,
    @SerializedName("original_language")
    val originalLanguage: String?,
    @SerializedName("original_title")
    val originalTitle: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompanyResource?>?,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountryResource?>?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("revenue")
    val revenue: Int?,
    @SerializedName("runtime")
    val runtime: Int?,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguageResource?>?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("tagline")
    val tagline: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("video")
    val video: Boolean?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("vote_count")
    val voteCount: Int?
)