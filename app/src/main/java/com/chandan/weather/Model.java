// Model.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.chandan.weather;
import java.util.List;

public class Model {
    private Rain rain;
    private long visibility;
    private long timezone;
    private Main main;
    private Clouds clouds;
    private Sys sys;
    private long dt;
    private Coord coord;
    private List<Weather> weather;
    private String name;
    private long cod;
    private long id;
    private String base;
    private Wind wind;

    public Rain getRain() { return rain; }
    public void setRain(Rain value) { this.rain = value; }

    public long getVisibility() { return visibility; }
    public void setVisibility(long value) { this.visibility = value; }

    public long getTimezone() { return timezone; }
    public void setTimezone(long value) { this.timezone = value; }

    public Main getMain() { return main; }
    public void setMain(Main value) { this.main = value; }

    public Clouds getClouds() { return clouds; }
    public void setClouds(Clouds value) { this.clouds = value; }

    public Sys getSys() { return sys; }
    public void setSys(Sys value) { this.sys = value; }

    public long getDt() { return dt; }
    public void setDt(long value) { this.dt = value; }

    public Coord getCoord() { return coord; }
    public void setCoord(Coord value) { this.coord = value; }

    public List<Weather> getWeather() { return weather; }
    public void setWeather(List<Weather> value) { this.weather = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public long getCod() { return cod; }
    public void setCod(long value) { this.cod = value; }

    public long getid() { return id; }
    public void setid(long value) { this.id = value; }

    public String getBase() { return base; }
    public void setBase(String value) { this.base = value; }

    public Wind getWind() { return wind; }
    public void setWind(Wind value) { this.wind = value; }
}

// Clouds.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

class Clouds {
    private long all;

    public long getAll() { return all; }
    public void setAll(long value) { this.all = value; }
}

// Coord.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

class Coord {
    private double lon;
    private double lat;

    public double getLon() { return lon; }
    public void setLon(long value) { this.lon = value; }

    public double getLat() { return lat; }
    public void setLat(double value) { this.lat = value; }
}

// Main.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

class Main {
    private double temp;
    private double temp_min;
    private long humidity;
    private long pressure;
    private double feelsLike;
    private double temp_max;

    public double getTemp() { return temp; }
    public void setTemp(int value) { this.temp = value; }

    public double getTempMin() { return temp_min; }
    public void setTempMin(double value) { this.temp_min = value; }

    public long getHumidity() { return humidity; }
    public void setHumidity(int value) { this.humidity = value; }

    public long getPressure() { return pressure; }
    public void setPressure(long value) { this.pressure = value; }

    public double getFeelsLike() { return feelsLike; }
    public void setFeelsLike(double value) { this.feelsLike = value; }

    public double getTempMax() { return temp_max; }
    public void setTempMax(double value) { this.temp_max = value; }
}

// Rain.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

class Rain {
    private double the1H;

    public double getThe1H() { return the1H; }
    public void setThe1H(double value) { this.the1H = value; }
}

// Sys.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

class Sys {
    private String country;
    private long sunrise;
    private long sunset;
    private long id;
    private long type;

    public String getCountry() { return country; }
    public void setCountry(String value) { this.country = value; }

    public long getSunrise() { return sunrise; }
    public void setSunrise(long value) { this.sunrise = value; }

    public long getSunset() { return sunset; }
    public void setSunset(long value) { this.sunset = value; }

    public long getid() { return id; }
    public void setid(long value) { this.id = value; }

    public long getType() { return type; }
    public void setType(long value) { this.type = value; }
}

// Weather.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

class Weather {
    private String icon;
    private String description;
    private String main;
    private long id;

    public String getIcon() { return icon; }
    public void setIcon(String value) { this.icon = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }

    public String getMain() { return main; }
    public void setMain(String value) { this.main = value; }

    public long getid() { return id; }
    public void setid(long value) { this.id = value; }
}

// Wind.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

class Wind {
    private long deg;
    private double speed;

    public long getDeg() { return deg; }
    public void setDeg(long value) { this.deg = value; }

    public double getSpeed() { return speed; }
    public void setSpeed(double value) { this.speed = value; }
}
