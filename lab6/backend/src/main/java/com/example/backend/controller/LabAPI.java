package com.example.backend.controller;


import com.example.backend.dto.ServiceAnswer;
import com.example.backend.dto.InputParams;
import com.example.backend.service.SolvingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LabAPI {

    @Autowired
    private SolvingService service;


    @PostMapping("/submit")
    public ServiceAnswer solve(@RequestBody InputParams input) {

        return service.solve(input);
    }
}
