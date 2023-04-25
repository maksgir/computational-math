package com.maksgir.backend.controller;


import com.maksgir.backend.dto.Answer;
import com.maksgir.backend.dto.Point;
import com.maksgir.backend.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MathController {

    @Autowired
    private MathService service;

    @PostMapping("/submit")
    public Answer solve(@RequestBody List<Point> points) {
        System.out.println(points.size());
        points.forEach(System.out::println);

        return service.solve(points);
    }
}
