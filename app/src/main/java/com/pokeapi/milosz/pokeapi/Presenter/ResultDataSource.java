package com.pokeapi.milosz.pokeapi.Presenter;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import com.pokeapi.milosz.pokeapi.Model.PokeModel;
import com.pokeapi.milosz.pokeapi.Network.Pojo.PokePojo;
import com.pokeapi.milosz.pokeapi.Network.Pojo.Result;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

//ToDo: add removing the disposable method

public class ResultDataSource extends PageKeyedDataSource<Integer, Result> {

    @Inject
    public ResultDataSource(PokeModel mPokeModel){
        this.mPokeModel = mPokeModel;
    }

    private static final int OFFSET = 50;
    private static final int START_OFFSET = 0;
    private static final int LIMIT = 50;
    private PokeModel mPokeModel;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Result> callback) {

        mPokeModel.getPokeList(START_OFFSET, LIMIT).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<PokePojo>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(PokePojo pokePojo) {
                        callback.onResult(pokePojo.getResults(), null, START_OFFSET + OFFSET);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Result> callback) {
        mPokeModel.getPokeList(params.key, LIMIT).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<PokePojo>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(PokePojo pokePojo) {
                        Integer key = (params.key > 0) ? params.key - 50 : null;
                        callback.onResult(pokePojo.getResults(), key);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Result> callback) {
        mPokeModel.getPokeList(params.key, LIMIT).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<PokePojo>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(PokePojo pokePojo) {
                        if (pokePojo.getNext() != null) {
                            Integer key = (pokePojo.getNext() != null) ? params.key + 50 : null;
                            callback.onResult(pokePojo.getResults(), key);
                        }


                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

}

