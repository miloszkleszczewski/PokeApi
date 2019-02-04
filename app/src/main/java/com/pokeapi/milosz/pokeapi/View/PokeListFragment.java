package com.pokeapi.milosz.pokeapi.View;

import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pokeapi.milosz.pokeapi.Dagger2.MainComponent;
import com.pokeapi.milosz.pokeapi.MainApplication;
import com.pokeapi.milosz.pokeapi.Presenter.PokePresenter;
import com.pokeapi.milosz.pokeapi.R;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjection;

import javax.inject.Inject;

public class PokeListFragment extends Fragment {

    @Inject
    PokePresenter mPokePresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidInjection.inject(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_poke_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        PokePagingAdapter adapter = new PokePagingAdapter(getContext());
        adapter.submitList(mPokePresenter.getPagedList());
        recyclerView.setAdapter(adapter);

        return view;
    }


}
