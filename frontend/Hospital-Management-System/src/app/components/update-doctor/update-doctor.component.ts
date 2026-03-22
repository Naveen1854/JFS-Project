import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Doctor } from '../../models/doctor';
import { DoctorService } from '../../service/doctor.service';

@Component({
  selector: 'app-update-doctor',
  standalone: true,
  imports: [FormsModule, HttpClientModule, CommonModule],
  providers: [DoctorService],
  templateUrl: './update-doctor.component.html',
  styleUrl: './update-doctor.component.css'
})
export class UpdateDoctorComponent {

  doctorId:number;
  doctor:Doctor = new Doctor();

  successMessage = "";
  
  constructor(private doctorService:DoctorService, private router:Router, private route:ActivatedRoute){}

  ngOnInit(): void{
    this.doctorId=this.route.snapshot.params['id'];
    this.doctorService.getDoctorById(this.doctorId).subscribe(data=>{
      
      //console.log("Doctor Data:", data); 
      alert(JSON.stringify(data));
      
      this.doctor=data;
      // alert(data);
    }, error=>console.log(error));
  }

  onSubmit(){
    alert("Submit");
    this.updateDoctorById();
  }

  updateDoctorById(){
    this.doctorService.updateDoctor(this.doctorId, this.doctor).subscribe(data=>{
      this.successMessage = "Doctor Updated Successfully!🎉";

      setTimeout(() =>{
        this.goToDoctorListPage();
      }, 1500);
    }, error=>console.log(error));
  }


  goToDoctorListPage() {
    this.router.navigate(['/doctors-list'])
  }
}
