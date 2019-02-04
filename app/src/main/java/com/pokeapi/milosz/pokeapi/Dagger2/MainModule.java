package com.pokeapi.milosz.pokeapi.Dagger2;

import com.pokeapi.milosz.pokeapi.Model.PokeModel;
import com.pokeapi.milosz.pokeapi.Presenter.ResultDataSourceFactory;
import com.pokeapi.milosz.pokeapi.View.PokeListFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainModule {


    @ContributesAndroidInjector
    abstract PokeListFragment contributeAndroidInjector();

    @Provides
    static ResultDataSourceFactory providesDataFactory() {
        return new ResultDataSourceFactory(providesPokeModel());
    }

    @Provides
    static PokeModel providesPokeModel() {
        return new PokeModel();
    }
}
