package com.pokeapi.milosz.pokeapi;

import android.app.Application;
import android.app.Fragment;

import com.pokeapi.milosz.pokeapi.Dagger2.DaggerMainComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;

public class MainApplication extends Application implements HasFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;


    @Override
    public void onCreate() {
        super.onCreate();
        DaggerMainComponent.create().inject(this);
    }

    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
