package com.happytrees.simplemvp;

public class MoviePresenter implements Contract.Presenter {
    private MovieRepository movieRepository;
    private Contract.View view;

    public MoviePresenter(MovieRepository movieRepository, Contract.View view) {
        this.movieRepository = movieRepository;
        this.view = view;
    }

    @Override
    public void requestDataFromServer() {
        movieRepository.getMovieList(new Contract.Repository.RepositoryCallback() {
            @Override
            public void onSuccess(MoviesResponse response) {
                view.displayMovies(response.results);
            }

            @Override
            public void onFailure() {
                // TODO: 12/10/2018 handle failure
            }
        });
    }
}
