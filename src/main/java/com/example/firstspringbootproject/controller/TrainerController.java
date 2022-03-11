package com.example.firstspringbootproject.controller;

import com.example.firstspringbootproject.exception.RecordNotFoundException;
import com.example.firstspringbootproject.model.Trainer;
import com.example.firstspringbootproject.model.Trainer;
import com.example.firstspringbootproject.model.request.CreateTrainerRequest;
import com.example.firstspringbootproject.model.request.UpdateTrainerRequest;
import com.example.firstspringbootproject.model.response.DeleteTrainerResponse;
import com.example.firstspringbootproject.service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    ResponseEntity<Trainer> getTrainerById(@PathVariable String id) throws RecordNotFoundException {
        Trainer trainer = trainerService.getTrainersById(Long.valueOf(id));
        return new ResponseEntity<>(trainer, HttpStatus.OK);
    }

    @PostMapping("/")
    ResponseEntity<Trainer> createTrainer(@RequestBody CreateTrainerRequest request) {
        Trainer trainer = trainerService.createTrainer(request);
        return new ResponseEntity<>(trainer, HttpStatus.OK);
    }

    @PutMapping("/")
    ResponseEntity<Trainer> updateTrainer(@RequestBody UpdateTrainerRequest request) throws RecordNotFoundException {
        Trainer trainer = trainerService.updateTrainer(request);
        return new ResponseEntity<>(trainer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<DeleteTrainerResponse> deleteTrainerById(@PathVariable String id) throws RecordNotFoundException {
        DeleteTrainerResponse response = trainerService.deleteTrainerById(Long.valueOf(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
