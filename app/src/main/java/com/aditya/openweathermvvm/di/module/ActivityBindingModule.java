package com.aditya.openweathermvvm.di.module;

import com.aditya.openweathermvvm.ui.main.MainActivity;
import com.aditya.openweathermvvm.ui.main.MainFragmentBindingModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {MainFragmentBindingModule.class})
    abstract MainActivity bindMainActivity();

}
