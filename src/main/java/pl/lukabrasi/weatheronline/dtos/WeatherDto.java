package pl.lukabrasi.weatheronline.dtos;

import lombok.Data;

@Data
public class WeatherDto {

    private TemperatureDto main;
    private CloudsDto clouds;
    private WindDto wind;
    private String name;



}
