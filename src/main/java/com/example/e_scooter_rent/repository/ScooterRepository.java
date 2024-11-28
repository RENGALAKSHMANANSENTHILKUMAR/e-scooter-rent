package com.example.e_scooter_rent.repository;

import com.example.e_scooter_rent.model.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScooterRepository  extends JpaRepository<Scooter, Long> {

    List<Scooter> findByIsAvailableTrue();
}
