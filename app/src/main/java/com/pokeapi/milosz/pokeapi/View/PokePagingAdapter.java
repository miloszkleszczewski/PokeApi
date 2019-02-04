package com.pokeapi.milosz.pokeapi.View;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pokeapi.milosz.pokeapi.Network.Pojo.Result;
import com.pokeapi.milosz.pokeapi.R;

import javax.inject.Inject;

public class PokePagingAdapter extends PagedListAdapter<Result, PokePagingAdapter.ItemViewHolder> {

    private Context mContext;

    protected PokePagingAdapter(Context context) {
        super(diffCallback);
        this.mContext = context;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView pokeName;
        ImageView pokeImage;

        private ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            pokeName = itemView.findViewById(R.id.pokeNameText);
            pokeImage = itemView.findViewById(R.id.pokeImage);
        }
    }

    private static DiffUtil.ItemCallback<Result> diffCallback =
            new DiffUtil.ItemCallback<Result>() {
                @Override
                public boolean areItemsTheSame(@NonNull Result oldResult, @NonNull Result newResult) {
                    return oldResult.equals(newResult);
                }

                @Override
                public boolean areContentsTheSame(@NonNull Result oldResult, @NonNull Result newResult) {
                    return oldResult.equals(newResult);
                }
            };

    @NonNull
    @Override
    public PokePagingAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.poke_list_item, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokePagingAdapter.ItemViewHolder itemViewHolder, int position) {
        Result result = getItem(position);
        if (result != null) {
            Glide.with(mContext)
                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + (position + 1) + ".png")
                    .into(itemViewHolder.pokeImage);
            itemViewHolder.pokeName.setText(result.getName());
        }
    }
}
