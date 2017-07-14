package com.prajesh.controller;

import com.prajesh.model.rest.Weather;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Prajesh Ananthan
 *         Created on 15/7/2017.
 */
@RestController
public class RestTemplateController {

  // json file located in resources folder
  @RequestMapping(value = "/rest")
  public Weather home() {
    RestTemplate restTemplate = new RestTemplate();
    Weather weather = restTemplate.getForObject("http://localhost:8080/data/weather.json", Weather.class);
    return weather;
  }
}
