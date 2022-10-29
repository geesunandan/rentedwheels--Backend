package com.example.demo.Repository;

import com.example.demo.Entity.VehicleRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRatingRepository extends JpaRepository<VehicleRating, Integer> {
}
