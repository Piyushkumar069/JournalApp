package com.project.journalApp.service;

import com.project.journalApp.api.response.WeatherResponse;
import com.project.journalApp.cache.AppCache;
import com.project.journalApp.constants.Placeholders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    // @value is used top inject values from application.properties to this apiKeyVariable
    @Value("${weather.api.key}")
    private String apiKey;

    // we can hit apis in code using rest template, It is a class that processes the class for us and gives us response
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    public WeatherResponse getWeather(String city){
        String finalAPI = appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).replace(Placeholders.CITY, city).replace(Placeholders.API_KEY, apiKey);

        //Get call example
        // conversion of JSON to POJO is called deserialization.
        // here api response comes from below request in the form of json and then WeatherResponse class will convert it into pojo
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);


//        // Post call example
//        String requestBody = "{\n" +
//                "   \n"username\":\"vipul\",\n" +
//                "   \n"password\":\"vipul\",\n" +
//                "}  ";
//        HttpEntity<String> httpEntity = new HttpEntity<>(requestBody);
//        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.POST, httpEntity, WeatherResponse.class);

        WeatherResponse body = response.getBody();
        return body;
    }
}
