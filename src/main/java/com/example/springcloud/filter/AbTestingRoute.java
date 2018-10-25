package com.example.springcloud.filter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class AbTestingRoute {

    private String active;
    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    //决定是否使用替代服务
    public boolean useSpecialRoute(AbTestingRoute testRoute){
        Random random = new Random();
        if (testRoute.getActive().equals("N")) return false;
        int value = random.nextInt((10 -1) + 1) + 1;
        if (testRoute.getWeight() < value) return true;
        return false;
    }
}
