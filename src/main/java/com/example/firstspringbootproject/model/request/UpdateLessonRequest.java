package com.example.firstspringbootproject.model.request;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
public class UpdateLessonRequest {
    private Long id;
    private String branch;
    private String date;
    private String startDate;
    private String endDate;
    private int totalLessonCount;
    private int currentLessonCount;
}
