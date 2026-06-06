package com.muni.Patient.Service.service;
import com.muni.Patient.Service.dto.PatientRequestDTO;
import com.muni.Patient.Service.dto.PatientResponseDTO;
import com.muni.Patient.Service.globalException.EmailAlreadyExistException;
import com.muni.Patient.Service.mapper.PatientMapper;
import com.muni.Patient.Service.model.Patient;
import com.muni.Patient.Service.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService {
    private PatientRepository patientRepository;


    public PatientService(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }

    public List<PatientResponseDTO> getPatients(){
        List<Patient> patients=patientRepository.findAll();
        // now we need to convert an patients entity objects to the patients response objects
        // each of patient create helper claa accept domain entity model and return an dto
        List<PatientResponseDTO> patientResponseDTOS=
                patients.stream().map(patient -> PatientMapper.toDTO(patient)).toList();
        return patientResponseDTOS;
    }

    public PatientResponseDTO getUserByUUID(UUID uuid) {
        Optional<Patient> optionalPatient=patientRepository.findById(uuid);
        if(optionalPatient.isPresent()){
            PatientResponseDTO responseDTO=PatientMapper.toDTO(optionalPatient.get());
            return responseDTO;
        }
        return new PatientResponseDTO();
    }

    public PatientResponseDTO adduser(PatientRequestDTO dto) {
        if(patientRepository.existsByEmail(dto.getEmail())){
            throw new EmailAlreadyExistException("A patient email is already exist"+dto.getEmail());
        }

        Patient patient=PatientMapper.DTOtoNoraml(dto);
        patientRepository.save(patient);
        PatientResponseDTO responseDTO=PatientMapper.toDTO(patient);
        return responseDTO;
    }
}
