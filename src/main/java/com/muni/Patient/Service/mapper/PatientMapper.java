package com.muni.Patient.Service.mapper;

import com.muni.Patient.Service.dto.PatientRequestDTO;
import com.muni.Patient.Service.dto.PatientResponseDTO;
import com.muni.Patient.Service.model.Patient;

import java.time.LocalDate;

public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient patient){
        PatientResponseDTO patientResponseDTO=new PatientResponseDTO();
        patientResponseDTO.setId(patient.getId().toString());
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setEmail(patient.getEmail());
        patientResponseDTO.setAddress(patient.getAddress());
        patientResponseDTO.setDateOfBirth(patient.getDateofBirth());
        return patientResponseDTO;
    }
    public static Patient DTOtoNoraml(PatientRequestDTO requestDTO){
        Patient patient=new Patient();
        patient.setName(requestDTO.getName());
        patient.setEmail(requestDTO.getEmail());
        patient.setAddress(requestDTO.getAddress());
        patient.setDateofBirth(LocalDate.parse(requestDTO.getDateOfBirth()));
        patient.setRegisteredDate(LocalDate.parse(requestDTO.getRegisteredDate()));
        return patient;
    }
}
