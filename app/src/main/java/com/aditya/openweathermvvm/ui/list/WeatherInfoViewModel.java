package com.aditya.openweathermvvm.ui.list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aditya.openweathermvvm.data.model.weather.CityWeather;
import com.aditya.openweathermvvm.data.rest.WeatherRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class WeatherInfoViewModel extends ViewModel {

    private final WeatherRepository weatherRepository;
    private CompositeDisposable disposable;

    private final MutableLiveData<CityWeather> cityWeather = new MutableLiveData<CityWeather>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<Boolean>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<Boolean>();

    @Inject
    public WeatherInfoViewModel(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
        disposable = new CompositeDisposable();
        fetchDelhiWeatherInfo();
    }

    LiveData<CityWeather> getDelhiWeatherInfoLists() {
        return cityWeather;
    }
    LiveData<Boolean> getError() {
        return repoLoadError;
    }
    LiveData<Boolean> getLoading() {
        return loading;
    }

    private void fetchDelhiWeatherInfo() {
        loading.setValue(true);
        disposable.add(weatherRepository.getDelhiWeatherInfoLists().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<CityWeather>() {
                    @Override
                    public void onSuccess(CityWeather value) {
                        repoLoadError.setValue(false);
                        cityWeather.setValue(value);
                        loading.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        repoLoadError.setValue(true);
                        loading.setValue(false);
                    }
                }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }

}
