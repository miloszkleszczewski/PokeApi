package com.pokeapi.milosz.pokeapi.Network;

import com.pokeapi.milosz.pokeapi.Network.Pojo.PokePojo;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokeApiService {

    @GET("pokemon/")
    Single<PokePojo> getPokeList(@Query("offset") int offset,
                                 @Query("limit") int limit);

}
