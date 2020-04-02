package com.aditya.openweathermvvm.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.aditya.openweathermvvm.di.util.ViewModelKey;
import com.aditya.openweathermvvm.ui.list.WeatherInfoViewModel;
import com.aditya.openweathermvvm.util.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(WeatherInfoViewModel.class)
    abstract ViewModel bindWeatherInfoViewModel(WeatherInfoViewModel weatherInfoViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

}
