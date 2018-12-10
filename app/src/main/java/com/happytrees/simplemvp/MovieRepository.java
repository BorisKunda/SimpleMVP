package com.happytrees.simplemvp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository implements Contract.Repository {

    @Override
    public void getMovieList(final RepositoryCallback repositoryCallback) {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<MoviesResponse> call = apiInterface.getPopularMovies();
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                repositoryCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                repositoryCallback.onFailure();
            }
        });
    }
}
