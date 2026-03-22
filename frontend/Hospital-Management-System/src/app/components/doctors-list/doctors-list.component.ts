import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Doctor } from '../../models/doctor';
import { DoctorService } from '../../service/doctor.service';

@Component({
  selector: 'app-doctors-list',
  standalone: true,
  imports: [HttpClientModule, CommonModule],
  providers: [DoctorService, CommonModule],
  templateUrl: './doctors-list.component.html',
  styleUrl: './doctors-list.component.css'
})
export class DoctorsListComponent {

  doctors: Observable<Doctor[]>;

  constructor(private doctorService: DoctorService, private router: Router) { }

  ngOnInit(): void {
    this.getAllDoctors();
  }

  // GetAll
  getAllDoctors() {
    this.doctors = this.doctorService.getAllDoctors();
  }

  editWithDoctorId(doctorId: number) {
    this.router.navigate(['/updateDoctor', doctorId]);
  }

  deleteDoctor(doctorId: number) {
    this.doctorService.deleteDoctorById(doctorId).subscribe(data=>{
      this.getAllDoctors()
    }, error=>console.log(error));
  }
}
