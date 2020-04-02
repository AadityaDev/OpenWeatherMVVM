package com.aditya.openweathermvvm.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.aditya.openweathermvvm.di.util.ViewModelKey;
import com.aditya.openweathermvvm.ui.detail.DetailsViewModel;
import com.aditya.openweathermvvm.ui.list.ListViewModel;
import com.aditya.openweathermvvm.ui.list.WeatherInfoViewModel;
import com.aditya.openweathermvvm.util.ViewModelFactory;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel.class)
    abstract ViewModel bindListViewModel(ListViewModel listViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel.class)
    abstract ViewModel bindDetailsViewModel(DetailsViewModel detailsViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(WeatherInfoViewModel.class)
    abstract ViewModel bindWeatherInfoViewModel(WeatherInfoViewModel weatherInfoViewModel);


    //    @Singleton
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
