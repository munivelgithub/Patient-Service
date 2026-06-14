package com.muni.Patient.Service.repository;

import com.muni.Patient.Service.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    boolean existsByEmail(String email);
    @Query(value = "select * from Patient where name=:patient_name",nativeQuery = true)
    Patient findByNames(@Param("patient_name") String name);

}
