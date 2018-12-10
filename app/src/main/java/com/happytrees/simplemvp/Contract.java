package com.happytrees.simplemvp;

import java.util.ArrayList;

public interface Contract {

    interface Repository {
        void getMovieList( RepositoryCallback repositoryCallback);

        interface RepositoryCallback {
        void onSuccess(MoviesResponse response);

        void onFailure();

        }
    }

    interface View {
        void displayMovies(ArrayList<Movie> movieArrayList);
    }

    interface Presenter {
        void requestDataFromServer();
    }
}
