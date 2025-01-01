package com.example.jokeapp.data.api

import com.example.jokeapp.data.model.Joke
import retrofit2.http.GET




interface JokeApi {
    @GET("Any?blacklistFlags=nsfw,religious,political,racist,sexist,explicit&type=single")
    suspend fun getSingleJoke(): Joke

    @GET("Any?blacklistFlags=nsfw,religious,political,racist,sexist,explicit&type=twopart")
    suspend fun getTwoPartJoke(): Joke
}

