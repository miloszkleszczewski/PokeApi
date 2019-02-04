package com.pokeapi.milosz.pokeapi.Presenter;

import android.arch.paging.PagedList;

import com.pokeapi.milosz.pokeapi.Network.Pojo.Result;

import java.util.concurrent.Executors;

import javax.inject.Inject;


public class PokePresenter {

    @Inject
    public PokePresenter(ResultDataSourceFactory mResultDataSourceFactory){
        this.mResultDataSourceFactory = mResultDataSourceFactory;
    }

    private ResultDataSourceFactory mResultDataSourceFactory;

    public PagedList<Result> getPagedList() {
        PagedList.Config config = (new PagedList.Config.Builder())
                .setPageSize(3)
                .build();
        return new PagedList.Builder<>(mResultDataSourceFactory.create(), config)
                .setFetchExecutor(Executors.newSingleThreadExecutor())
                .setNotifyExecutor(Executors.newSingleThreadExecutor())
                .build();
    }
}


