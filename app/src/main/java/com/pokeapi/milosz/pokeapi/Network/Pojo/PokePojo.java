
package com.pokeapi.milosz.pokeapi.Network.Pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokePojo {

    @SerializedName("next")
    private String mNext;
    @SerializedName("results")
    private List<Result> mResults;

    public String getNext() {
        return mNext;
    }

    public List<Result> getResults() {
        return mResults;
    }

}
