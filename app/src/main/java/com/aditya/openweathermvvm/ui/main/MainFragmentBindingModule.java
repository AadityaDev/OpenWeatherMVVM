package com.aditya.openweathermvvm.ui.main;

import com.aditya.openweathermvvm.ui.detail.DetailsFragment;
import com.aditya.openweathermvvm.ui.list.ListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract ListFragment provideListFragment();

    @ContributesAndroidInjector
    abstract DetailsFragment provideDetailsFragment();
}
