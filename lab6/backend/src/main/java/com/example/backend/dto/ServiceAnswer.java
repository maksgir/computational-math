package com.example.backend.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString()
@AllArgsConstructor
public class ServiceAnswer {
    List<Point> exactPoints;
    List<Point> eulerPoints;
    List<Point> rungePoints;
    List<Point> milnPoints;
    String errorMsg;

}


