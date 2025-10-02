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


  onFileSelected(event: any): void {
    const file: File = event.target.files[0];
    if (!file) {
      return; 
    }
    if (file.size > 2 * 1024 * 1024) { 
      alert("File too large. Please upload an image smaller than 2MB.");
      event.target.value = '';
      return;
    }
    const reader = new FileReader();
    reader.onload = () => {
      this.car.image = reader.result as string;
    };
    reader.readAsDataURL(file);
  }

  createCar(): void {
    this.carService.create(this.car).subscribe({
      next: () => {
        this.message = 'Car added successfully!';
        this.car = {} as Car;
      },
      error: (err: any) => {
        this.message = 'Error adding car: ' + err;
      }
    });
  }
}
