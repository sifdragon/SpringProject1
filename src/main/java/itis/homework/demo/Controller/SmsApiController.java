package itis.homework.demo.Controller;


import itis.homework.demo.Dto.SmsText;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import sun.rmi.runtime.Log;

import java.net.URI;


@RestController
@RequestMapping("/api/sms-management/")
@Slf4j
public class SmsApiController {


    @Autowired
    private RestTemplate restTemplate;

    // https://email:api_key@gate.smsaero.ru/v2/sms/send?number=79000000000&text=youtext&sign=SMS Aero&channel=DIRECT

    @PostMapping("/sms/send")
    public String sendSms(@RequestParam("phone") String phone, @RequestBody SmsText text) {
        String uri = "https://gate.smsaero.ru" +
                "/v2/sms/send?number=" + phone + "&text=" + text.getText() + "&channel=DIRECT&sign=SMS%20Aero";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic d2lzdGZ1bGRyQG1haWwucnU6R3owbTdBWHY3WHdQZUhzcGJ2YTJPYkZqUzVXUQ==");
        RequestEntity<Void> requestEntity = new RequestEntity<>(headers,HttpMethod.GET, URI.create(uri));
        return restTemplate.exchange(requestEntity, String.class).getBody();
    }
}

