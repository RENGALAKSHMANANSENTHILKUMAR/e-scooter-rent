package com.example.e_scooter_rent.repository;

import com.example.e_scooter_rent.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository  extends JpaRepository<Rental, Long> {

}
