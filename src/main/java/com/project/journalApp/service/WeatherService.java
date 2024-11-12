package com.project.journalApp.service;

import com.project.journalApp.api.response.WeatherResponse;
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

    private static final String API = "http://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    // we can hit apis in code using rest template, It is a class that processes the class for us and gives us response
    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city){
        String finalAPI = API.replace("CITY", city).replace("API_KEY", apiKey);

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
