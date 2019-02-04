package com.pokeapi.milosz.pokeapi.Presenter;


import android.arch.paging.DataSource;

import com.pokeapi.milosz.pokeapi.Model.PokeModel;
import com.pokeapi.milosz.pokeapi.Network.Pojo.Result;

import javax.inject.Inject;

public class ResultDataSourceFactory extends DataSource.Factory<Integer, Result> {


    @Inject
    public ResultDataSourceFactory(PokeModel mPokeModel){
        this.mPokeModel = mPokeModel;
    }
    private PokeModel mPokeModel;
    @Override
    public DataSource<Integer, Result> create() {

        return new ResultDataSource(mPokeModel);
    }

}

