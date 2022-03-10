package com.example.firstspringbootproject.service;

import com.example.firstspringbootproject.model.Lesson;
import com.example.firstspringbootproject.repository.LessonRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class LessonService {
    private final LessonRepository lessonRepository;

    public List<Lesson> getAllLesson() {
        List<Lesson> lessons = new ArrayList<>();
        Lesson lesson1 = new Lesson();
        lesson1.setId(1L);
        lesson1.setBranch("Kick-boks");
        lesson1.setDate("2022/03/10");
        lesson1.setStartDate("2022/03/11");
        lesson1.setEndDate("2022/04/25");
        lesson1.setTotalLessonCount(12);
        lesson1.setCurrentLessonCount(5);
        lessons.add(lesson1);

        return lessons;
    }

    {

    }
}
