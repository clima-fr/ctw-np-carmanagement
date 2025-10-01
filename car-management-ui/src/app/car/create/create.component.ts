import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CarService } from '../../service/car.service';
import { Car } from '../../model/car';

@Component({
  selector: 'app-create',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './create.component.html',
  styleUrl: './create.component.css'
})
export class CreateComponent {
  car: Car = {} as Car;
  message: string = '';

  constructor(
    private carService: CarService, 
    private router: Router
  ) {}

  createCar(): void {
    this.carService.create(this.car).subscribe({
      next: () => {
        this.message = 'Car added successfully!';
       
        setTimeout(() => this.router.navigate(['/car/index']), 1000);
      },
      error: (err: any) => {
        this.message = 'Error adding car: ' + err;
      }
    });
  }
}
