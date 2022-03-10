package com.example.firstspringbootproject.controller;

import com.example.firstspringbootproject.model.Lesson;
import com.example.firstspringbootproject.service.LessonService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/lessons")

@RequiredArgsConstructor
@RestController
public class LessonController {
    private final LessonService lessonService;

    @GetMapping("/")
    ResponseEntity<List<Lesson>> GetAllLesson() {
        List<Lesson> lessons = lessonService.getAllLesson();
        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }
}
