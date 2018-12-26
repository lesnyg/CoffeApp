package com.example.edu05.coffeapp.models;

public class Weather {
    private int imageres;
    private String location;
    private String temperature;

    public Weather(int imageres, String location, String temperature) {
        this.imageres = imageres;
        this.location = location;
        this.temperature = temperature;
    }

    public int getImageres() {
        return imageres;
    }

    public void setImageres(int imageres) {
        this.imageres = imageres;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Weather{");
        sb.append("imageres=").append(imageres);
        sb.append(", location='").append(location).append('\'');
        sb.append(", temperature='").append(temperature).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
