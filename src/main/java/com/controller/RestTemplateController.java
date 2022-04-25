package com.controller;

import com.model.Video;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestTemplateController {
    @GetMapping("/getForObject")
    public Video getForObject() {
        RestTemplate restTemplate = new RestTemplate();
        Video video = restTemplate.getForObject(
                "https://mocki.io/v1/cd04278e-509c-40bd-9d9e-51db6d8f8b08",
                Video.class);
        System.out.println("取得的id=" + video.getId());
        System.out.println("取得的name=" + video.getName());
        System.out.println("取得的number=" + video.getNumber());
        return video;
    }

    /**
     * 取得http相關資料
     * 例如:狀態碼
     *
     * @return
     */
    @GetMapping("/getForObjectEntity")
    public Video getForEntity() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Video> entity = restTemplate.getForEntity(
                "https://mocki.io/v1/cd04278e-509c-40bd-9d9e-51db6d8f8b08",
                Video.class);

        System.out.println("此次請求的狀態代碼為:" + entity.getStatusCode());

        Video body = entity.getBody();
        System.out.println("取得的id=" + body.getId());
        System.out.println("取得的name=" + body.getName());
        System.out.println("取得的number=" + body.getNumber());
        return body;
    }

    @GetMapping("/getForObjectWithParam")
    public Video getForObjectWithParam() {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> queryParamMap = new HashMap<>();
        queryParamMap.put("graduate", true);

        Video video = restTemplate.getForObject(
                "https://mocki.io/v1/cd04278e-509c-40bd-9d9e-51db6d8f8b08",
                Video.class, queryParamMap);
        //等同發送https://mocki.io/v1/cd04278e-509c-40bd-9d9e-51db6d8f8b08?graduate=true

        System.out.println("取得的id=" + video.getId());
        System.out.println("取得的name=" + video.getName());
        System.out.println("取得的number=" + video.getNumber());
        return video;
    }

    @GetMapping("/postForEntity")
    public String postForEntity() {
        RestTemplate restTemplate = new RestTemplate();
        Video video = new Video();
        video.setId(2l);
        video.setName("哈哈測試");
        video.setNumber(5487);

        ResponseEntity<Video> result = restTemplate.postForEntity(
                "https://mocki.io/v1/cd04278e-509c-40bd-9d9e-51db6d8f8b08",
                video,
                Video.class
        );
        return "postForEntity success";
    }

    @GetMapping("/postForObject")
    public String postForObject() {
        RestTemplate restTemplate = new RestTemplate();

        Video videoBody = new Video();
        videoBody.setId(2l);
        videoBody.setName("哈哈測試");
        videoBody.setNumber(5487);

        Video result = restTemplate.postForObject(
                "https://mocki.io/v1/cd04278e-509c-40bd-9d9e-51db6d8f8b08",
                videoBody,
                Video.class
        );
        return "postForObject success";
    }

    @GetMapping("/exchange")
    public String exchange() {
        RestTemplate restTemplate = new RestTemplate();
        //使用exchange 發起 Get請求
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("header1", "123");

        HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);

        Map<String, Object> queryParamMap = new HashMap<>();

        ResponseEntity<Video> getStudentEntity = restTemplate.exchange(
                "https://mocki.io/v1/cd04278e-509c-40bd-9d9e-51db6d8f8b08",
                HttpMethod.GET,
                requestEntity,
                Video.class,
                queryParamMap
        );
        //post請求
        HttpHeaders requestHeaders2 = new HttpHeaders();
        requestHeaders2.set("header2", "456");
        requestHeaders2.setContentType(MediaType.APPLICATION_JSON);

        Video videoBody = new Video();
        videoBody.setId(1l);

        HttpEntity<Video> requestEntity2 = new HttpEntity<>(videoBody, requestHeaders2);

        ResponseEntity<Video> postEntity = restTemplate.exchange(
                "https://mocki.io/v1/cd04278e-509c-40bd-9d9e-51db6d8f8b08",
                HttpMethod.POST,
                requestEntity2,
                Video.class
        );

        return "exchange成功";

    }

}
