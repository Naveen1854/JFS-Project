package com.project.controller;

import com.project.dto.DoctorDto;
import com.project.service.DoctorService;
import com.project.util.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<SuccessResponse<DoctorDto>> saveDoctor(@RequestBody DoctorDto doctorDto){
        DoctorDto savedDoctor = doctorService.saveDoctor(doctorDto);
        SuccessResponse<DoctorDto> response = new SuccessResponse<>(
          "Doctor Saved Successfully",
                HttpStatus.CREATED.value(),
                savedDoctor
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<SuccessResponse<List<DoctorDto>>> getAllDoctors(){
       List<DoctorDto> doctors = doctorService.getAllDoctors();
       SuccessResponse<List<DoctorDto>> response = new SuccessResponse<>(
               "Doctors fetched Successfully",
               HttpStatus.OK.value(),
               doctors
       );
       return ResponseEntity.ok(response);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<SuccessResponse<DoctorDto>> getDoctorById(@PathVariable Long doctorId){
        DoctorDto doctor = doctorService.getDoctorById(doctorId);
        SuccessResponse<DoctorDto> response = new SuccessResponse<>(
                "Doctor fetched by Id Successfully",
                HttpStatus.OK.value(),
                doctor
        );
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{doctorId}")
    public ResponseEntity<SuccessResponse<DoctorDto>> updateDoctorById(@PathVariable Long doctorId, @RequestBody DoctorDto newDoctorDto){
        DoctorDto updated = doctorService.updateDoctorById(doctorId, newDoctorDto);
        SuccessResponse<DoctorDto> response = new SuccessResponse<>(
                "Doctor updated by id Successfully",
                HttpStatus.OK.value(),
                updated
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{doctorId}")
    public ResponseEntity<SuccessResponse<DoctorDto>>  deleteDoctorById(@PathVariable Long doctorId){
        DoctorDto deleted = doctorService.deleteDoctorById(doctorId);
        SuccessResponse<DoctorDto> response = new SuccessResponse<>(
                "Doctor deleted successfully by Id",
                HttpStatus.OK.value(),
                deleted
        );
        return ResponseEntity.ok(response);
    }
}
