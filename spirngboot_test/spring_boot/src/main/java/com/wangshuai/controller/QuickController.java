package com.wangshuai.controller;

import com.wangshuai.property.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@EnableConfigurationProperties(MyProperties.class)
public class QuickController {
   @Autowired
   private MyProperties prop;

    @Value("${name}")
    private String name;

    @GetMapping("quick")
    public ResponseEntity<String> quick() {

        return ResponseEntity.ok("cities :" + prop.getArr());
    }
}
