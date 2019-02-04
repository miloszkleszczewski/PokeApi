
package com.pokeapi.milosz.pokeapi.Network.Pojo;

import com.google.gson.annotations.SerializedName;


public class Result {

    @SerializedName("name")
    private String mName;

    public String getName() {
        return mName;
    }

}
