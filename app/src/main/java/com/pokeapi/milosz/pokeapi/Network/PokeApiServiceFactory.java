package com.pokeapi.milosz.pokeapi.Network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokeApiServiceFactory {
    private PokeApiService INSTANCE = null;

    public PokeApiService getApiService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(interceptor);

        if (INSTANCE != null) {
            return INSTANCE;
        }else{
            INSTANCE = new Retrofit.Builder()
                    .client(httpClientBuilder.build())
                    .baseUrl("https://pokeapi.co/api/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(PokeApiService.class);
            return INSTANCE;
        }
    }
}