package com.example.e_scooter_rent.service;

import com.example.e_scooter_rent.model.Scooter;
import com.example.e_scooter_rent.repository.ScooterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ScooterService {

    @Autowired
    private ScooterRepository scooterRepository;

    public List<Scooter> getAvailableScooters(){
        return scooterRepository.findByIsAvailableTrue();
    }
}
