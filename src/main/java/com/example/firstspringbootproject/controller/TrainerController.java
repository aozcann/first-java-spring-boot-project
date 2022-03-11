package com.example.firstspringbootproject.controller;

import com.example.firstspringbootproject.model.Lesson;
import com.example.firstspringbootproject.model.Trainer;
import com.example.firstspringbootproject.service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/trainer")

@RequiredArgsConstructor
@RestController
public class TrainerController {
    private final TrainerService trainerService;

    @GetMapping("/")
    ResponseEntity<List<Trainer>> getAllTrainer(){
        List<Trainer> trainers = trainerService.getAllTrainers();
        return new ResponseEntity<>(trainers, HttpStatus.OK);
    }
}
