package com.tricentis.demowebshop.tests.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PojoResponseCart {
    private Boolean success;
    private String    message,
            updatetopcartsectionhtml;
}
