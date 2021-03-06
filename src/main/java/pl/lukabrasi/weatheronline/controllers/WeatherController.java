package pl.lukabrasi.weatheronline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.lukabrasi.weatheronline.services.UserSession;
import pl.lukabrasi.weatheronline.services.WeatherLogService;

@Controller
public class WeatherController {

    final UserSession userSession;
    final WeatherLogService weatherLogService;

    @Autowired
    public WeatherController(UserSession userSession, WeatherLogService weatherLogService) {
        this.userSession = userSession;
        this.weatherLogService = weatherLogService;
    }




    @GetMapping("/")
    public String index() {
        if (userSession.isUserLogin()) {
            return "index";
        }
        return "login";
    }



    @PostMapping("/")
    public String index(@RequestParam("cityName") String cityName,
                        Model model) {
        model.addAttribute("weather", weatherLogService.getCurrentWeather(cityName));

        return "index";
    }


}
