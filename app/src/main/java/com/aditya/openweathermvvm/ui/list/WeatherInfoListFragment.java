package com.aditya.openweathermvvm.ui.list;

import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.openweathermvvm.R;
import com.aditya.openweathermvvm.base.BaseFragment;
import com.aditya.openweathermvvm.data.model.weather.WeatherInfo;
import com.aditya.openweathermvvm.util.ViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.Provides;

public class WeatherInfoListFragment  extends BaseFragment implements WeatherInfoSelectedListener {

    private final String TAG = "WeatherInfoListFragment";
    @BindView(R.id.recyclerViewWeather)
    RecyclerView listView;
    @BindView(R.id.tvErrorWeather)
    TextView errorTextView;
    @BindView(R.id.loadingViewWeather)
    View loadingView;

    @Inject
    ViewModelFactory viewModelFactory;
    private WeatherInfoViewModel viewModel;

    @Override
    protected int layoutRes() {
        return R.layout.weather_info_list;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(WeatherInfoViewModel.class);


        listView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.onDrawOver(c, parent, state);
            }
        });
        listView.setAdapter(new WeatherInfoListAdapter(viewModel, this, this));
        listView.setLayoutManager(new LinearLayoutManager(getContext()));

        observableViewModel();
    }

    @Override
    public void onWeatherSelected(WeatherInfo weatherInfo, String country) {
        Log.d(TAG,"Weather selected: " + country);
    }

    private void observableViewModel() {
        viewModel.getDelhiWeatherInfoLists().observe(getViewLifecycleOwner(), weather -> {
            if(weather != null) listView.setVisibility(View.VISIBLE);
        });

        viewModel.getError().observe(getViewLifecycleOwner(), isError -> {
            if (isError != null) if(isError) {
                errorTextView.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
                errorTextView.setText("An Error Occurred While Loading Data!");
            }else {
                errorTextView.setVisibility(View.GONE);
                errorTextView.setText(null);
            }
        });

        viewModel.getLoading().observe(getViewLifecycleOwner(), isLoading -> {
            if (isLoading != null) {
                loadingView.setVisibility(isLoading ? View.VISIBLE : View.GONE);
                if (isLoading) {
                    errorTextView.setVisibility(View.GONE);
                    listView.setVisibility(View.GONE);
                }
            }
        });
    }
}
