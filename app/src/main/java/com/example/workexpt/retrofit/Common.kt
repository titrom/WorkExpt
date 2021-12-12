package com.example.workexpt.retrofit

object Common {
    private val BASE_URL = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/"
    val superheroesApi: SuperheroesApi
        get() = RetrofitClient.getClient(BASE_URL).create(SuperheroesApi::class.java)
}