package com.example.backend.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString()
public class InputParams {

    int functionId;
    double y0;
    double x0;
    double xn;
    double h;
    double e;


}
