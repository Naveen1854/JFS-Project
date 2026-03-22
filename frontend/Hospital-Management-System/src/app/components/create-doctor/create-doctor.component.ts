import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Doctor } from '../../models/doctor';
import { DoctorService } from '../../service/doctor.service';

@Component({
  selector: 'app-create-doctor',
  standalone: true,
  imports: [FormsModule, HttpClientModule, CommonModule],
  providers: [DoctorService],
  templateUrl: './create-doctor.component.html',
  styleUrl: './create-doctor.component.css'
})
export class CreateDoctorComponent {


  doctor:Doctor=new Doctor();
  constructor(private doctorService:DoctorService, private router:Router){}

  onSubmit(){
    alert("Submit");
    this.saveDoctor();
  }

saveDoctor(){
  this.doctorService.createDoctor(this.doctor)
  .subscribe(
    data=>{
      console.log("Doctor saved successfully");
      this.goToDoctorList();
    },
    error=>console.log(error)
  );
}
  goToDoctorList() {
    this.router.navigate(['/doctors-list']);
  }
}
