package com.example.firstspringbootproject.service;

import com.example.firstspringbootproject.exception.RecordNotFoundException;
import com.example.firstspringbootproject.model.Trainer;
import com.example.firstspringbootproject.model.Trainer;
import com.example.firstspringbootproject.model.request.CreateTrainerRequest;
import com.example.firstspringbootproject.model.request.UpdateTrainerRequest;
import com.example.firstspringbootproject.model.response.DeleteTrainerResponse;
import com.example.firstspringbootproject.model.response.DeleteTrainerResponse;
import com.example.firstspringbootproject.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor

public class TrainerService {
    private final TrainerRepository trainerRepository;

    public List<Trainer> getAllTrainers(){
//        List<Trainer> trainers = new ArrayList<>();
//        Trainer trainer1 = new Trainer();
//        trainer1.setId(1L);
//        trainer1.setName("Ahmet");
//        trainer1.setSurname("Fidan");
//        trainer1.setEmail("ahmetfidan@kickboks.gov.tr");
//        trainer1.setPhoneNumber("05555555555");
//        trainer1.setBranch("Kick-boks");
//        trainers.add(trainer1);
//
//        Trainer trainer2 = new Trainer();
//        trainer2.setId(2L);
//        trainer2.setName("Furkan");
//        trainer2.setSurname("Şanli");
//        trainer2.setEmail("furkanşanli@gmail.com");
//        trainer2.setPhoneNumber("05555555551");
//        trainer2.setBranch("Fitness");
//        trainers.add(trainer2);
//
//        Trainer trainer3 = new Trainer();
//        trainer3.setId(3L);
//        trainer3.setName("Gamze");
//        trainer3.setSurname("Özdil");
//        trainer3.setEmail("gülnoza@gmail.com");
//        trainer3.setPhoneNumber("05555555552");
//        trainer3.setBranch("Pilates");
//        trainers.add(trainer3);
        List<Trainer> trainers = trainerRepository.findAll();
        return trainers;



    };

    public Trainer getTrainersById(Long id) throws RecordNotFoundException {
        Trainer trainer = trainerRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("Bu idli trainer bulunamadı"));
        return trainer;
    }

    public Trainer createTrainer(CreateTrainerRequest request) {
        Trainer trainer = new Trainer();
        trainer.setName(request.getName());
        trainer.setSurname(request.getSurname());
        trainer.setEmail(request.getEmail());
        trainer.setPhoneNumber(request.getPhoneNumber());
        trainer.setBranch(request.getBranch());
        return trainerRepository.save(trainer);
    }

    public Trainer updateTrainer(UpdateTrainerRequest request) throws RecordNotFoundException {
        Trainer updatedTrainer = trainerRepository.findById(request.getId()).orElseThrow(() -> new RecordNotFoundException("Bu İd ile trainer bulunamadı"));
        if (Objects.nonNull(request.getName())){
            updatedTrainer.setName(request.getName());
        }
        if (Objects.nonNull(request.getSurname())){
            updatedTrainer.setSurname(request.getSurname());
        }
        if (Objects.nonNull(request.getEmail())){
            updatedTrainer.setEmail(request.getEmail());
        }
        if (Objects.nonNull(request.getPhoneNumber())){
            updatedTrainer.setPhoneNumber(request.getPhoneNumber());
        }
        if (Objects.nonNull(request.getBranch())){
            updatedTrainer.setBranch(request.getBranch());
        }
        return trainerRepository.save(updatedTrainer);
    }

    public DeleteTrainerResponse deleteTrainerById(Long id) throws RecordNotFoundException {
        try {
            trainerRepository.deleteById(id);
            DeleteTrainerResponse response = new DeleteTrainerResponse();
            response.setResponse(true);
            return response;
        } catch (Exception e){
            throw new RecordNotFoundException("Bu idli bir trainer bulunmamaktadır");
        }
    }
}
