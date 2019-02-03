package pl.lukabrasi.weatheronline.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.lukabrasi.weatheronline.dtos.CodDto;
import pl.lukabrasi.weatheronline.dtos.TemperatureDto;
import pl.lukabrasi.weatheronline.dtos.WeatherDto;

@Service
public class WeatherLogService {

    @Value("${api.openweathermap.key}")
    String apiKey;

    public boolean isCityExists(String cityName) {
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&units=metric&appid=" + apiKey;
        System.out.println("opcja 1");
        RestTemplate restTemplate = getRestTemplate();
        System.out.println("tutu");
        CodDto codDto = restTemplate.getForObject(urlString, CodDto.class);//TU SIE WYWALA!!!
        System.out.println(codDto.getCod());
        if (!cityName.trim().isEmpty()) {
            //      if (codDto.getCod()==200) {
            //     System.out.println(codDto.getCod());
            return true;
        }

        return false;
    }

/*
    public WeatherDto getCurrentWeather(String cityName) {
        String urlString2 = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&units=metric&appid=" + apiKey;
        RestTemplate restTemplate2 = getRestTemplate();
        WeatherDto weatherDto = restTemplate2.getForObject(urlString2, WeatherDto.class);
        //   saveWeatherLog(weatherDto);
        return weatherDto;
    }*/


    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
