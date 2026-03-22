import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Doctor } from '../models/doctor';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  private baseUrl = "http://localhost:8181/api/v1/doctors";
  constructor(private http: HttpClient) { }

  getAllDoctors(): Observable<any> {
    return this.http.get<any>(this.baseUrl)
    .pipe(map(response => response.data));
  }

  createDoctor(doctor: Doctor): Observable<any> {
    return this.http.post(`${this.baseUrl}`, doctor);
  }

  getDoctorById(id: number): Observable<any> {
    // alert(id);
    return this.http.get<any>(`${this.baseUrl}/${id}`)
    .pipe(map(response => response.data));
  }

  updateDoctor(doctorId: number, doctor: Doctor): Observable<any> {
    return this.http.put(`${this.baseUrl}/${doctorId}`, doctor);
  }

    deleteDoctorById(doctorId: number):Observable<any> {
    return this.http.delete(`${this.baseUrl}/${doctorId}`);
  }
}
