package com.arsoft.themovieapp.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.arsoft.themovieapp.R;
import com.arsoft.themovieapp.serviceapi.MovieApiService;
import com.arsoft.themovieapp.serviceapi.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// Used to abstract the data source details and
// provides a clean API for the ViewModel to
// fetch and manage data
public class MovieRepository {
    private ArrayList<Movie> movies = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();

    private Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData(){
        MovieApiService movieApiService = RetrofitInstance.getService();

        Call<Result> call = movieApiService.getPopularMovies(application.getApplicationContext().getString(R.string.api_key));


        // perform network request in the background thread and
        // handle the response on the main (UI) thread
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                // Success
                Result result = response.body();
                if (result != null && result.getResult() != null){
                    movies = (ArrayList<Movie>) result.getResult();
                    mutableLiveData.setValue(movies);
                }

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
            }
        });

        return mutableLiveData;

    }


}
