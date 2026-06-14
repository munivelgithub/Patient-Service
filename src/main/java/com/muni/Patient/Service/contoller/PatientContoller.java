package com.muni.Patient.Service.contoller;

import com.muni.Patient.Service.dto.PatientRequestDTO;
import com.muni.Patient.Service.dto.PatientResponseDTO;
import com.muni.Patient.Service.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
public class PatientContoller {

    private final PatientService patientService;

    public PatientContoller (PatientService service){
        this.patientService=service;
    }

    @GetMapping("/getPatients")
    public ResponseEntity<List<PatientResponseDTO>> getPatients(){
        return new ResponseEntity<>(patientService.getPatients(), HttpStatus.OK);
        //ResponseEntity.ok().body(patientService.getPatients());
    }
    @GetMapping("/{uuid}")
    public ResponseEntity<PatientResponseDTO> getPatientByid(@PathVariable
                                                             UUID uuid){
        PatientResponseDTO user=patientService.getUserByUUID(uuid);
        return ResponseEntity.ok().body(user);
    }

     @PostMapping("/addUser")
    public ResponseEntity<PatientResponseDTO> addUser(@Valid @RequestBody PatientRequestDTO requestDTO){
        PatientResponseDTO dto1=patientService.adduser(requestDTO);
        return ResponseEntity.ok().body(dto1);
     }
     @GetMapping("patient")
    public ResponseEntity<PatientResponseDTO> findByNames(@RequestParam String name){
        PatientResponseDTO patientResponseDTO=patientService.findByName(name);
        return new ResponseEntity<>(patientResponseDTO,HttpStatus.OK);
     }
}




