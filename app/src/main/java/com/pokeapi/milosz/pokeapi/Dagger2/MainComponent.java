package com.pokeapi.milosz.pokeapi.Dagger2;

import android.content.Context;

import com.pokeapi.milosz.pokeapi.MainApplication;
import com.pokeapi.milosz.pokeapi.Model.PokeModel;
import com.pokeapi.milosz.pokeapi.Presenter.PokePresenter;
import com.pokeapi.milosz.pokeapi.Presenter.ResultDataSource;
import com.pokeapi.milosz.pokeapi.Presenter.ResultDataSourceFactory;
import com.pokeapi.milosz.pokeapi.View.PokeListFragment;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Component(modules = {MainModule.class, AndroidInjectionModule.class})
public interface MainComponent extends AndroidInjector<MainApplication> {

    void inject(PokeListFragment pokeListFragment);
    void inject(PokePresenter pokePresenter);
    void inject(ResultDataSource resultDataSource);
    void inject(ResultDataSourceFactory resultDataSourceFactory);

}
