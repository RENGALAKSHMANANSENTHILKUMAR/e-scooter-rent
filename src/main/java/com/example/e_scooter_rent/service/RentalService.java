package com.example.e_scooter_rent.service;

import com.example.e_scooter_rent.model.Rental;
import com.example.e_scooter_rent.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    public Rental startRental(Rental rental){
        return rentalRepository.save(rental);
    }

    public void endRental(Long rentalId, LocalDateTime rentalEndTime, Double amount){

        Rental rental = rentalRepository.findById(rentalId).orElseThrow();
        rental.setRentalEndTime(rentalEndTime);
        rental.setAmount(amount);
        rentalRepository.save(rental);
    }
}
