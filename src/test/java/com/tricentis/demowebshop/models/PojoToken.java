package com.tricentis.demowebshop.models;

import lombok.Data;

import java.util.Map;

@Data

public class PojoToken {
    private Map<String, String> cookies;

}
