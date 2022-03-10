package com.example.firstspringbootproject.service;

import com.example.firstspringbootproject.model.Trainer;
import com.example.firstspringbootproject.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TrainerService {
    private final TrainerRepository trainerRepository;

    public List<Trainer> getAllTrainers(){
        List<Trainer> trainers = new ArrayList<>();
        Trainer trainer1 = new Trainer();
        trainer1.setId(1L);
        trainer1.setName("Ahmet");
        trainer1.setSurname("Fidan");
        trainer1.setEmail("ahmetfidan@kickboks.gov.tr");
        trainer1.setPhoneNumber("05555555555");
        trainer1.setBranch("Kick-boks");
        trainers.add(trainer1);

        Trainer trainer2 = new Trainer();
        trainer2.setId(2L);
        trainer2.setName("Furkan");
        trainer2.setSurname("Şanli");
        trainer2.setEmail("furkanşanli@gmail.com");
        trainer2.setPhoneNumber("05555555551");
        trainer2.setBranch("Fitness");
        trainers.add(trainer2);

        Trainer trainer3 = new Trainer();
        trainer3.setId(3L);
        trainer3.setName("Gamze");
        trainer3.setSurname("Özdil");
        trainer3.setEmail("gülnoza@gmail.com");
        trainer3.setPhoneNumber("05555555552");
        trainer3.setBranch("Pilates");
        trainers.add(trainer3);

        return trainers;



    };

}
