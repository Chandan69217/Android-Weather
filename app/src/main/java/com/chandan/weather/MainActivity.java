package com.chandan.weather;

// API Key: 04f9c89aed4493d3d7a233579d7995f1

/*
    {"coord":{"lon":85,"lat":24.7833},"weather":[{"id":300,"main":"Drizzle","description":"light intensity drizzle","icon":"09d"},{"id":701,"main":"Mist","description":"mist","icon":"50d"},{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}],"base":"stations","main":{"temp":302.1,"feels_like":307.54,"temp_min":302.1,"temp_max":302.1,"pressure":1000,"humidity":79},"visibility":3000,"wind":{"speed":3.6,"deg":270},"rain":{"1h":3.99},"clouds":{"all":100},"dt":1691488997,"sys":{"type":1,"id":9115,"country":"IN","sunrise":1691452253,"sunset":1691499638},"timezone":19800,"id":1271439,"name":"Gaya","cod":200}
*/
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.WindowCompat;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Gravity;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private SearchView searchView;
    private TextView city_name,temp,weather,max_temp,min_temp,day,date,
                     humidity,wind_speed,conditions,sunrise,sunset,sea;
    private ConstraintLayout constraintLayout;
    private LottieAnimationView lottieAnimationView;

    private String cityName="Goh",APIKey = "04f9c89aed4493d3d7a233579d7995f1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // transparent status bar
        WindowCompat.setDecorFitsSystemWindows(getWindow(),false);
        findViewID();
        fetchWeather(cityName);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                    cityName = s;
                    fetchWeather(cityName);
                    searchView.clearFocus();
                    searchView.setQuery("",false);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    private void fetchWeather(String cityName) {

        API api = RetrofitClient.getRetrofitInstance().create(API.class);
        Call<Model> modelCall = api.getData(cityName,APIKey,"metric");
        modelCall.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Log.e("onResponse",String.valueOf(response.code()));
                if(response.isSuccessful()){
                    Model weatherData = response.body();
                    temp.setText(String.valueOf((int) weatherData.getMain().getTemp() ) + " °C");
                    Log.e("min_temp",String.valueOf(weatherData.getMain().getTempMin()));
                    Log.e("min_temp",String.valueOf(weatherData.getMain().getTempMax()));
                    max_temp.setText("Max: " + String.valueOf(weatherData.getMain().getTempMax()+" °C"));
                    min_temp.setText("Min: " + String.valueOf(weatherData.getMain().getTempMin()+" °C"));
                    humidity.setText(String.valueOf(weatherData.getMain().getHumidity()) + " %");
                    wind_speed.setText(String.valueOf(weatherData.getWind().getSpeed()) + " m/s");
                    sunrise.setText(getTime(weatherData.getSys().getSunrise()));
                    sunset.setText(getTime(weatherData.getSys().getSunset()));
                    sea.setText(String.valueOf(weatherData.getMain().getPressure())+ " hpa");
                    conditions.setText(String.valueOf(weatherData.getMain().getFeelsLike()));
                    city_name.setText(cityName);
                    day.setText(getDayName());
                    date.setText(getDate());
                    weather.setText(weatherData.getWeather().get(0).getMain());
                    conditions.setText(weatherData.getWeather().get(0).getMain());
                    changeImageAccordingToWeatherCondition(weatherData.getWeather().get(0).getMain());
                }else if(!(response.isSuccessful())){
                    Toast toast;
                    toast = Toast.makeText(getApplicationContext(),"Please enter a valid city name",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP,0,0);
                    toast.show();
                }
            }
            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.e("onFailure",t.getMessage());
                Toast toast;
                toast = Toast.makeText(getApplicationContext(), "Please check your internet", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP,0,0);
                toast.show();
            }
        });
    }

    private void changeImageAccordingToWeatherCondition(String Condition) {
        switch(Condition){
            case "Clear Sky": constraintLayout.setBackgroundResource(R.drawable.sunny_background);
                              lottieAnimationView.setAnimation(R.raw.sun);
            case "Sunny":     constraintLayout.setBackgroundResource(R.drawable.sunny_background);
                              lottieAnimationView.setAnimation(R.raw.sun);
            case "Clear":      constraintLayout.setBackgroundResource(R.drawable.sunny_background);
                              lottieAnimationView.setAnimation(R.raw.sun);
            break;

            case "Party Clouds": constraintLayout.setBackgroundResource(R.drawable.colud_background);
                                 lottieAnimationView.setAnimation(R.raw.cloud);
            case "Haze":         constraintLayout.setBackgroundResource(R.drawable.colud_background);
                                 lottieAnimationView.setAnimation(R.raw.cloud);
            case "Clouds":       constraintLayout.setBackgroundResource(R.drawable.colud_background);
                                 lottieAnimationView.setAnimation(R.raw.cloud);
            case "OverCast":     constraintLayout.setBackgroundResource(R.drawable.colud_background);
                                 lottieAnimationView.setAnimation(R.raw.cloud);
            case "Mist":         constraintLayout.setBackgroundResource(R.drawable.colud_background);
                                 lottieAnimationView.setAnimation(R.raw.cloud);
            case "Foggy":        constraintLayout.setBackgroundResource(R.drawable.colud_background);
                                 lottieAnimationView.setAnimation(R.raw.cloud);
            break;

            case "Rain":         constraintLayout.setBackgroundResource(R.drawable.rain_background);
                                 lottieAnimationView.setAnimation(R.raw.rain);
            case "Light Rain":   constraintLayout.setBackgroundResource(R.drawable.rain_background);
                                 lottieAnimationView.setAnimation(R.raw.rain);
            case "Drizzle":      constraintLayout.setBackgroundResource(R.drawable.rain_background);
                                 lottieAnimationView.setAnimation(R.raw.rain);
            case "Moderate Rain": constraintLayout.setBackgroundResource(R.drawable.rain_background);
                                  lottieAnimationView.setAnimation(R.raw.rain);
            case "Showers":      constraintLayout.setBackgroundResource(R.drawable.rain_background);
                                 lottieAnimationView.setAnimation(R.raw.rain);
            case "Heavy Rain":   constraintLayout.setBackgroundResource(R.drawable.rain_background);
                                 lottieAnimationView.setAnimation(R.raw.rain);
            break;

            case "Light Snow":   constraintLayout.setBackgroundResource(R.drawable.snow_background);
                                 lottieAnimationView.setAnimation(R.raw.snow);
            case "Moderate Snow": constraintLayout.setBackgroundResource(R.drawable.snow_background);
                                 lottieAnimationView.setAnimation(R.raw.snow);
            case "Heavy Snow":   constraintLayout.setBackgroundResource(R.drawable.snow_background);
                                 lottieAnimationView.setAnimation(R.raw.snow);
            case "Blizzard":     constraintLayout.setBackgroundResource(R.drawable.snow_background);
                                 lottieAnimationView.setAnimation(R.raw.snow);
            break;
        }

        lottieAnimationView.playAnimation();
    }

    private String getTime(Long getTime) {
        String Time = null;
        java.util.Date date = new Date(getTime*1000l);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("KK:mm aaa", Locale.getDefault());
        Time = simpleDateFormat.format(date);
        return Time;
    }

    private void findViewID(){
        constraintLayout = findViewById(R.id.frame_layout);
        searchView = findViewById(R.id.searchView);
        city_name = findViewById(R.id.city_name);
        temp = findViewById(R.id.temp);
        weather = findViewById(R.id.weather);
        max_temp = findViewById(R.id.max_temp);
        min_temp = findViewById(R.id.min_temp);
        day = findViewById(R.id.day);
        date = findViewById(R.id.date);
        humidity = findViewById(R.id.humidity);
        wind_speed = findViewById(R.id.wind_speed);
        conditions = findViewById(R.id.conditios);
        sunrise = findViewById(R.id.sunrise);
        sunset = findViewById(R.id.sunset);
        sea = findViewById(R.id.sea);
        lottieAnimationView = findViewById(R.id.lottieAnimationView);
    }

    private String getDayName(){
        String day;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE",Locale.getDefault());
        day = simpleDateFormat.format(calendar.getTime()).toString();
        Log.e("getDayName",String.valueOf(System.currentTimeMillis()));
        return day;
    }

    private String getDate(){
        String date;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd LLLL yyyy");
        date = simpleDateFormat.format(calendar.getTime());
        return date;
    }

}