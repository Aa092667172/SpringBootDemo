package com.controller;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {
    /**/
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id
            , @PathVariable("username") String name
            , @PathVariable Map<String, String> pv
            , @RequestHeader("User-Agent") String userAgent
            , @RequestHeader Map<String, String> header
            , @RequestParam("age") Integer age
            , @RequestParam("inters") List<String> list
            , @RequestParam MultiValueMap<String, String> parameter
            , @CookieValue("Cookie_1") String cookie_1
            , @CookieValue("Cookie_1") Cookie cookie) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("pv", pv);
        map.put("header", header);
        map.put("age", age);
        map.put("inters", list);
        map.put("cookie_1", cookie_1);
        map.put("parameter", parameter);
        map.put("cookie", cookie);
        System.out.println(cookie.getName());
        System.out.println(cookie.getValue());

        return map;
    }

    @PostMapping("/save")
    public Map<String, String> postMethod(@RequestBody String content) {
        Map<String, String> map = new HashMap<>();
        map.put("content", content);
        return map;
    }

}
