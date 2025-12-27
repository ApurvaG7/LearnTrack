package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Trainer;

import java.util.ArrayList;
import java.util.List;

public class TrainerRepository {

    private final List<Trainer> trainers = new ArrayList<>();

    public void addTrainer(Trainer trainer) {
        trainers.add(trainer);
    }

    public List<Trainer> getAllTrainers() {
        return trainers;
    }

    public Trainer findById(int id) {
        for (Trainer trainer : trainers) {
            if (trainer.getId() == id) {
                return trainer;
            }
        }
        return null;
    }
}
