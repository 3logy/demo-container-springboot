package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class DemoController {

    @GetMapping("/coins")
    public Coin[] getCoins(){
        RestTemplate restTemplate = new RestTemplate();
        Coin[] coins = restTemplate.getForObject("https://api.coinmarketcap.com/v1/ticker/", Coin[].class);
        return Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("verge")).toArray(Coin[]::new);
    }
}
