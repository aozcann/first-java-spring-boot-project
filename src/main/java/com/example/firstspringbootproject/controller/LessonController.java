package com.example.firstspringbootproject.controller;

import com.example.firstspringbootproject.exception.RecordNotFoundException;
import com.example.firstspringbootproject.model.Lesson;
import com.example.firstspringbootproject.model.request.CreateLessonRequest;
import com.example.firstspringbootproject.model.request.UpdateLessonRequest;
import com.example.firstspringbootproject.model.response.DeleteLessonResponse;
import com.example.firstspringbootproject.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/lesson")

@RequiredArgsConstructor
@RestController
public class LessonController {
    private final LessonService lessonService;

    @GetMapping("/")
    ResponseEntity<List<Lesson>> GetAllLesson() {
        List<Lesson> lessons = lessonService.getAllLesson();
        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    ResponseEntity<Lesson> getLessonById(@PathVariable String id) throws RecordNotFoundException {
        Lesson lesson = lessonService.getLessonById(Long.valueOf(id));
        return new ResponseEntity<>(lesson, HttpStatus.OK);
    }

    @PostMapping("/")
    ResponseEntity<Lesson> createLesson(@RequestBody CreateLessonRequest request) {
        Lesson lesson = lessonService.createLesson(request);
        return new ResponseEntity<>(lesson, HttpStatus.OK);
    }

    @PutMapping("/")
    ResponseEntity<Lesson> updateLesson(@RequestBody UpdateLessonRequest request) throws RecordNotFoundException {
        Lesson lesson = lessonService.updateLesson(request);
        return new ResponseEntity<>(lesson, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<DeleteLessonResponse> deleteLessonById(@PathVariable String id) throws RecordNotFoundException {
        DeleteLessonResponse response = lessonService.deleteLessonById(Long.valueOf(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
