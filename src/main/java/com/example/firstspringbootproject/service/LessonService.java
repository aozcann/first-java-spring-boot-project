package com.example.firstspringbootproject.service;

import com.example.firstspringbootproject.exception.RecordNotFoundException;
import com.example.firstspringbootproject.model.Customer;
import com.example.firstspringbootproject.model.Lesson;
import com.example.firstspringbootproject.model.request.CreateLessonRequest;
import com.example.firstspringbootproject.model.request.UpdateLessonRequest;
import com.example.firstspringbootproject.model.response.DeleteLessonResponse;
import com.example.firstspringbootproject.repository.LessonRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor

public class LessonService {
    private final LessonRepository lessonRepository;

    public List<Lesson> getAllLesson() {
//        List<Lesson> lessons = new ArrayList<>();
//        Lesson lesson1 = new Lesson();
//        lesson1.setId(1L);
//        lesson1.setBranch("Kick-boks");
//        lesson1.setDate("2022/03/10");
//        lesson1.setStartDate("2022/03/11");
//        lesson1.setEndDate("2022/04/25");
//        lesson1.setTotalLessonCount(12);
//        lesson1.setCurrentLessonCount(5);
//        lessons.add(lesson1);
//
        return lessonRepository.findAll();
    }

    public Lesson getLessonById(Long id) throws RecordNotFoundException {
            Lesson lesson = lessonRepository.findById(id).orElseThrow(() -> new  RecordNotFoundException("bu lesson bulunamadı"));
            return lesson;
        }

    public Lesson createLesson(CreateLessonRequest request) {
        Lesson lesson = new Lesson();
        lesson.setBranch(request.getBranch());
        lesson.setDate(request.getDate());
        lesson.setStartDate(request.getStartDate());
        lesson.setEndDate(request.getEndDate());
        lesson.setTotalLessonCount(request.getTotalLessonCount());
        lesson.setCurrentLessonCount(request.getCurrentLessonCount());
        return lessonRepository.save(lesson);
    }

    public Lesson updateLesson(UpdateLessonRequest request) throws RecordNotFoundException {
        Lesson updateLesson = lessonRepository.findById(request.getId()).orElseThrow(() -> new RecordNotFoundException("Bu id li lesson bulunamadı"));
        if (Objects.nonNull(request.getBranch())){
            updateLesson.setBranch(request.getBranch());
        }
        if (Objects.nonNull(request.getDate())){
            updateLesson.setDate(request.getDate());
        }
        if (Objects.nonNull(request.getStartDate())){
            updateLesson.setStartDate(request.getStartDate());
        }
        if (Objects.nonNull(request.getEndDate())){
            updateLesson.setEndDate(request.getEndDate());
        }
        if (Objects.nonNull(request.getTotalLessonCount())){
            updateLesson.setTotalLessonCount(request.getTotalLessonCount());
        }
        if (Objects.nonNull(request.getCurrentLessonCount())){
            updateLesson.setCurrentLessonCount(request.getCurrentLessonCount());
        }
        return lessonRepository.save(updateLesson);
    }

    public DeleteLessonResponse deleteLessonById(Long id) throws RecordNotFoundException {
        try {
            lessonRepository.deleteById(id);
            DeleteLessonResponse response = new DeleteLessonResponse();
            response.setResponse(true);
            return response;
        } catch (Exception e) {
            throw new RecordNotFoundException("Bu id'li lesson bulunmuyor.");
        }
    }
}
