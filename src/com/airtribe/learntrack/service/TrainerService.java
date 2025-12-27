package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Trainer;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.TrainerRepository;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;

import java.util.List;

public class TrainerService {

    private final TrainerRepository trainerRepository = new TrainerRepository();

    public void addTrainer(String firstName, String lastName, String email, String expertise) {
        InputValidator.validateName(firstName, "First Name");
        InputValidator.validateName(lastName, "Last Name");
        InputValidator.validateEmail(email);

        int id = IdGenerator.getNextTrainerId(); // shared Person-style ID is OK
        Trainer trainer = new Trainer(id, firstName, lastName, email, expertise);
        trainerRepository.addTrainer(trainer);
    }

    public List<Trainer> listTrainers() {
        return trainerRepository.getAllTrainers();
    }

    public Trainer getTrainerById(int id) {
        Trainer trainer = trainerRepository.findById(id);
        if (trainer == null) {
            throw new EntityNotFoundException("Trainer not found with ID: " + id);
        }
        return trainer;
    }
}
