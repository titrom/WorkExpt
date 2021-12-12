package com.example.workexpt.retrofit

import com.example.workexpt.model.AllSuperheroes
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface SuperheroesApi {
    @GET("./all.json")
    @Headers("Content-Type: application/json")
    fun getAllItems(): Observable<ArrayList<AllSuperheroes>>

    @GET("id/{id}.json")
    @Headers("Content-Type: application/json")
    fun getItem(@Path("id") id: Int): Single<AllSuperheroes>
}
