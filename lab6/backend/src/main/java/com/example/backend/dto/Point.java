package com.example.backend.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString()
@AllArgsConstructor
public class Point {
    double x;
    double y;
}
