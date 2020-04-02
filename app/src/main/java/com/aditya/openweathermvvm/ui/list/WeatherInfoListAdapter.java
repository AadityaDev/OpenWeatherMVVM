package com.aditya.openweathermvvm.ui.list;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.openweathermvvm.R;
import com.aditya.openweathermvvm.data.model.weather.CityWeather;
import com.aditya.openweathermvvm.data.model.weather.WeatherInfo;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherInfoListAdapter extends RecyclerView.Adapter<WeatherInfoListAdapter.WeatherInfoListViewHolder> {

    private WeatherInfoSelectedListener weatherInfoSelectedListener;
    private CityWeather cityWeather = new CityWeather();
    private Context context;

    WeatherInfoListAdapter(WeatherInfoViewModel weatherInfoViewModel, LifecycleOwner lifecycleOwner,
                           WeatherInfoSelectedListener weatherInfoSelectedListener) {

        this.weatherInfoSelectedListener = weatherInfoSelectedListener;
        weatherInfoViewModel.getDelhiWeatherInfoLists()
                .observe(lifecycleOwner, weather -> {
//                    cityWeather.getWeatherInfoList().clear();
                    if(cityWeather != null) {
                        cityWeather = weather;
                        notifyDataSetChanged();
                    } else {
//                        Log.d("ASDAD", weather);
                    }
                } );
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public WeatherInfoListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_weather_info_list_item,
                parent, false);
        return new WeatherInfoListAdapter.WeatherInfoListViewHolder(view, weatherInfoSelectedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherInfoListViewHolder holder, int position) {
        holder.bind(cityWeather.getCode(), cityWeather.getWeatherInfoList().get(position));
    }

    @Override
    public int getItemCount() {
        return cityWeather.getWeatherInfoList().size();
    }

    @Override
    public long getItemId(int position) {
        return cityWeather.getWeatherInfoList().get(position).id;
    }

    static class WeatherInfoListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.weatherIcon) ImageView weatherIconImageView;
        @BindView(R.id.title) TextView titleTextView;
        @BindView(R.id.description) TextView descriptionTextView;
        @BindView(R.id.country) TextView countryTextView;
        @BindView(R.id.minTemp) TextView minTempTextView;
        @BindView(R.id.maxTemp) TextView maxTempTextView;
        @BindView(R.id.seaLevel) TextView seaLevelTextView;
        @BindView(R.id.pressure) TextView pressureTextView;
        @BindView(R.id.groundLevel) TextView groundLevelTextView;
        @BindView(R.id.humidity) TextView humidityTextView;
        @BindView(R.id.temperature) TextView temperatureTextView;
        @BindView(R.id.weatherDate) TextView weatherDateTextView;

        private WeatherInfo weatherInfo;
        private String country;

        public WeatherInfoListViewHolder(@NonNull View itemView, @NonNull WeatherInfoSelectedListener weatherInfoSelectedListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (weatherInfoSelectedListener != null) {
                        weatherInfoSelectedListener.onWeatherSelected(weatherInfo, country);
                    }
                }
            });
        }

        void bind(String country, @NonNull WeatherInfo weatherInfo) {
            this.weatherInfo = weatherInfo;
            if(weatherInfo != null && weatherInfo.weather != null && weatherInfo.weather.get(0) != null
             && weatherInfo.weather.get(0).icon != null) {
                Picasso.with(weatherIconImageView.getContext())
                        .load(Uri.parse("https://openweathermap.org/img/w/"+weatherInfo.weather.get(0).icon+".png"))
                        .fit().centerCrop()
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .into(this.weatherIconImageView);
            }
            this.titleTextView.setText(weatherInfo.weather.get(0).main);
            descriptionTextView.setText(weatherInfo.weather.get(0).description);
            this.countryTextView.setText("Delhi, India");
            this.minTempTextView.setText("Min (C): " + weatherInfo.allInfo.tempMin + "");
            this.maxTempTextView.setText("Max (C): " + weatherInfo.allInfo.tempMax + "");
            this.pressureTextView.setText("Pressure: " + weatherInfo.allInfo.pressure + "");
            this.seaLevelTextView.setText("Sea Level: " + weatherInfo.allInfo.pressure + "");
            this.groundLevelTextView.setText("Ground Level: " + weatherInfo.allInfo.groundLevel + "");
            this.humidityTextView.setText("Humidity: " + weatherInfo.allInfo.humidity + "");
            this.temperatureTextView.setText("Temp (F): "+weatherInfo.allInfo.tempFarenheit + "");

            String dtStart = weatherInfo.date;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date date = format.parse(dtStart);
                weatherDateTextView.setText(date + "");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }

}
