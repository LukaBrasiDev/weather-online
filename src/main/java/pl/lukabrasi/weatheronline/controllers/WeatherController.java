package pl.lukabrasi.weatheronline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.lukabrasi.weatheronline.services.UserSession;

@Controller
public class WeatherController {

    final UserSession userSession;



    @Autowired
    public WeatherController(UserSession userSession) {
        this.userSession = userSession;
          }



    @GetMapping("/")
   // @ResponseBody
    public String index() {
        if(userSession.isUserLogin()){
            return "index";
        }
        return "login";
    }

}
