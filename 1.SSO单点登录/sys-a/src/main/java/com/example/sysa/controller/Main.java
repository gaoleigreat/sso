package com.example.sysa.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.sysa.entity.ReturnEntity;
import com.example.sysa.entity.UserContext;
import com.example.sysa.util.HttpClient;
import com.example.sysa.util.RestfulHttpClient;
import com.example.sysa.util.UserContextHolder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/1 14:08
 */
@RestController
public class Main {

    @Value("${sso_server}")
    private String serverHost;

    @RequestMapping("/test")
    public ReturnEntity test() {
        return new ReturnEntity(1, "通过验证", null);
    }


    @RequestMapping("/logout")
    public ReturnEntity logout() throws Exception {
        UserContext context = UserContextHolder.get();
        HttpClient.get(serverHost + "/inValid?token=" + context.getToken());
        return null;
    }

    @PostMapping("/login1")
    public ReturnEntity login(String name,String password) throws IOException {
        String url = "http://localhost:48080/sso/login";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("password", password);
        Map<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        RestfulHttpClient.HttpResponse httpResponse = RestfulHttpClient.request("post", url, jsonObject, map);
        return ReturnEntity.successResult(JSONObject.parseObject(httpResponse.getContent()).get("data"));
    }
}
