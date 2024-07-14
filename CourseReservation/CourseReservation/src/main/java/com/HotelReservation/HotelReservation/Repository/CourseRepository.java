package com.HotelReservation.HotelReservation.Repository;

import com.HotelReservation.HotelReservation.Model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<CourseModel,Integer> {

}
