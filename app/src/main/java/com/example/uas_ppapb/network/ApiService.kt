package com.example.uas_ppapb.network

import com.example.uas_ppapb.model.FilmUserData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

// Interface yang mendefinisikan semua endpoint API yang akan digunakan
interface ApiService {

    @GET("j2Doo/movies")
    fun getMovies(): Call<List<FilmUserData>>

    @GET("j2Doo/movies/{id}")
    fun getMovieDetails(@Path("id") movieId: String): Call<FilmUserData>

    @POST("j2Doo/movies")
    suspend fun createMovie(@Body movie: FilmUserData): retrofit2.Response<Void>

    @POST("j2Doo/movies/{id}")
    suspend fun updateMovie(@Path("id") movieId: String, @Body movie: FilmUserData): retrofit2.Response<Void>

    @DELETE("j2Doo/movies/{id}")
    suspend fun deleteMovie(@Path("id") movieId: String): retrofit2.Response<Void>
}
