package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {
    @GetMapping("goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg","成功拉");
        request.setAttribute("code","200");
        return "forward:/success";
    }


    @ResponseBody
    @GetMapping("/success")
    public Map<String, Object> success(@RequestAttribute String msg,
                                        @RequestAttribute Integer code,
                                        HttpServletRequest request){
        Object msg1 = request.getAttribute("msg");
        Map<String,Object> map = new HashMap<>();
        map.put("reqMethod_msg",msg1);
        map.put("annotation_msg",msg);
        map.put("return_code",code);

        return map;
    }


}
