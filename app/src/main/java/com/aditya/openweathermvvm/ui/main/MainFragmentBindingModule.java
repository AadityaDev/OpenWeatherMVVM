package com.aditya.openweathermvvm.ui.main;

import com.aditya.openweathermvvm.ui.list.WeatherInfoListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract WeatherInfoListFragment provideWeatherInfoListFragment();

}
