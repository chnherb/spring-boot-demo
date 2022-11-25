package com.chnherb.boot.bean;

import lombok.Data;

@Data
public class Color {
    private String value;
    public Color(String value) {
        this.value = value;
    }
}
