package com.example.uas_ppapb.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Mengatur koneksi ke API dengan Retrofit
object ApiClient {

    private const val BASE_URL = "https://ppbo-api-b.vercel.app/"

    val api: ApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)
}
