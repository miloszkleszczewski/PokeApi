package com.pokeapi.milosz.pokeapi.Model;

import com.pokeapi.milosz.pokeapi.Network.Pojo.PokePojo;
import com.pokeapi.milosz.pokeapi.Network.PokeApiService;
import com.pokeapi.milosz.pokeapi.Network.PokeApiServiceFactory;

import io.reactivex.Single;

public class PokeModel {

    private PokeApiServiceFactory mApiServiceFactory = new PokeApiServiceFactory();

    private PokeApiService mApiService = mApiServiceFactory.getApiService();

    public Single<PokePojo> getPokeList(int offset, int limit) {
        return mApiService.getPokeList(offset, limit);
    }

}
