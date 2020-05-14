package com.wangshuai.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "city")
public class MyProperties {

    private List<String> arr;
}
