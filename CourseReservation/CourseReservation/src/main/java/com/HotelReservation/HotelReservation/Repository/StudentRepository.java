package com.HotelReservation.HotelReservation.Repository;

import com.HotelReservation.HotelReservation.Model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentModel,Integer> {

}
