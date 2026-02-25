package com.project.controller;

import com.project.dto.DoctorDto;
import com.project.service.DoctorService;
import com.project.util.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    public ResponseEntity<SuccessResponse<DoctorDto>> saveDoctor(DoctorDto doctorDto){
        DoctorDto savedDoctor = doctorService.saveDoctor(doctorDto);
        SuccessResponse<DoctorDto> response = new SuccessResponse<>(
          "Doctor Saved Successfully",
                HttpStatus.CREATED.value(),
                savedDoctor
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
