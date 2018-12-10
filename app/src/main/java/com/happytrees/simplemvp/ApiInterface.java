package com.happytrees.simplemvp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("movie/popular?api_key=2e901364c3d103dcb00ced520e9bca3c")
    Call<MoviesResponse> getPopularMovies();
}
