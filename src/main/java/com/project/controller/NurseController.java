package com.project.controller;

import com.project.dto.NurseDto;
import com.project.service.NurseService;
import com.project.util.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nurses")
public class NurseController {

    private final NurseService nurseService;
    public NurseController(NurseService nurseService) {
        this.nurseService = nurseService;
    }

    @PostMapping
    public ResponseEntity<SuccessResponse<NurseDto>> saveNurse(@RequestBody NurseDto nurseDto) {
        NurseDto savedNurse = nurseService.saveNurse(nurseDto);
        SuccessResponse<NurseDto> response = new SuccessResponse<>(
                "Nurse saved successfully",
                HttpStatus.CREATED.value(),
                savedNurse
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<SuccessResponse<List<NurseDto>>> getAllNurses() {
        List<NurseDto> nurses = nurseService.getAllNurses();
        SuccessResponse<List<NurseDto>> response = new SuccessResponse<>(
                "All Nurses fetched successfully",
                HttpStatus.OK.value(), 
                nurses
        );
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{nurseId}")
    public ResponseEntity<SuccessResponse<NurseDto>> getNurseById(@PathVariable Long nurseId) {
        NurseDto nurse = nurseService.getNurseById(nurseId);
        SuccessResponse<NurseDto> response = new SuccessResponse<>(
                "Nurse fetched successfully",
                HttpStatus.OK.value(),
                nurse
        );
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{nurseId}")
    public ResponseEntity<SuccessResponse<NurseDto>> updateNurse(@PathVariable Long nurseId, @RequestBody NurseDto nurseDto) {
        NurseDto updateNurse = nurseService.updateNurseById(nurseId, nurseDto);
        SuccessResponse<NurseDto> response = new SuccessResponse<>(
                "Nurse updated successfully by id",
                HttpStatus.OK.value(),
                updateNurse
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{nurseId}")
    public ResponseEntity<SuccessResponse<NurseDto>> deleteNurse(@PathVariable Long nurseId) {
        NurseDto deletedNurse = nurseService.deleteNurseById(nurseId);
        SuccessResponse<NurseDto> response = new SuccessResponse<>(
                "Nurse deleted successfully by id",
                HttpStatus.OK.value(),
                deletedNurse
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search/email")
    public ResponseEntity<SuccessResponse<NurseDto>> getNurseByEmail(@RequestParam String emailId) {
        NurseDto nurse = nurseService.getNurseByEmailId(emailId);
        SuccessResponse<NurseDto> response = new SuccessResponse<>(
                "Nurse fetched successfully by email",
                HttpStatus.OK.value(),
                nurse
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search/name/{nurseName}")
    public ResponseEntity<SuccessResponse<List<NurseDto>>> getNursesByName(@PathVariable String nurseName) {
        List<NurseDto> nurses = nurseService.getNursesByName(nurseName);
        SuccessResponse<List<NurseDto>> response = new SuccessResponse<>(
                "Nurses fetched successfully by name",
                HttpStatus.OK.value(),
                nurses
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search/department/{departmentId}")
    public ResponseEntity<SuccessResponse<List<NurseDto>>> getNursesByDepartmentId(@PathVariable Long departmentId) {
        List<NurseDto> nurses = nurseService.getNursesByDepartmentId(departmentId);
        SuccessResponse<List<NurseDto>> response = new SuccessResponse<>(
                "Nurses fetched successfully by department",
                HttpStatus.OK.value(),
                nurses
        );
        return ResponseEntity.ok(response);
    }
}
