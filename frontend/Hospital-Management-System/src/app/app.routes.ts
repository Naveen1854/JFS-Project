import { Routes } from '@angular/router';
import { CreateDoctorComponent } from './components/create-doctor/create-doctor.component';
import { DoctorsListComponent } from './components/doctors-list/doctors-list.component';
import { UpdateDoctorComponent } from './components/update-doctor/update-doctor.component';

export const routes: Routes = [
    {
        path: "doctors-list",
        component: DoctorsListComponent
    },
    {
        path: "createDoctor",
        component: CreateDoctorComponent
    },
    {
        path: "updateDoctor/:id",
        component: UpdateDoctorComponent
    },
    //  {
    //     path: "getDoctor",
    //     component: UpdateDoctorComponent
    // },
];
